package ian.oo.enums;

public class GenderTest{

	public static void main(String[] args){

		GenderDesc g = Gender.valueOf("FEMALE");
		Gender gr = (Gender)g;
		System.out.println(gr.getName());

		g.info();
	}

}