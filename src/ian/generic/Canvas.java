package ian.generic;

import java.util.List;

public class Canvas {

	public void drawAll(List<? extends Shape> shapes){
		for (Object obj : shapes) {
			Shape s = (Shape)obj;
			s.draw(this);
		}
	}

}