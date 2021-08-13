package JavaCoreTopicsImplementation17thJul2021.practice.practice6thAugust2021.designpartern.bilder;

/**
 * @author sidharthdas on 06/08/21.
 */
public class Laptop {

    private int laptopId;
    private String ram;
    private String hdd;

    private boolean isGraphicEnabled;
    private boolean isBluetoothEnabled;

    public Laptop ( LaptopBuilder builder ) {
        this.laptopId = builder.laptopId;
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicEnabled = builder.isGraphicEnabled;

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

    public boolean isGraphicEnabled () {
        return isGraphicEnabled;
    }

    public boolean isBluetoothEnabled () {
        return isBluetoothEnabled;
    }

    public static class LaptopBuilder {

        private int laptopId;
        private String ram;
        private String hdd;

        private boolean isGraphicEnabled;
        private boolean isBluetoothEnabled;

        public LaptopBuilder ( int laptopId, String ram, String hdd ) {
            this.laptopId = laptopId;
            this.ram = ram;
            this.hdd = hdd;
        }

        public LaptopBuilder setGraphicEnabled ( boolean graphicEnabled ) {
            isGraphicEnabled = graphicEnabled;
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
