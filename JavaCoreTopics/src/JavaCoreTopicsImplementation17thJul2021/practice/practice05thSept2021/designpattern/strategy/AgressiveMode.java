package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.designpattern.strategy;

/**
 * @author sidharthdas on 05/09/21.
 */
public class AgressiveMode implements Mode{
    @Override
    public void mode () {
        System.out.println("In Aggressive mode: Attack !! ");
    }
}
