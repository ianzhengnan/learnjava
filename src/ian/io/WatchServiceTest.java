package ian.io;

import java.nio.file.WatchService;
import java.nio.file.WatchKey;
import java.nio.file.WatchEvent;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;


public class WatchServiceTest{

	public static void main(String[] args) throws Exception {
		
		WatchService watchService = FileSystems.getDefault().newWatchService();

		// 为C盘根目录注册监听
		Paths.get("C:/Users/i076453").register(watchService
			, StandardWatchEventKinds.ENTRY_CREATE
			, StandardWatchEventKinds.ENTRY_MODIFY
			, StandardWatchEventKinds.ENTRY_DELETE);

		while(true){

			WatchKey key = watchService.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println(event.context() + " 文件发生了 "
					+ event.kind() + "事件！");
			}

			//重设WatchKey
			boolean valid = key.reset();
			// 如果重设失败，退出监听
			if (!valid) {
				break;
			}
		}
	}
}