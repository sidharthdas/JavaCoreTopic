package JavaCoreTopicsImplementation17thJul2021.practice.practiceFunctionalities.designpartterntest.Strategy;

/**
 * @author sidharthdas on 22/07/21.
 */
public class DeffensiveStrategy implements IStrategy{
    @Override
    public void command () {
        System.out.println("Defenssive strategy : Besafe and look after team");
    }
}
