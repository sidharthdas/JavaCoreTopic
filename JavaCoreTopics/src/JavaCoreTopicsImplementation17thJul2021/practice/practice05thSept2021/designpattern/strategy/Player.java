package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.designpattern.strategy;

/**
 * @author sidharthdas on 05/09/21.
 */
public class Player {

    String type;
    Mode mode;

    void action () {
        System.out.println("Player type: " + type);
    }
}
