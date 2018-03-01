/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Clase dedicada a almacenar un vector y sus implementaciones
public class Vector {

    private final double x,y,z;

    //Constructor
    Vector(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    //Getter X
    public double getX() {
        return x;
    }

    //Getter Y
    public double getY() {
        return y;
    }

    //Getter Z
    public double getZ() {
        return z;
    }

    //Metodo toString para poder imprimir el objeto
    @Override
    public String toString(){
        return "("+this.getX()+","+this.getY()+","+this.getZ()+")";
    }

    //Normaliza el vector de la forma sqrt(x^2+y^2+z^2)
    public Scalar norm() {
        return new Scalar(Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2)));
    }

    //Punto cruz entre el vector del constructor y otro nuevo
    public Vector cross(Vector v){
        return new Vector((this.getY()*v.getZ())-(this.getZ()*v.getY()),((this.getZ()*v.getX())-(this.getX()*v.getZ())),((this.getX()*v.getY())-this.getY()*v.getX()));
    }

    //Resta de vectores
    public Vector minus(Vector v){
        return new Vector(this.getX()-v.getX(),this.getY()-v.getY(), this.getZ()-v.getZ());
    }

    //Multiplicacion de vectores
    public Scalar dot(Vector v){
        return new Scalar((this.getX()*v.getX())+(this.getY()*v.getY())+(this.getZ()*v.getZ()));
    }

}
