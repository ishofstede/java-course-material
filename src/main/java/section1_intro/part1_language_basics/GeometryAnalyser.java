package section1_intro.part1_language_basics;

import java.text.NumberFormat;

    public class GeometryAnalyser {
        public static void main(String[] args) {
            if (args.length != 5) {
                System.out.println("Usage: java GeometryAnalyser <x1> <y1> <x2> <y2> <operation>");
                return;
            }

            // Parse the command-line arguments
            int x1 = Integer.parseInt(args[0]);
            int y1 = Integer.parseInt(args[1]);
            int x2 = Integer.parseInt(args[2]);
            int y2 = Integer.parseInt(args[3]);
            String operation = args[4];

            // Create Point instances
            Point upperLeft = new Point();
            upperLeft.x = x1;
            upperLeft.y = y1;

            Point lowerRight = new Point();
            lowerRight.x = x2;
            lowerRight.y = y2;

            // Perform the requested operation
            if ("surf".equals(operation)) {
                Rectangle rectangle = new Rectangle();
                rectangle.upperLeft = upperLeft;
                rectangle.lowerRight = lowerRight;
                int surface = rectangle.getSurface();
                System.out.println(surface);
            } else if ("dist".equals(operation)) {
                double distance = upperLeft.euclideanDistanceTo(lowerRight);
                System.out.printf("%.1f%n", distance); // Print rounded to 1 decimal place
            } else {
                System.out.println("Invalid operation. Use 'dist' or 'surf'.");
            }
        }
    }
