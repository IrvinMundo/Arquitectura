/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

public class Main {
    //En este patron lo que se hace es que sea hace que el constructor para crear una clase sea privado y solo se pueda "crear" objetos instanciandolos, dado que el constructor no es visible para el main
	public static void main(String[] args) {
		SinglePerro singlePerro = SinglePerro.getInstance();
		singlePerro.showMessage();
	}
}
