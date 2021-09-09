package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.designpattern.builder;

/**
 * @author sidharthdas on 09/09/21.
 */
public class Laptop {

    private String laptopBrand;
    private String ssd;
    private String ram;
    private boolean isBluetoothEnabled;
    private boolean isGraphicEnabled;

    private Laptop(LaptopBuilder builder){
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.laptopBrand = builder.laptopBrand;
        this.ram = builder.ram;
        this.ssd = builder.ssd;
        this.isGraphicEnabled = builder.isGraphicEnabled;

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

    public boolean isBluetoothEnabled () {
        return isBluetoothEnabled;
    }

    public boolean isGraphicEnabled () {
        return isGraphicEnabled;
    }


    public static class LaptopBuilder{

        private String laptopBrand;
        private String ssd;
        private String ram;
        private boolean isBluetoothEnabled;
        private boolean isGraphicEnabled;

        public LaptopBuilder ( String laptopBrand, String ssd, String ram ) {
            this.laptopBrand = laptopBrand;
            this.ssd = ssd;
            this.ram = ram;
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
