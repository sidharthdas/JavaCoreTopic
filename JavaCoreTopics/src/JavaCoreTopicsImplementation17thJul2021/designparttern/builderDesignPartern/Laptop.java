package JavaCoreTopicsImplementation17thJul2021.designparttern.builderDesignPartern;

/**
 * @author sidharthdas on 21/07/21.
 */
public class Laptop {

    private String ram;
    private String hdd;
    private String cpu;

    private boolean isGraphicsEnabled;
    private boolean isBluetoothEnabled;

    //1. make the constructor private so that no one can directly create the obj of Laptop
    private Laptop ( LaptopBuilder builder ) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.hdd = builder.hdd;

        this.isGraphicsEnabled = builder.isGraphicsEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public String getRam () {
        return ram;
    }

    public String getHdd () {
        return hdd;
    }

    public String getCpu () {
        return cpu;
    }

    public boolean isGraphicsEnabled () {
        return isGraphicsEnabled;
    }

    public boolean isBluetoothEnabled () {
        return isBluetoothEnabled;
    }

    public static class LaptopBuilder {

        private String ram;
        private String hdd;
        private String cpu;

        private boolean isGraphicsEnabled;
        private boolean isBluetoothEnabled;

        public LaptopBuilder ( String ram, String hdd, String cpu ) {
            this.ram = ram;
            this.hdd = hdd;
            this.cpu = cpu;
        }

        public LaptopBuilder setGraphicsEnabled ( boolean graphicsEnabled ) {
            isGraphicsEnabled = graphicsEnabled;
            return this;
        }

        public LaptopBuilder setBluetoothEnabled ( boolean bluetoothEnabled ) {
            isBluetoothEnabled = bluetoothEnabled;
            return this;
        }


        public Laptop build () {
            return new Laptop(this);
        }
    }
}
