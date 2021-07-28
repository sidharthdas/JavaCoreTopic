package JavaCoreTopicsImplementation17thJul2021.practice.designpartern.builder;

/**
 * @author sidharthdas on 28/07/21.
 */
public class Laptop {

    private String brandName;
    private String ram;
    private String hhd;

    private boolean isBluetoothEnabled;
    private boolean isGraphicEnabled;

    private Laptop(LaptopBuilder builder){
        this.brandName = builder.brandName;
        this.hhd = builder.hhd;
        this.ram = builder.ram;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicEnabled = builder.isGraphicEnabled;

    }

    public String getBrandName () {
        return brandName;
    }

    public String getRam () {
        return ram;
    }

    public String getHhd () {
        return hhd;
    }

    public boolean isBluetoothEnabled () {
        return isBluetoothEnabled;
    }

    public boolean isGraphicEnabled () {
        return isGraphicEnabled;
    }


    public static class LaptopBuilder{

        private String brandName;
        private String ram;
        private String hhd;

        private boolean isBluetoothEnabled;
        private boolean isGraphicEnabled;

        public LaptopBuilder ( String brandName, String ram, String hhd ) {
            this.brandName = brandName;
            this.ram = ram;
            this.hhd = hhd;
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
