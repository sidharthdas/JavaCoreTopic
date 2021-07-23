package JUNE.practice23rdJuly.designpattern.builder;

/**
 * @author sidharthdas on 23/07/21.
 */
public class Laptop {

    private int laptopNo;
    private String ram;
    private String hdd;

    private boolean isBluetoothEnabled;
    private boolean isGraphicEnabled;

    private Laptop(LaptopBuilder builder){
        this.laptopNo = builder.laptopNo;
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicEnabled = builder.isGraphicEnabled;

    }

    public int getLaptopNo () {
        return laptopNo;
    }

    public String getRam () {
        return ram;
    }

    public String getHdd () {
        return hdd;
    }

    public boolean isBluetoothEnabled () {
        return isBluetoothEnabled;
    }

    public boolean isGraphicEnabled () {
        return isGraphicEnabled;
    }

    public static class LaptopBuilder{

        private int laptopNo;
        private String ram;
        private String hdd;

        private boolean isBluetoothEnabled;
        private boolean isGraphicEnabled;

        public LaptopBuilder ( int laptopNo, String ram, String hdd ) {
            this.laptopNo = laptopNo;
            this.ram = ram;
            this.hdd = hdd;
        }

        public LaptopBuilder setBluetoothEnabled ( boolean bluetoothEnabled ) {
            isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public LaptopBuilder setGraphicEnabled ( boolean graphicEnabled ) {
            isGraphicEnabled = graphicEnabled;
            return this;
        }

        public Laptop build (){
            return new Laptop(this);
        }
    }
}
