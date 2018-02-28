
public class Main {
	public static void main(String [] args) {
		HumanFactory humanFactory = new HumanFactory();

	      Human human1 = humanFactory.getHuman("MALE");
	      human1.saludar();
	      
	      Human human2 = humanFactory.getHuman("FEMALE");
	      human2.saludar();

	}
}
