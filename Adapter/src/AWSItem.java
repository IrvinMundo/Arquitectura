import com.amazonaws.services.dynamodbv2.document.Item;

/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Crea un objeto que contenga los metodos para almacenar un objeto del tipo ITEM
public class AWSItem {
    private Item item;

    //Constructor
    public AWSItem(Item item){
        this.item = item;
    }

    //Getter
    public Item getItem(){
        return item;
    }

    //Setter
    public void setItem(Item item){
        this.item=item;
    }

}

