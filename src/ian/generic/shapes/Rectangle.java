package ian.generic.shapes;

import java.util.List;
import java.util.ArrayList;

public class Rectangle extends Shape{

	public void draw(Canvas c){
		System.out.println("在画布" + c + "画一个长方形");
	}

	public static void main(String[] args){

		Rectangle rt = new Rectangle();
		Canvas cvs = new Canvas();
		rt.draw(cvs);

		Circle cl = new Circle();

		List<Shape> rtList = new ArrayList<>();
		rtList.add(rt);
		rtList.add(cl);
		// rtList.add("kkkk");
		cvs.drawAll(rtList);
	}
}