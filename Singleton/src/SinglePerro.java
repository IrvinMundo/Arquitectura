/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

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
