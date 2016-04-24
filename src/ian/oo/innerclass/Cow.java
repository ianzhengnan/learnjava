package ian.oo.innerclass;

public class Cow {

	private double weight;

	public Cow(){}

	public Cow(double weight){
		this.weight = weight;
	}

	// define a non static inner class
	private class Cowleg{

		private double length;
		private String color;
		private double weight;

		public Cowleg(){}
		public Cowleg(double length, String color, double weight){
			this.length = length;
			this.color = color;
			this.weight = weight;
		}

		// setters and getters

		public void info(){
			System.out.println("当前牛腿的颜色是：" + color + ", 高：" + length + ", 牛腿重：" + weight);
			System.out.println("本牛腿所在的奶牛重：" + Cow.this.weight);
		}
	}

	public void test(){
		Cowleg cl = new Cowleg(1.12, "红黑相间", 88.5);
		cl.info();
	}

	public static void main(String[] args){
		Cow co = new Cow(567.8);
		co.test();
	}

}