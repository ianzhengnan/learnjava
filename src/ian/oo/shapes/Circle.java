package ian.oo.shapes;

public class Circle extends Shape{

	private float r;

	public Circle(){

	}

	public Circle(String color, float r){
		super(color);
		this.r = r;
	}

	public void setR(float r){
		this.r = r;
	}

	public double calPerimeter(){
		return 2 * Math.PI * r;
	}

	public String getType(){
		return getColor() + "圆形";
	}

	public void printR(){
		System.out.println(this.r);
	}

	public static void main(String[] args){

		Shape ci = new Circle("red", 5.6f);
		Shape trig = new Triangle("black", 12.3, 23.4, 30.5);
		System.out.println(ci.getType());
		System.out.println(trig.getType());
		System.out.println("The circle's perimeter is " + ci.calPerimeter());
		System.out.println("The triangle's perimeter is " + trig.calPerimeter());
		//ci.printR(); // 编译错误：Shape class 没有这个方法
	}



}