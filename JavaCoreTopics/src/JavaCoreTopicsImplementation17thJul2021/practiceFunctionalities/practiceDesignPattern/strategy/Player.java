package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.practiceDesignPattern.strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class Player {

    IStrategy strategy;
    String type;

    public Player ( String type ) {
        this.type = type;
    }

    public void action(){
        System.out.println("Player : "+this.type);
        strategy.command();
    }
}
