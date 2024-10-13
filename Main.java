import java.util.Scanner;

class Airplane
{
    String callSign;
    double distance; // in nautical miles
    double bearing; // in degrees
    double altitude; // in feet

    public Airplane(String callSign, double distance, double bearing, double altitude)
    {
        this.callSign = callSign;
        this.distance = distance;
        this.bearing = bearing;
        this.altitude = altitude;
    }

    public double calculateDistance(Airplane other)
    {
        return Math.abs(this.distance - other.distance);
    }

    public double calculateAltitudeDifference(Airplane other)
    {
        return Math.abs(this.altitude - other.altitude);
    }

    @Override
    public String toString()
    {
        return "Call-Sign: " + callSign + ", Distance: " + distance + " nm, Bearing: " + bearing + " degrees, Altitude: " + altitude + " ft";
    }
}

public class Main {
    public static void main(String[] args)
    {
        // Create Airplane 1 and 2
        Airplane airplane1 = new Airplane("Airplane1", 150.0, 45.0, 30000.0);
        Airplane airplane2 = new Airplane("Airplane2", 200.0, 90.0, 32000.0);

        // Create a Scanner
        Scanner scanner = new Scanner(System.in);

        // Getting inputs for Airplane 3
        System.out.println("Enter the details of the third airplane (call-sign, distance, bearing and altitude): ");
        String callSign = scanner.next();
        double distance = scanner.nextDouble();
        double bearing = scanner.nextDouble();
        double altitude = scanner.nextDouble();

        // Create Airplane 3 from inputs
        Airplane airplane3 = new Airplane(callSign, distance, bearing, altitude);

        // Print the initial positions
        System.out.println("\nInitial Positions:");
        System.out.println(airplane1);
        System.out.println(airplane2);
        System.out.println(airplane3);

        // Print initial distances 
        System.out.println("\nInitial Distances:");
        System.out.println("The distance between Airplane 1 and Airplane 2 is " + airplane1.calculateDistance(airplane2) + " nm");
        System.out.println("The distance between Airplane 1 and Airplane 3 is " + airplane1.calculateDistance(airplane3) + " nm");
        System.out.println("The distance between Airplane 2 and Airplane 3 is " + airplane2.calculateDistance(airplane3) + " nm");

        // Print initial height differences
        System.out.println("\nInitial Height Differences:");
        System.out.println("The difference in height between Airplane 1 and Airplane 2 is " + airplane1.calculateAltitudeDifference(airplane2) + " ft");
        System.out.println("The difference in height between Airplane 1 and Airplane 3 is " + airplane1.calculateAltitudeDifference(airplane3) + " ft");
        System.out.println("The difference in height between Airplane 2 and Airplane 3 is " + airplane2.calculateAltitudeDifference(airplane3) + " ft");

        // Airplane 1 changes
        airplane1.distance += 50;
        airplane1.altitude -= 1000;

        // Airplane 2 changes
        airplane2.distance -= 20;
        airplane2.altitude += 500;

        // Airplane 3 changes
        airplane3.distance += 30;
        airplane3.altitude -= 200;

        // Print new positions of airplanes
        System.out.println("\nNew Positions: ");
        System.out.println(airplane1);
        System.out.println(airplane2);
        System.out.println(airplane3);

        // Print new distances between airplanes
        System.out.println("\nNew Distances:");
        System.out.println("The distance between Airplane 1 and Airplane 2 is " + airplane1.calculateDistance(airplane2) + " nm");
        System.out.println("The distance between Airplane 1 and Airplane 3 is " + airplane1.calculateDistance(airplane3) + " nm");
        System.out.println("The distance between Airplane 2 and Airplane 3 is " + airplane2.calculateDistance(airplane3) + " nm");

        // Print new heights between airplanes
        System.out.println("\nNew Height Differences:");
        System.out.println("The difference in height between Airplane 1 and Airplane 2 is " + airplane1.calculateAltitudeDifference(airplane2) + " ft");
        System.out.println("The difference in height between Airplane 1 and Airplane 3 is " + airplane1.calculateAltitudeDifference(airplane3) + " ft");
        System.out.println("The difference in height between Airplane 2 and Airplane 3 is " + airplane2.calculateAltitudeDifference(airplane3) + " ft");
    }
}
