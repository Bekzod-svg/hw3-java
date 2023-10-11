abstract class Engine {}

class CombustionEngine extends Engine {}

class ElectricEngine extends Engine {}

class HybridEngine extends Engine {}

class Manufacture {
    private String name;
    private String country;

    public Manufacture(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

abstract class Vehicle {
    protected Manufacture manufacture;
    protected Engine engine;

    public Vehicle(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }

    public abstract void showCharacteristics();
}

class ICEV extends Vehicle {
    public ICEV(Manufacture manufacture) {
        super(manufacture, new CombustionEngine());
    }

    @Override
    public void showCharacteristics() {
        System.out.println(manufacture.getName() + " ICEV with Combustion Engine.");
    }
}

class BEV extends Vehicle {
    public BEV(Manufacture manufacture) {
        super(manufacture, new ElectricEngine());
    }

    @Override
    public void showCharacteristics() {
        System.out.println(manufacture.getName() + " BEV with Electric Engine.");
    }
}

class HybridV extends Vehicle {
    public HybridV(Manufacture manufacture) {
        super(manufacture, new HybridEngine());
    }

    @Override
    public void showCharacteristics() {
        System.out.println(manufacture.getName() + " HybridV with Hybrid Engine.");
    }
}

public class VehicleInventory {
    public static void main(String[] args) {
        Manufacture geely = new Manufacture("Geely", "China");
        Manufacture byd = new Manufacture("BYD", "China");
        Manufacture nio = new Manufacture("NIO", "China");  // Added NIO

        Vehicle[] vehicles = {
                new ICEV(geely),
                new BEV(byd),
                new HybridV(nio)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.showCharacteristics();
        }
    }
}
