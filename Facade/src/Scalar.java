public class Scalar {

    private double sca;

    public Scalar(double sca){
        this.sca=sca;
    }

    public Vector multiply(Vector v){
        return new Vector(v.getX()*sca,v.getY()*sca,v.getZ()*sca);
    }

    public double getSca(){
        return sca;
    }

    @Override
    public String toString(){
        return sca+"";
    }
}
