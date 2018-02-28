
public class AHexadecimal implements Expresion {

	private int i;

	public AHexadecimal(int c){
		this.i=c;
	}
	@Override
	public String interprete(ContextoInterprete ic) {
		return ic.getHexadecimalFormat(this.i);
	}
}
