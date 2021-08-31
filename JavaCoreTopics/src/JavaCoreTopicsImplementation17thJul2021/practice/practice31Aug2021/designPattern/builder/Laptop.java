package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.designPattern.builder;

/**
 * @author sidharthdas on 31/08/21.
 */
public class Laptop {

    private  String laptopBrand;
    private  String ssd;
    private  String ram;

    private  boolean isBluetooth;
    private  boolean isGraphic;

    private Laptop(LaptopBuilder builder){

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

    public boolean isBluetooth () {
        return isBluetooth;
    }

    public boolean isGraphic () {
        return isGraphic;
    }

    public static class LaptopBuilder{

        private  String laptopBrand;
        private  String ssd;
        private  String ram;

        private  boolean isBluetooth;
        private  boolean isGraphic;


        public LaptopBuilder ( String laptopBrand, String ssd, String ram ) {
            this.laptopBrand = laptopBrand;
            this.ssd = ssd;
            this.ram = ram;
        }

        public LaptopBuilder setBluetooth ( boolean bluetooth ) {
            isBluetooth = bluetooth;
            return this;
        }

        public LaptopBuilder setGraphic ( boolean graphic ) {
            isGraphic = graphic;
            return this;
        }


        public Laptop build(){
            return  new Laptop(this);
        }
    }
}
