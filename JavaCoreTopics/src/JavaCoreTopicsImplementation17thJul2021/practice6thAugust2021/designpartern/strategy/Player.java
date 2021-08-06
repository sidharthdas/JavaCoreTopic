package JavaCoreTopicsImplementation17thJul2021.practice6thAugust2021.designpartern.strategy;

/**
 * @author sidharthdas on 06/08/21.
 */
public class Player {

    String type;
    Mode mode;

    public Player(String type){
        this.type = type;
    }


    public void action () {
        System.out.println("Player Type: " + type);
        mode.mode();
    }
}
