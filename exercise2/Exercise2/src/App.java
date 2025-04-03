public class App {
    public static void main(String[] args) throws Exception {
        DataScientist employee1 = new DataScientist("John", null,  0);
        Researcher employee2 = new Researcher("Jane", null, 0);

        System.out.println("His name is " + employee1.name);
        System.out.println("His work is " + employee1.getWork());
        System.out.println("He earns " + employee1.getSalary());

        System.out.println();

        System.out.println("Her name is " + employee2.name);
        System.out.println("Her work is " + employee2.getWork());
        System.out.println("She earns " + employee2.getSalary());

        System.out.println();
        Car car1 = new Car(6, "10kwh");

        System.out.println("My car has " + car1.getCylinder() + " cylinders and " + car1.getBattery() + " battery");
    }
}
