interface Engine {
    double accelerateSpeed();
    boolean isBasicSpeedValidate();
    boolean isEngineSpeedValidate();
    int getBasicSpeed();
}

class PetrolEngine implements Engine{

    private double engineCapacity;
    private int basicSpeed;
    public double petrolEnginePower = 90;
    PetrolEngine(double engineCapacity, int basicSpeed) {
        this.engineCapacity = engineCapacity;
        this.basicSpeed = basicSpeed;
    }

    public double accelerateSpeed() {

        return  (petrolEnginePower/  100) * engineCapacity * 1050;
    }
    public boolean isBasicSpeedValidate() {
        return basicSpeed >= 0 && basicSpeed <= 140;
    }
    public boolean isEngineSpeedValidate () {
        return accelerateSpeed() >= 0 && accelerateSpeed() <= 6000;
    }

    public int getBasicSpeed() {
        return basicSpeed;
    }
}
class GasolineEngine implements Engine {
    private int basicSpeed;
    private double engineCapacity;
    public double gasolineEnginePower = 75;

    public GasolineEngine(double engineCapacity, int basicSpeed) {
        this.basicSpeed = basicSpeed;
        this.engineCapacity = engineCapacity;
    }

    public double accelerateSpeed() {
        return (gasolineEnginePower / 100) * engineCapacity * 950;
    }

    public boolean isBasicSpeedValidate() {
        return basicSpeed >= 0 && basicSpeed <= 120;
    }

    public boolean isEngineSpeedValidate() {
        return accelerateSpeed() >= 0 && accelerateSpeed() <= 5250;
    }

    public int getBasicSpeed() {
        return basicSpeed;
    }
}
class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }


    public double drive() {
        double finalSpeed = engine.getBasicSpeed() + (engine.accelerateSpeed() * 0.015);
        return finalSpeed;
    }


    public void accelerateProcess() {
        if (engine.isBasicSpeedValidate() && engine.isEngineSpeedValidate()) {
            System.out.println("Your speed is  " + engine.getBasicSpeed() + " km/h");
            System.out.println("You accelerate your engine speed is " +
                    Math.round(engine.accelerateSpeed()) +
                    " So you'r speed up to " + Math.round(drive()) + " km/h");
        }
    }
}
class Application {
    public static void main(String[] args) {

        GasolineEngine gasolineEngine = new GasolineEngine(1.4, 120);
        Car gasolineCar = new Car(gasolineEngine);
        PetrolEngine petrolEngine = new PetrolEngine(2.4, 140);
        Car petrolCar = new Car(petrolEngine);


        gasolineCar.accelerateProcess();
        petrolCar.accelerateProcess();
    }
}