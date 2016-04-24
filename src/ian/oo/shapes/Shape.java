package ian.oo.shapes;

public abstract class Shape{

	{
		System.out.println("执行shape的初始化块...");
	}

	private String color;

	public abstract double calPerimeter();

	public abstract String getType();

	public Shape(){}

	public Shape(String color){
		System.out.println("执行shape的构造器");
		this.color = color;
	}

	// setter and getter
	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color = color;
	}

}