package java17feature2June2023;

record Alien(String alienId, String alienName) {

    //This has a capalibity that it automatically implemented equals and hascode
    //It doesnt have setter, as it is just use to send and access the data
    public Alien(String alienId) { //constructor with one argument
        this(alienId, null);
    }
}

public class RecordExample {
    public static void main(String[] args) {

        Alien a1 = new Alien("1", "Sid");
        Alien a2 = new Alien("2");
        System.out.println(a1);
        System.out.println(a2);
    }
}
