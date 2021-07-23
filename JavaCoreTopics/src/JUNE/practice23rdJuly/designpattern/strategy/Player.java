package JUNE.practice23rdJuly.designpattern.strategy;

/**
 * @author sidharthdas on 23/07/21.
 */
public class Player {
    IStrategy strategy;
    String type;

    public Player ( String type ) {
        this.type = type;
    }

    public void action(){
        System.out.println("Player Type:" +type);
        strategy.command();
    }
}
