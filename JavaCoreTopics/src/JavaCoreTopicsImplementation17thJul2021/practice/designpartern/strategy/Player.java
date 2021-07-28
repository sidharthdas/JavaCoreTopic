package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.strategy;

/**
 * @author sidharthdas on 28/07/21.
 */
public class Player {

    private String type;
    private Mode mode;

    public Player ( String type ) {
        this.type = type;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public Mode getMode () {
        return mode;
    }

    public void setMode ( Mode mode ) {
        this.mode = mode;
    }

    public void action(){
        System.out.println("Player type: "+type);
        mode.mode();
    }
}
