/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

public class ClienteInterprete {

	public ContextoInterprete ic;

	public ClienteInterprete(ContextoInterprete i){
		this.ic=i;
	}

	public String interprete(String str){
		Expresion exp = null;
		if(str.contains("Hexadecimal")){
			exp=new AHexadecimal(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else if(str.contains("Binario")){
			exp=new ABinario(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else return str;

		return exp.interprete(ic);
	}
}