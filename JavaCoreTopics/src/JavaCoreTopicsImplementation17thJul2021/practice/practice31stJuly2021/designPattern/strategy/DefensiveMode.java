package JavaCoreTopicsImplementation17thJul2021.practice.practice31stJuly2021.designPattern.strategy;

/**
 * @author sidharthdas on 31/07/21.
 */
public class DefensiveMode  implements Mode{

    @Override
    public void mode () {
        System.out.println("DefensiveMode : Save yourself as well as teammates");
    }
}
