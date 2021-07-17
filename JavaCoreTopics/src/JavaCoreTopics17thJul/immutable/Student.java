package JavaCoreTopics17thJul.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sidharthdas on 25/06/21.
 */
public final class Student {

    private final String studName;
    private final ArrayList<String> address;

    public Student ( String studName, ArrayList< String > address ) {
        this.studName = studName;
        List<String> address1 = new ArrayList<>();
        address.forEach(x ->{
            address1.add(x);
        });
        this.address = (ArrayList< String >) address1;
    }

    public String getStudName () {
        return studName;
    }

    public ArrayList< String > getAddress () {
        return (ArrayList< String >) address.clone();
    }
}
