package recurssionpractice;

/**
 * @author Sidharth Das
 * created on  06/12/22
 */
public class NFactorial {

    public static void main(String[] args) {
        System.out.println(fact(4));
    }

    public static int fact(int n){
        if(n == 1){
            return n;
        }
        return n * fact(n - 1);
    }
}
