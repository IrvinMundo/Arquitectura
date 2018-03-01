import com.amazonaws.services.dynamodbv2.document.Item;
import org.bson.Document;


import java.util.*;

public class Principal {
    public static void main(String[] args){

        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);

        Document document = new Document()
                .append("String","Como estas")
                .append("Integer",1)
                .append("Condition",false)
                .append("Set",set)
                .append("Map",map)
                .append("Document",new Document().append("String 2", "Hey").append("Integer 2",2));

        MongoBSON doc = new MongoBSON(document);
        Item item = new Item();
        item.withPrimaryKey("Id","2054");
        ItemMapperAdapter adapter = new ItemMapperAdapter(item);
        adapter.convertBSON(doc);


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
