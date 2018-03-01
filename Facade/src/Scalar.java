/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Clase dedicada a almacenar un escalar y sus implementaciones
public class Scalar {

    private double sca;

    //Constructor
    public Scalar(double sca){
        this.sca=sca;
    }

    //Producto Punto
    public Vector multiply(Vector v){
        return new Vector(v.getX()*sca,v.getY()*sca,v.getZ()*sca);
    }

    //Getter
    public double getSca(){
        return sca;
    }

    //Metodo toString para poder imprimir el objeto
    @Override
    public String toString(){
        return sca+"";
    }
}
