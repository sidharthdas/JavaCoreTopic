package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.designpartterntest.Builder;

/**
 * @author sidharthdas on 21/07/21.
 */
public class Laptop {

    private int id;
    private String ram;
    private String memory;
    private String chip;

    private boolean isBluetoothEnabled;
    private boolean isGraphicEnabled;

    private Laptop ( LaptopBuilder builder ) {
        this.chip = builder.chip;
        this.ram = builder.ram;
        this.memory = builder.memory;
        this.id = builder.id;

    }

    public int getId () {
        return id;
    }

    public String getRam () {
        return ram;
    }

    public String getMemory () {
        return memory;
    }

    public String getChip () {
        return chip;
    }

    public boolean isBluetoothEnabled () {
        return isBluetoothEnabled;
    }

    public boolean isGraphicEnabled () {
        return isGraphicEnabled;
    }

    public static class LaptopBuilder {

        private int id;
        private String ram;
        private String memory;
        private String chip;

        private boolean isBluetoothEnabled;
        private boolean isGraphicEnabled;

        public LaptopBuilder ( int id, String ram, String memory, String chip ) {
            this.id = id;
            this.ram = ram;
            this.memory = memory;
            this.chip = chip;
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
