import com.amazonaws.services.dynamodbv2.document.Item;
import org.bson.Document;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Crea el adaptador que hace la conversión entre BSON Document y AWS Item
public class ItemMapperAdapter {

    private final AWSItem articulo;

    //Constructor
    public ItemMapperAdapter(Item item) {
        this.articulo=new AWSItem(item);
    }

    //LLamada incial, acepta el contendor de MongoBSON
    public Item convertBSON(MongoBSON doc){
        articulo.setItem(convertDoc(doc.getDocument()));
        return articulo.getItem();
    }

    //Implementación del convertidor, hay que evaluar todos los posibles objetos del BSON y es llamada recursiva
    private Item convertDoc(Document doc){
        Item item = articulo.getItem();
        for(Map.Entry<String,Object> value:doc.entrySet()){
            if(!value.getKey().equalsIgnoreCase("_id")){
                String text = String.valueOf(value.getValue());
                if(value.getValue() instanceof Number) {
                    try {
                        item.withNumber(value.getKey(), NumberFormat.getInstance().parse(text));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }else if (value.getValue() instanceof String) {
                    item.withString(value.getKey(), text);
                }else if (value.getValue() instanceof Boolean) {
                    item.withBoolean(value.getKey(), Boolean.parseBoolean(text));
                }else if (value.getValue() instanceof Set) {
                    item.withStringSet(value.getKey(), new HashSet<>(Arrays.asList(text.substring(1, text.length() - 1).split(","))));
                }else if(value.getValue() instanceof List){
                    item.withList(value.getKey(),(List<?>) value.getValue());
                }else if(value.getValue() instanceof Map){
                    //noinspection unchecked
                    item.withMap(value.getKey(),(Map<String,?>) value.getValue());
                }else if(value.getValue() instanceof Document){
                    //Llamada para devolver un Documento en caso de que exista una profundidad
                    Item temp = convertDoc((Document) value.getValue());
                    //Convierte el nivel actual a Mapa
                    item.withMap(value.getKey(), castItem(temp));
                }
            }
        }
        return item;
    }

    //En caso de que se le pasa un Item y convierte los valores en un mapa para leerse mejor
    private Map<String,Object> castItem(Item item){
        Map<String, Object> mapa = new HashMap<>();
        for(Map.Entry<String, Object> valor : item.asMap().entrySet()){
            if(valor.getValue() instanceof Document){
                Item temp = convertDoc((Document) valor.getValue());
                mapa.put(valor.getKey(),castItem(temp));
            }else{
                mapa.put(valor.getKey(),valor.getValue());
            }
        }
        return mapa;
    }
}
