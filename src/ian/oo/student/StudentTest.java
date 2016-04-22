package ian.oo.student;

import ian.oo.school.School;

public class StudentTest{

	public static Student[] arrSts;

	public static void searchName(String name){
		for(int i = 0; i < arrSts.length; i++){

			if(arrSts[i].getName() == name){
				System.out.println("Find student " + arrSts[i].getName());
				return;
			}
		}
		System.out.println("Cannot find student " + name);
	}

	public static void searchEmail(String email){
		for(int i = 0; i < arrSts.length; i++){
			if(arrSts[i].getEmail() == email){
				System.out.println("Find student " + arrSts[i].getName());
				return;
			}
		}
		System.out.println("Cannot find student by email " + email);
	}

	public static void main(String[] args){
		//P161
		arrSts = new Student[5];

		arrSts[0] = new Student("Ian", "M", 34, "13765243654", "Chen hui Road", "flks555@163.com", "3", "1");
		arrSts[1] = new Student("KaKa", "M", 30, "13765243655", "Chen hui Road", "flks551@163.com","3", "2");
		arrSts[2] = new Student("Flks555", "M", 24, "13765243656", "Chen hui Road", "flks552@163.com","3", "1");
		arrSts[3] = new Student("Grace", "F", 35, "13765243657", "Chen hui Road", "flks553@163.com","3", "3");
		arrSts[4] = new Student("Mark", "M", 34, "13765243658", "Chen hui Road", "flks554@163.com","3", "2");

		searchName("ian");
		searchEmail("flks552@163.com");

		School scl = new School("Shang Hai Tong Ji Unversity", "Tong Ji Road");
		arrSts[0].setScl(scl);
		arrSts[0].study();
		System.out.println(arrSts[0].getScl().getEmail());

	}

}