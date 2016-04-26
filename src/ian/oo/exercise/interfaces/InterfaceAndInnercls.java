package ian.oo.exercise.interfaces;

interface Product{
	public double getPrice();
	public String getName();
}

public class InterfaceAndInnercls {

	public void test(Product p){
		System.out.println("买了一个" + p.getName() + "花了" + p.getPrice());
	}

	public static void main(String[] args){

		InterfaceAndInnercls iai = new InterfaceAndInnercls();
		iai.test(new Product(){
			public double getPrice(){
				return 235.9;
			}
			public String getName(){
				return "照相机";
			}
		});
	}

}