package java17feature2June2023;

public class SwitchCaseExample {

    public static void main(String[] args) {
        System.out.println(formatVal("sidh"));
    }

    public static String formatVal(Object obj) {
        return switch (obj){

            case Double d -> String.format("Double value is " + d);
            case Integer i -> String.format("integer value is ", i);
            case String s -> String.format("string value is " + s);
            case Long l -> String.format("Double value is ", l);

            default -> obj.toString();
        };
    }
}
