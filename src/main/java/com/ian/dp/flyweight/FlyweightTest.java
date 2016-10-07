package com.ian.dp.flyweight;

public class FlyweightTest {
	
	public static void main(String[] args) {
		
		/*String a = "hello";
		String b = "hello";
		if (a.equals(b)) {
			System.out.println("a == b");
		}else{
			System.out.println("a != b");
		}*/
	
		WebsiteFactory wf = new WebsiteFactory();
		
		Website fx = wf.getWebsiteCatalog("产品展示");
		fx.use(new User("小张"));
		Website fy = wf.getWebsiteCatalog("产品展示");
		fy.use(new User("小李"));
		Website fz = wf.getWebsiteCatalog("产品展示");
		fz.use(new User("小郑"));
	
		Website bx = wf.getWebsiteCatalog("博客");
		bx.use(new User("小江"));
		Website by = wf.getWebsiteCatalog("博客");
		by.use(new User("小红"));
		
		System.out.println("一共有 " + wf.getWebsiteCount() + "个网站实例");
	}
	
}
