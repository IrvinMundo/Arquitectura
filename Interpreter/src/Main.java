
public class Main {
	public static void main(String args[]){
		/*
		 * Este patron es ideal para reconocer  patrones o comportamientos como expresiones en un lenaguaje de programacion
		 * Dentro de nuestro ejemplo tenemos el como nuestro interprete detectara cuando queremos convertir a binario o a Haxadecimal
		 * 
		 * Solo indicandole en un string si es a Binario o a Hexadecimal. Este activara la clase Cliente Interprete 
		 * ClienteInterprete se transforma a formato hexadecimal o binario, debido a que estas son Expresiones y estas obienten el contexto que regresa el formato
		 * */
		String str1 = "93 in Binario";
		String str2 = "93 in Hexadecimal";
		
		ClienteInterprete ec = new ClienteInterprete(new ContextoInterprete());
		System.out.println(str1+"= "+ec.interprete(str1));
		System.out.println(str2+"= "+ec.interprete(str2));

	}
}
