package ian.net;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest{

	public static void main(String[] args) throws Exception {
		//将application/x-www-form-urlencoded字符串
		//转换成普通字符串
		String keyWord = URLDecoder.decode("%E6%AD%BB%E4%BE%8D", "utf-8");
		System.out.println(keyWord);

		String urlStr = URLEncoder.encode("疯狂Java讲义", "GBK");
		System.out.println(urlStr);
	}
}