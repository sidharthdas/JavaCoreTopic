package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.designpattern.strategy;

/**
 * @author sidharthdas on 09/09/21.
 */
public class Player {

    String type;
    Mode mode;

    public Player ( String type ) {

        this.type = type;
    }

    public void action(){
        System.out.println("Player Type : "+type);
        mode.mode();
    }
}
