import org.bson.Document;

/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Crea un objeto que contenga los metodos para almacenar un objeto del tipo Docuement
public class MongoBSON {
    private final Document doc;

    //Constructor
    public MongoBSON(Document doc){
        this.doc = doc;
    }

    //Getter
    public Document getDocument() {
        return doc;
    }
}
