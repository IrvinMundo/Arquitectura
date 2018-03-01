/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Metodo main y aparte se encarga de hacer el facade entre Vector y Escalar
public class Facade {

    private Vector v;
    private Vector parallel;
    private Vector orthogonal;

    //Metodo Main
    public static void main(String[] args){
        Vector v1= new Vector(1,2,4);
        Vector v2 = new Vector(4,5,6);
        Facade fac=new Facade(v1);
        fac.normalizar();
        fac.cross(v2);
        fac.paralelo(v2);
        fac.ortogonal();
        fac.reflejo();
    }

    //Constructor
    private Facade(Vector v1){
        this.v=v1;
    }

    //Devuelve un vector normalizado usando la implementación misma de vector
    private void normalizar(){
        System.out.println("La magnitud del vector "+v.toString()+" es: "+v.norm().toString());
    }

    //Devuelve un vector residuo de un punto cruz usando la implementación misma de vector
    private void cross(Vector u){
        System.out.println("El punto cruz entre entre " + v.toString() + " y "+u.toString()+" es: " + v.cross(u));
    }

    //Saca el vector paralelo entre el vector actual y uno dado
    private void paralelo(Vector u){
        parallel=new Scalar(v.dot(u).getSca()).multiply(u);
        System.out.println("El vector paralelo es: "+parallel.toString());
    }

    //Saca el vector ortogonal entre el vector actual y paralelo por lo que requiere primero que se ejecute el metodo de paralelo
    private void ortogonal(){
        if(parallel==null){
            throw new IllegalStateException("Debes sacar primero el vector paralelo");
        }else{
            this.orthogonal = v.minus(parallel);
            System.out.println("El vector ortogonal es: "+orthogonal.toString());
        }
    }

    //Saca el vector de reflejo entre el vector paralelo y el ortogonal por lo que requiere que se ejecuten ambos metodos antes
    private void reflejo(){
        if(parallel==null || orthogonal == null){
            throw new IllegalStateException("Debes sacar primero el vector paralelo y ortogonal");
        }else{
            Vector reflected = parallel.minus(orthogonal);
            System.out.println("El vector de reflexión es: "+ reflected.toString());
        }
    }
}
