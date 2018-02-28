
public class ABinario implements Expresion{
	private int i;
	public ABinario(int c){
		this.i=c;
	}
	@Override
	public String interprete(ContextoInterprete ic) {
		return ic.getBinarioFormat(this.i);
	}
}
