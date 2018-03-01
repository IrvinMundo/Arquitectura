import com.amazonaws.services.dynamodbv2.document.Item;
import org.bson.Document;


import java.util.*;

/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Manejador del programa, metodo main

//Este programa se encarga de hacer un adaptador para convertir un objeto de tipo Item(AWS) a un tipo Document(MongoDB)
//para poder comunicarse entre las dos bases de datos.
public class Principal {
    public static void main(String[] args){

        //Crea un set de String para almacenar
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");

        //Crea un mapa de String e Integers para almacenar
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);

        //Nuevo Documento
        Document document = new Document()
                .append("String","Como estas")
                .append("Integer",1)
                .append("Condition",false)
                .append("Set",set)
                .append("Map",map)
                .append("Document",new Document().append("String 2", "Hey").append("Integer 2",2));

        //Lo pone el wrapper
        MongoBSON doc = new MongoBSON(document);
        //Le pasa un nuevo Item que va a usar para almacenar las cosas
        Item item = new Item();
        item.withPrimaryKey("Id","2054");
        ItemMapperAdapter adapter = new ItemMapperAdapter(item);
        //Pasa el documento a convertir
        adapter.convertBSON(doc);


        //Imprime el contenido
        System.out.println(item.getString("String"));
        System.out.println(item.getNumber("Integer"));
        System.out.println(item.getBoolean("Condition"));
        System.out.println(Arrays.toString(item.getStringSet("Set").toArray()));
        for (Map.Entry<String, Object> entry : item.getMap("Map").entrySet())
        {
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }
        for (Map.Entry<String, Object> entry : item.getMap("Document").entrySet())
        {
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }
    }
}
