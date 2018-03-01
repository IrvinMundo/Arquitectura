import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

/*
    @author: Hector Flores e Irvin Mundo
    @matricula: A01333126 && A01333820
    @referencias: https://sourcemaking.com/design_patterns/
 */

//Implementación del iterator, como se puede notar tu existe ninguna interface que marque un esqueleto
public class MySet {
    private Hashtable ht = new Hashtable();

    // 1. Diseña el iterador
    public static class Iteratoret{
        private MySet set;
        private Enumeration e;
        private Integer current;

        //Constructor
        public Iteratoret(MySet in) {
            set = in;
        }

        //Devuelve el primer elemento
        public void first() {
            e = set.ht.keys();
            next();
        }

        //Termino de iterar?
        public boolean isDone() {
            return current == null;
        }

        //Devuelve el elemento actual
        public int currentItem() {
            return current;
        }

        //Devuelve el siguiente elemento
        public void  next() {
            try {
                current = (Integer)e.nextElement();
            } catch (NoSuchElementException e) {
                current = null;
            }
        }
    }

    //Agregar elemento
    public void add(int in) {
        ht.put(in, "null");
    }

    //Es un miembro de
    public boolean isMember(int i) {
        return ht.containsKey(i);
    }

    //Retorna los elementos restantes
    public Hashtable getHashtable() {
        return ht;
    }

    // Iterador que se encargara de recorrer los elementos
    public Iteratoret createIterator()  {
        return new Iteratoret(this);
    }
}
