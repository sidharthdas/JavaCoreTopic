package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.designpartterntest.Strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class Player {

    IStrategy strategy;
    String type;

    public Player ( String type ) {
        this.type = type;
    }

    public void setStrategy ( IStrategy strategy ) {
        this.strategy = strategy;
    }

    public void action(){
        System.out.println("Player: "+this.type);
        strategy.command();
    }
}
