package ian.io;

import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import java.io.FileOutputStream;

public class FileLockTest{

	public static void main(String[] args) throws Exception {
		
		try(

			FileChannel channel = new FileOutputStream("a.txt").getChannel();

			){

			FileLock lock = channel.tryLock();
			Thread.sleep(10000);
			lock.release();
		}
	}
}