package ian.reflect;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader{

	//读取一个文件的内容
	private byte[] getBytes(String filename) throws IOException{
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int)len];

		try(
			FileInputStream fin = new FileInputStream(file);
		){
			int r = fin.read(raw);
			if (r != len) {
				throw new IOException("无法读取全部文件：" + r + " != " + len);
			}
			return raw;
		}
	}
	// 定义编译指定Java文件的方法
	private boolean compile(String javaFile) throws IOException{
		System.out.println("CompileClassLoader: 正在编译"
			+ javaFile + "...");

		// 调用系统的javac命令
		Process p = Runtime.getRuntime().exec("javac -encoding utf-8 " + javaFile);
		try{
			//其他线程都等待这个线程完成
			p.waitFor();
		
		}catch(InterruptedException ie){
			System.out.println(ie);
		}

		// 获取javac线程的退出值
		int ret = p.exitValue();
		return ret == 0;
	}

	// 重写ClassLoader的findClass方法
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		Class clazz = null;
		// 将路径中的(.)替换成(/)
		String fileStub = name.replace(".", "/");
		String javaFileName = fileStub + ".java";
		String classFileName = fileStub + ".class";

		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);
		// 
		if (javaFile.exists() && (!classFile.exists())
			|| javaFile.lastModified() > classFile.lastModified()) {
		
			try{
				// 如果编译失败或者Class文件不存在
				if (!compile(javaFileName) || !classFile.exists()) {
					throw new ClassNotFoundException("ClassNotFoundException:" + javaFileName);
				}	
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		// 如果Class文件存在，系统负责将该文件转换成Class对象
		if (classFile.exists()) {
			try{
				//将class文件的二进制数据读入数组
				byte[] raw = getBytes(classFileName);
				//调用ClassLoader的defineClass方法将二进制文件转换成Class对象
				clazz = defineClass(name, raw, 0, raw.length);
			}catch(IOException ie){
				ie.printStackTrace();
			}
		}
		return clazz;
	}

	//定义一个主方法
	public static void main(String[] args) throws Exception {
		//如果运行该程序时没有参数，即没有目标类
		if (args.length < 1) {
			System.out.println("缺少目标类，请按照如下格式运行Java源文件");
			System.out.println("java CompileClassLoader ClassName");
			return;
		}
		String progClass = args[0];
		String[] progArgs = new String[args.length - 1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CompileClassLoader ccl = new CompileClassLoader();

		Class<?> clazz = ccl.loadClass(progClass);

		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = {progArgs};
		main.invoke(null, argsArray);
	}
}