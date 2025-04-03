class Car implements Hybrid {
    int cylinders;
    String battery;

    Car(int cyl, String bat) {
        this.cylinders = cyl;
        this.battery = bat;
    }

    public int getCylinder(){
        return this.cylinders;
    }
    public String getBattery(){
        return this.battery;
    } 
    public String showSource(){
        return "my car runs both on gas and electricity";
    }
}