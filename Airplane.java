public class Airplane
{
    private double distance;
    private int direction;
    private int altitude;
    private String callSign;

    public Airplane(String cs, double dist, int dir, int alt)
    {
        distance = Math.abs(dist);
        direction = dir % 360;  // Ensure direction is always between 0 and 359
        altitude = Math.max(alt, 0);  // Ensure altitude is always non-negative
        callSign = cs;
    }

    public Airplane()
    {
        this("AAA01", 1, 0, 0);
    }

    public void gainAlt()
    {
        altitude += 1000;
    }

    public void loseAlt()
    {
        altitude -= 1000;
        if (altitude < 0) {
            altitude = 0;
        }
    }

    public int getAlt()
    {
        return altitude;
    }

    public void move(double dist, int dir)
    {
        double r1 = distance;
        double r2 = dist;
        double u1 = Math.toRadians(direction);
        double u2 = Math.toRadians(dir);
        
        // Update the distance using law of cosines
        distance = Math.sqrt(r1 * r1 + r2 * r2 + 2 * r1 * r2 * Math.cos(u2 - u1));
        
        // Update the direction using atan2
        double ang = Math.atan2(r1 * Math.sin(u1) + r2 * Math.sin(u2), r1 * Math.cos(u1) + r2 * Math.cos(u2));
        direction = Math.floorMod((int) Math.round(Math.toDegrees(ang)), 360);
    }

    // Helper method for rounding
    private String formatDistance(double dist)
    {
        return String.format("%.2f", dist);
    }

    @Override
    public String toString()
    {
        // Use String.format for cleaner string formatting
        return String.format("%s - %s miles away at bearing %03d°, altitude %d feet", 
                             callSign, formatDistance(distance), direction, altitude);
    }

    public double distTo(Airplane other)
    {
        double r1 = this.distance;
        double r2 = other.distance;
        double u1 = Math.toRadians(this.direction);
        double u2 = Math.toRadians(other.direction);
        
        // Distance calculation using law of cosines
        double between = Math.sqrt(r1 * r1 + r2 * r2 - 2 * r1 * r2 * Math.cos(u2 - u1));
        
        return Double.parseDouble(formatDistance(between));
    }
}
