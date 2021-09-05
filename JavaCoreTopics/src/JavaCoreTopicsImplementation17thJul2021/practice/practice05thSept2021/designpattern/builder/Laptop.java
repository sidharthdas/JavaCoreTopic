package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.designpattern.builder;

/**
 * @author sidharthdas on 05/09/21.
 */
public class Laptop {

    private int laptopId;
    private String laptopBrand;
    private String ssd;
    private String ram;

    private boolean isGraphicPresent;
    private boolean isBluetoothPresent;

    private Laptop ( LaptopBuilder builder ) {

        this.isBluetoothPresent = builder.isBluetoothPresent;
        this.laptopBrand = builder.laptopBrand;
        this.laptopId = builder.laptopId;
        this.ssd = builder.ssd;
        this.ram = builder.ram;
        this.isGraphicPresent = builder.isGraphicPresent;
    }

    public int getLaptopId () {
        return laptopId;
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

    public boolean isGraphicPresent () {
        return isGraphicPresent;
    }

    public boolean isBluetoothPresent () {
        return isBluetoothPresent;
    }

    public static class LaptopBuilder {

        private int laptopId;
        private String laptopBrand;
        private String ssd;
        private String ram;

        private boolean isGraphicPresent;
        private boolean isBluetoothPresent;

        public LaptopBuilder ( int laptopId, String laptopBrand, String ssd, String ram ) {
            this.laptopId = laptopId;
            this.laptopBrand = laptopBrand;
            this.ssd = ssd;
            this.ram = ram;
        }


        public LaptopBuilder setGraphicPresent ( boolean graphicPresent ) {
            isGraphicPresent = graphicPresent;
            return this;
        }

        public LaptopBuilder setBluetoothPresent ( boolean bluetoothPresent ) {
            isBluetoothPresent = bluetoothPresent;
            return this;
        }

        public Laptop build () {
            return new Laptop(this);
        }
    }
}
