import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
    MySet<Integer> ms = new MySet<>();
    System.out.println(ms.add(9));
    System.out.println(ms.add(9));
    System.out.println(ms.remove(9));

    System.out.println(ms.add(7));
    System.out.println(ms.add(8));
    System.out.println(ms.size());

    Iterator<Integer> iter = ms.iterator();
    while (iter.hasNext()){
        System.out.println(iter.next());
    }
    }
}

class MySet<E>{
    private HashMap <E, Object> ms = new HashMap<>();
    private static final Object PRESENT = new Object();
    public boolean add (E num) {
        return ms.put(num, PRESENT) == null;
    }
    public boolean remove (E num){
        return ms.remove(num) != null;
    }

    public int size () {
        return ms.size();
    }
    public Iterator<E> iterator(){
        return ms.keySet().iterator();
    }
}
