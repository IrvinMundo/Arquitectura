/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Manejador del programa, metodo main
//Se encarga de crear tu propia version de Iterator para no lidiar con la implementación de Java
public class Demo {
    public static void main( String[] args ) {
        //Agrega datos a iterar
        MySet set = new MySet();
        for (int i=2; i < 10; i += 2){
            set.add( i );
        }

        //Itera los datos y checa si existen
        for (int i=1; i < 9; i++){
            System.out.print( i + "-" + set.isMember( i ) + "  " );
        }

        // Se crea un iterator
        MySet.Iteratoret it1 = set.createIterator();

        // 4. Itera por todos los datos
        for (it1.first();!it1.isDone();it1.next()) {
            System.out.print(it1.currentItem()+ " - ");
        }
    }
}

