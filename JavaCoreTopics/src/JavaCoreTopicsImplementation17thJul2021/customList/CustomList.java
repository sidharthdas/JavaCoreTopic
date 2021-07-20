package JavaCoreTopicsImplementation17thJul2021.customList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sidharthdas on 20/07/21.
 */
public class CustomList<T> implements Iterable{

    List<T> list = new ArrayList<>();

    public void add(T t){
        list.add(t);
    }

    public T get(int index){
        return list.get(index);
    }



    @Override
    public Iterator iterator () {
        return null;
    }
}
