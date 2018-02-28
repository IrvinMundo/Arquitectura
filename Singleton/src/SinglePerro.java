
public class SinglePerro {
	private static SinglePerro instancia = new SinglePerro();
	private SinglePerro(){}
	public static SinglePerro getInstance(){
		return instancia;
	}
	public void showMessage(){
		System.out.println("Guau");
	}
}
