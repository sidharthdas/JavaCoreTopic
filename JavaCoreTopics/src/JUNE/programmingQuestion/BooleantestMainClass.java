package JUNE.programmingQuestion;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;

/**
 * @author sidharthdas on 29/06/21.
 */
public class BooleantestMainClass

{

    static Logger logger = LoggerFactory.getLogger(BooleantestMainClass.class);


    public static void main ( String[] args ) throws Exception {
        try{

            if(!test()){
                logger.error("error");
                System.out.println("uuuuuuu");
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }



    public static boolean test() throws Exception{

        System.out.println("test");
        try {
            int a = 10 /0;
            return true;
        }catch (Exception ee){

            System.out.println("errorrrrr");

         throw ee;
        }
    }
}
