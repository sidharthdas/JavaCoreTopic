package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.designPattern.builder;

/**
 * @author sidharthdas on 31/07/21.
 */
public class Laptop {

    private int laptopId;
    private String ram;
    private String hdd;

    private boolean isBluetoothEnabled;
    private boolean isGraphicsEnabled;

    private Laptop(LaptopBuilder builder){
        this.laptopId = builder.laptopId;
        this.hdd = builder.hdd;
        this.ram = builder.ram;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicsEnabled = builder.isGraphicsEnabled;
    }


    public int getLaptopId () {
        return laptopId;
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

    public boolean isGraphicsEnabled () {
        return isGraphicsEnabled;
    }


    public static class LaptopBuilder{

        private int laptopId;
        private String ram;
        private String hdd;

        private boolean isBluetoothEnabled;
        private boolean isGraphicsEnabled;

        public LaptopBuilder ( int laptopId, String ram, String hdd ) {
            this.laptopId = laptopId;
            this.ram = ram;
            this.hdd = hdd;
        }

        public LaptopBuilder setBluetoothEnabled ( boolean bluetoothEnabled ) {
            isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public LaptopBuilder setGraphicsEnabled ( boolean graphicsEnabled ) {
            isGraphicsEnabled = graphicsEnabled;
            return this;
        }

        public Laptop build(){
            return new Laptop(this);
        }
    }
}
