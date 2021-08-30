package JavaCoreTopicsImplementation17thJul2021.practice.practice24thAug2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sidharthdas on 30/08/21.
 */


class Laptop{

    private int laptopNumber;
    private String laptopBrand;
    private String ssd;
    private String ram;


    private boolean isGraphicEnabled;
    private boolean isbluetoothEnabled;

    private Laptop(LaptopBuilder b){
        this.laptopBrand = b.laptopBrand;
        this.laptopNumber = b.laptopNumber;
        this.isGraphicEnabled = b.isGraphicEnabled;
        this.ram = b.ram;
        this.ssd = b.ssd;

    }

    public int getLaptopNumber () {
        return laptopNumber;
    }

    public String getLaptopBrand () {
        return laptopBrand;
    }

    public String getSsd () {
        return ssd;
    }

    public String getRam () {
        return ram;
    }

    public boolean isGraphicEnabled () {
        return isGraphicEnabled;
    }

    public boolean isIsbluetoothEnabled () {
        return isbluetoothEnabled;
    }

    public void setLaptopNumber ( int laptopNumber ) {
        this.laptopNumber = laptopNumber;
    }

    public void setLaptopBrand ( String laptopBrand ) {
        this.laptopBrand = laptopBrand;
    }

    public void setSsd ( String ssd ) {
        this.ssd = ssd;
    }

    public void setRam ( String ram ) {
        this.ram = ram;
    }

    public void setGraphicEnabled ( boolean graphicEnabled ) {
        isGraphicEnabled = graphicEnabled;
    }

    public void setIsbluetoothEnabled ( boolean isbluetoothEnabled ) {
        this.isbluetoothEnabled = isbluetoothEnabled;
    }

    public static class LaptopBuilder{

        private int laptopNumber;
        private String laptopBrand;
        private String ssd;
        private String ram;


        private boolean isGraphicEnabled;
        private boolean isbluetoothEnabled;

        public LaptopBuilder ( int laptopNumber, String laptopBrand, String ssd, String ram ) {
            this.laptopNumber = laptopNumber;
            this.laptopBrand = laptopBrand;
            this.ssd = ssd;
            this.ram = ram;
        }


        public LaptopBuilder setGraphicEnabled ( boolean graphicEnabled ) {
            isGraphicEnabled = graphicEnabled;
            return this;
        }

        public LaptopBuilder setIsbluetoothEnabled ( boolean isbluetoothEnabled ) {
            this.isbluetoothEnabled = isbluetoothEnabled;
            return this;
        }


        public Laptop build(){
            return new Laptop(this);
        }
    }
}





class Stack{

    int[] arr ;
    int size;
    int index = 0;


    public Stack(int size){
        this.size = size;
        arr = new int[size];
    }
    // 2, 3,4,5,6
    public void push(int a){
        if(index < size){
            arr[index] = a;
            index ++;
        }
    }

    public void pop(){
        arr[index] = -1;
        index --;

    }
}
public class TestMainClass {



    public static void main ( String[] args ) {


        Laptop b = new Laptop.LaptopBuilder(1, "xyz", "256", "512").build();




        int arr [] = {1,2,-2,5,8,-19,10};

        List<Integer> list = new ArrayList<>();

        for(int i : arr){
            list.add(i);
        }
        Optional< Integer > sum = list.stream().reduce(Integer::sum);
        int sumVal = sum.get();
        int size = list.size();
        int sum1= 0;
        for(int i = 0; i < size; i++){
            if(i == 0){
                sum1 += list.get(i);
            }
            if(sum1 > sumVal) {
                sumVal = sum1;
            }

            sum1 += list.get(i);

        }

        System.out.println(sumVal);

    }
}
