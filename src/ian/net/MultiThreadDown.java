package ian.net;

public class MultiThreadDown{

	public static void main(String[] args) throws Exception {
		final DownUtil downUtil = new DownUtil("http://www.crazyit.org/attachments/month_1403/1403202355ff6cc9a4fbf6f14a.png", "ios.png", 4);
		//开始下载
		downUtil.download();
		new Thread(() -> {
			while(downUtil.getCompleteRate() < 1){
				System.out.println("已完成：" + downUtil.getCompleteRate());
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
	}
}