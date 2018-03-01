public class Vector {

    private final double x,y,z;

    Vector(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString(){
        return "("+this.getX()+","+this.getY()+","+this.getZ()+")";
    }
    
    public Scalar norm() {
        return new Scalar(Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2)));
    }
    
    public Vector cross(Vector v){
        return new Vector((this.getY()*v.getZ())-(this.getZ()*v.getY()),((this.getZ()*v.getX())-(this.getX()*v.getZ())),((this.getX()*v.getY())-this.getY()*v.getX()));
    }

    public Vector minus(Vector v){
        return new Vector(this.getX()-v.getX(),this.getY()-v.getY(), this.getZ()-v.getZ());
    }

    public Scalar dot(Vector v){
        return new Scalar((this.getX()*v.getX())+(this.getY()*v.getY())+(this.getZ()*v.getZ()));
    }

}
