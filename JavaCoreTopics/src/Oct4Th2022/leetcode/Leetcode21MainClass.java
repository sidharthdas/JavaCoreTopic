package Oct4Th2022.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sidharth Das
 * created on  17/11/22
 */
public class Leetcode21MainClass {

    public static void main(String[] args) {
       /* ["Bank","deposit","transfer","transfer"]
[[[0]],[1,2],[1,1,1],[1,1,3]]*/
        Bank bank = new Bank(new long[]{0});

        bank.deposit(1, 2);     // return true, it is valid to deposit $20 to account 5.
        // Account 5 has $10 + $20 = $30.
        bank.transfer(3, 4, 15); // return false, the current balance of account 3 is $10,
        // so it is invalid to transfer $15 from it.
        bank.withdraw(10, 50);   // return false, it is invalid because account 10 does not

    }
}

class Bank {

        Map<Integer, Long> map;

    public Bank(long[] balance) {
        map = new HashMap<>();
        int len = balance.length;
        for (int i = 0; i < len; i++) {
            map.put(i+1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {

        if(map.containsKey(account1) && map.containsKey(account2)){
            if(account2 == account1) return true;
            long bal1 = map.get(account1);
            long bal2 = map.get(account2);
            if(bal1 >= money){
                map.put(account1, bal1 - money);
                map.put(account2, bal2 + money);
                return true;
            }
        }

        return false;

    }

    public boolean deposit(int account, long money) {
        if(map.containsKey(account)){
            map.put(account, map.get(account) + money);
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(map.containsKey(account)){
            long mon = map.get(account);
            if(money <= mon){
                map.put(account, mon - money);
                return true;
            }
        }

        return false;
    }
}
