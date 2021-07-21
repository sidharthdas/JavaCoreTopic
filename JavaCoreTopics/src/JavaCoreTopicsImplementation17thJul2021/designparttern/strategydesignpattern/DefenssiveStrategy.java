package JavaCoreTopicsImplementation17thJul2021.designparttern.strategydesignpattern;

/**
 * @author sidharthdas on 21/07/21.
 */
public class DefenssiveStrategy  implements IStrategy{
    @Override
    public void actionCommand () {
        System.out.println("Defensive Strategy: Protect yourself and teammate");
    }
}
