package JavaCoreTopicsImplementation17thJul2021.practice.practice24thAug2021.designpartern.strategy;

/**
 * @author sidharthdas on 24/08/21.
 */
public class Player {

    String type;
    Mode mode;

    public void action(){
        System.out.println("Player type :"+ type);
        mode.mode();
    }
}
