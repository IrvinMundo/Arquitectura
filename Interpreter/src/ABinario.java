/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

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
