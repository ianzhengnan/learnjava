package ian.net.proxy;

import java.net.Proxy;
import java.net.URLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.IOException;
import java.io.PrintStream;

import java.util.Scanner;

public class ProxyTest{

	final String PROXY_ADDR = "xxx.xxx.xxx.xxx";
	final int PROXY_PORT = 8080;

	String urlStr = "http://www.google.com";
	public void init() throws IOException, MalformedURLException{
		URL url = new URL(urlStr);

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));

		URLConnection conn = url.openConnection(proxy);

		conn.setConnectTimeout(3000);
		try(
			Scanner scan = new Scanner(conn.getInputStream());
			PrintStream ps = new PrintStream("index.html");
		){
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				System.out.println(line);
				ps.println(line);
			}
		}
	}

	public static void main(String[] args) throws IOException, MalformedURLException{
		new ProxyTest().init();
	}
}