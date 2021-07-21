package JavaCoreTopicsImplementation17thJul2021.designparttern.strategydesignpattern;

/**
 * @author sidharthdas on 21/07/21.
 */
public class AgressiveStrategy implements IStrategy{
    @Override
    public void actionCommand () {
        System.out.println("Agressive strategy : Find and kill opponent ");
    }
}
