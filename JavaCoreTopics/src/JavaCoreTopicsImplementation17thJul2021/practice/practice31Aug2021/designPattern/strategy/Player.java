package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.strategy;

/**
 * @author sidharthdas on 31/08/21.
 */
public class Player {

    String playerType;
    Mode mode;

    public void action(){
        System.out.println("Player type : "+playerType);
        mode.mode();
    }
}
