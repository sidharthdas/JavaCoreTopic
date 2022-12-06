package recurssionpractice;

/**
 * @author Sidharth Das
 * created on  06/12/22
 */
public class NToThePowerM {

    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }

    public static int power(int n, int m){
        if(m == 0){
            return 1;
        }

        return n * power(n, m - 1);
    }
}
