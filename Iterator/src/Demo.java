public class Demo {
    public static void main( String[] args ) {
        MySet set = new MySet();
        for (int i=2; i < 10; i += 2){
            set.add( i );
        }

        for (int i=1; i < 9; i++){
            System.out.print( i + "-" + set.isMember( i ) + "  " );
        }

        // 3. Clients ask the collection object to create many iterator objects
        MySet.Iterator it1 = set.createIterator();

        // 4. Clients use the first(), isDone(), next(), currentItem() protocol
        System.out.print( "\nIterator:    " );
        for (it1.first();!it1.isDone();it1.next()) {
            System.out.print(it1.currentItem()+ " - ");
        }
    }
}

