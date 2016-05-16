package ian.net;

import java.net.URL;
import java.net.HttpURLConnection;

import java.io.RandomAccessFile;
import java.io.InputStream;


public class DownUtil{

	private String path;
	private String targetFile;
	private int threadNum;
	private DownThread[] threads;
	private int fileSize;

	public DownUtil(String path, String targetFile, int threadNum){
		this.path = path;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
		this.targetFile = targetFile;
	}

	public void download() throws Exception{
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty(
			"Accept",
			"image/gif, image/jpeg, image/pjpeg, image/png, "
			+ "application/x-shockwave-flash, application/xaml+xml, "
			+ "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
			+ "application/x-ms-application, application/vnd.ms-excel, "
			+ "application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");

		//System.out.println(conn.getContent());
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		System.out.println(fileSize);
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < threadNum; i++ ) {
			//计算每一个线程下载的开始位置
			int startPos = i * currentPartSize;
			//每个线程使用一个RandomAccessFile进行下载
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			// 定位该线程的下载位置
			currentPart.seek(startPos);
			// 创建该下载线程
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			//启动下载线程
			threads[i].start();
		}
	}
	// 截获下载完成的百分比
	public double getCompleteRate(){
		int sumSize = 0;
		for (int i = 0; i < threadNum ; i++) {
			sumSize += threads[i].length;
		}
		return sumSize * 1.0 / fileSize;
	}

	private class DownThread extends Thread{

		private int startPos;
		private int currentPartSize;
		// 当前线程需要下载的文件块
		private RandomAccessFile currentPart;
		// 定义该线程下载的字节数
		public int length;
		public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart){
			this.startPos = startPos;
			this.currentPartSize = currentPartSize;
			this.currentPart = currentPart;
		}

		public void run(){
			try{
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setConnectTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty(
					"Accept",
					"image/gif, image/jpeg, image/pjpeg, image/png, "
					+ "application/x-shockwave-flash, application/xaml+xml, "
					+ "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
					+ "application/x-ms-application, application/vnd.ms-excel, "
					+ "application/vnd.ms-powerpoint, application/msword, */*");
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "UTF-8");

				InputStream inStream = conn.getInputStream();
				inStream.skip(this.startPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				while(length < currentPartSize && (hasRead = inStream.read(buffer)) != -1){
					currentPart.write(buffer, 0, hasRead);
					length += hasRead;
				}
				currentPart.close();
				inStream.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}