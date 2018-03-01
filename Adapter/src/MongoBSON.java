import org.bson.Document;

public class MongoBSON {
    private final Document doc;

    public MongoBSON(Document doc){
        this.doc = doc;
    }

    public Document getDocument() {
        return doc;
    }
}
