public class ClienteInterprete {

	public ContextoInterprete ic;

	public ClienteInterprete(ContextoInterprete i){
		this.ic=i;
	}

	public String interprete(String str){
		Expresion exp = null;
		//create rules for expressions
		if(str.contains("Hexadecimal")){
			exp=new AHexadecimal(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else if(str.contains("Binary")){
			exp=new ABinario(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		}else return str;

		return exp.interprete(ic);
	}
}