package section1_intro.part1_language_basics;


public class Point {
    int x;
    int y;

    // Add a constructor for creating Point objects
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Default constructor
    public Point() {
    }

    /**
     * Create an instance of class point that is located at the same coordinates as the current object, but in the
     * diagonally opposing quadrant of coordinate space.
     * So, when the current point is at (4, 4), this method will return Point(-4, -4)
     * and when the current point is at (2, -5) it will return Point(-2, 5).
     * @return inverse Point
     */
    Point createInversePoint() {
        return new Point(-this.x, -this.y); // Return a new Point with inverted coordinates
    }

    /**
     * This method returns the Euclidean distance of the current point (this) to the given point (otherPoint).
     * GIYF if you forgot what Euclidean distance is and how it is calculated.
     * @param otherPoint
     * @return euclidean distance
     */
    double euclideanDistanceTo(Point otherPoint) {
        // Calculate Euclidean distance: sqrt((x2 - x1)^2 + (y2 - y1)^2)
        int deltaX = this.x - otherPoint.x;
        int deltaY = this.y - otherPoint.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY); // Apply Euclidean distance formula
    }

    // Create a main() method demonstrating the use of class Point and its methods.
    public static void main(String[] args) {
        // Create a point at (2, -3)
        Point p1 = new Point(2, -3);

        // Create its inverse point
        Point inversePoint = p1.createInversePoint();
        System.out.println("Inverse of Point(2, -3): (" + inversePoint.x + ", " + inversePoint.y + ")");

        // Create another point at (4, 4)
        Point p2 = new Point(4, 4);

        // Calculate Euclidean distance between p1 and p2
        double distance = p1.euclideanDistanceTo(p2);
        System.out.println("Euclidean distance between (2, -3) and (4, 4): " + distance);
    }



}

