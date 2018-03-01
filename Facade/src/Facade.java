public class Facade {

    private Vector v;
    private Vector parallel;
    private Vector orthogonal;

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

    private Facade(Vector v1){
        this.v=v1;
    }

    private void normalizar(){
        System.out.println("La magnitud del vector "+v.toString()+" es: "+v.norm().toString());
    }


    private void cross(Vector u){
        System.out.println("El punto cruz entre entre " + v.toString() + " y "+u.toString()+" es: " + v.cross(u));
    }

    private void paralelo(Vector u){
        parallel=new Scalar(v.dot(u).getSca()).multiply(u);
        System.out.println("El vector paralelo es: "+parallel.toString());
    }

    private void ortogonal(){
        if(parallel==null){
            throw new IllegalStateException("Debes sacar primero el vector paralelo");
        }else{
            this.orthogonal = v.minus(parallel);
            System.out.println("El vector ortogonal es: "+orthogonal.toString());
        }
    }

    private void reflejo(){
        if(parallel==null || orthogonal == null){
            throw new IllegalStateException("Debes sacar primero el vector paralelo y ortogonal");
        }else{
            Vector reflected = parallel.minus(orthogonal);
            System.out.println("El vector de reflexión es: "+ reflected.toString());
        }
    }
}
