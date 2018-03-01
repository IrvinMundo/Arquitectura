import com.amazonaws.services.dynamodbv2.document.Item;

public class AWSItem {
    private Item item;

    public AWSItem(Item item){
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

    public void setItem(Item item){
        this.item=item;
    }

}

