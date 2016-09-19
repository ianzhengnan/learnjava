package ian.oo.school;

public class SchoolTest{

	public static void main(String[] args){
		School scl = new School("Chen Hui Road", null);
		scl.setName("Shang Hai Tong Ji University");
		System.out.println(scl.getName());
		System.out.println(scl.getEmail());

		scl.open();
		scl.close();
	}

}