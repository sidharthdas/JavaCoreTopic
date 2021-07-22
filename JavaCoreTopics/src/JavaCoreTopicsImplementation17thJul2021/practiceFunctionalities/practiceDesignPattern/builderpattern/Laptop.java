package JavaCoreTopicsImplementation17thJul2021.practiceFunctionalities.practiceDesignPattern.builderpattern;

/**
 * @author sidharthdas on 22/07/21.
 */
public class Laptop {

    private int id;
    private String ram;
    private String hdd;

    private boolean isEnabledBluetooth;
    private boolean isEnabledItel;

    private Laptop ( LaptopBuilder builder ) {
        this.id = builder.id;
        this.ram = builder.ram;
        this.hdd = builder.hdd;

        this.isEnabledBluetooth = builder.isEnabledBluetooth;
        this.isEnabledItel = builder.isEnabledItel;

    }

    public int getId () {
        return id;
    }

    public String getRam () {
        return ram;
    }

    public String getHdd () {
        return hdd;
    }

    public boolean isEnabledBluetooth () {
        return isEnabledBluetooth;
    }

    public boolean isEnabledItel () {
        return isEnabledItel;
    }

    @Override
    public String toString () {
        return "Laptop{" +
                "id=" + id +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", isEnabledBluetooth=" + isEnabledBluetooth +
                ", isEnabledItel=" + isEnabledItel +
                '}';
    }

    public static class LaptopBuilder {

        private int id;
        private String ram;
        private String hdd;

        private boolean isEnabledBluetooth;
        private boolean isEnabledItel;

        public LaptopBuilder ( int id, String ram, String hdd ) {
            this.id = id;
            this.ram = ram;
            this.hdd = hdd;
        }

        public LaptopBuilder setEnabledBluetooth ( boolean enabledBluetooth ) {
            isEnabledBluetooth = enabledBluetooth;
            return this;
        }

        public LaptopBuilder setEnabledItel ( boolean enabledItel ) {
            isEnabledItel = enabledItel;
            return this;
        }

        public Laptop build(){
            Laptop laptop = new Laptop(this);
            return laptop;
        }
    }
}
