package JavaCoreTopicsImplementation17thJul2021.practice.practice31stJuly2021.designPattern.strategy;

/**
 * @author sidharthdas on 31/07/21.
 */
public class Player {

    private Mode mode;
    private String type;

    public Player ( String type ) {
        this.type = type;
    }

    public Mode getMode () {
        return mode;
    }

    public void setMode ( Mode mode ) {
        this.mode = mode;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public void action(){
        System.out.println("Player :"+ type);
        mode.mode();
    }
}
