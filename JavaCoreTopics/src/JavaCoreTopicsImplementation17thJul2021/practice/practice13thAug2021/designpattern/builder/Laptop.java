package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.designpattern.builder;

/**
 * @author sidharthdas on 13/08/21.
 */
public class Laptop {

    private int laptopId;
    private String laptopBrand;
    private String laptopRam;
    private String laptopHDD;

    private boolean isBluetoothEnabled;
    private boolean isGraphicEnabled;

    private Laptop ( LaptopBuilder builder ) {
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicEnabled = builder.isGraphicEnabled;

        this.laptopBrand = builder.laptopBrand;
        this.laptopHDD = builder.laptopHDD;
        this.laptopRam = builder.laptopRam;

    }

    public int getLaptopId () {
        return laptopId;
    }

    public String getLaptopBrand () {
        return laptopBrand;
    }

    public String getLaptopRam () {
        return laptopRam;
    }

    public String getLaptopHDD () {
        return laptopHDD;
    }

    public boolean isBluetoothEnabled () {
        return isBluetoothEnabled;
    }

    public boolean isGraphicEnabled () {
        return isGraphicEnabled;
    }

    public static class LaptopBuilder {

        private int laptopId;
        private String laptopBrand;
        private String laptopRam;
        private String laptopHDD;

        private boolean isBluetoothEnabled;
        private boolean isGraphicEnabled;

        public LaptopBuilder ( int laptopId, String laptopBrand, String laptopRam, String laptopHDD ) {
            this.laptopId = laptopId;
            this.laptopBrand = laptopBrand;
            this.laptopRam = laptopRam;
            this.laptopHDD = laptopHDD;
        }


        public LaptopBuilder setBluetoothEnabled ( boolean bluetoothEnabled ) {
            isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public LaptopBuilder setGraphicEnabled ( boolean graphicEnabled ) {
            isGraphicEnabled = graphicEnabled;
            return this;
        }

        public Laptop build(){
            return new Laptop(this);
        }
    }
}
