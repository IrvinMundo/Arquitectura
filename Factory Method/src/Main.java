/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Este patron es una manera común de crear clases y objetos sin exponer explícitamente la lógica de la creación,
//esto se hace a traves de HumanFactory que detecta el tipo de Clase y crea el tipo de clase.
//Asi mismo el tipo de clase detectado sobreescribe los métodos de las clases de las cuales hereda,
//por ejemplo en este caso de Human por parte de Male y Female*/
public class Main {
	public static void main(String [] args) {
		HumanFactory humanFactory = new HumanFactory();

	      Human human1 = humanFactory.getHuman("MALE");
	      human1.saludar();
	      
	      Human human2 = humanFactory.getHuman("FEMALE");
	      human2.saludar();

	}
}
