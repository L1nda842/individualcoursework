public class ShapeDemo {

    public static void printAreas(Shape[] shapes) {

        for (Shape s : shapes) {

            System.out.println(
                    s.getClass().getSimpleName()
                    + " Area = " + s.getArea());
        }
    }

    public static Shape largest(Shape[] shapes) {

        Shape largest = shapes[0];

        for (Shape s : shapes) {

            if (s.getArea() > largest.getArea()) {

                largest = s;
            }
        }

        return largest;
    }

    public static void main(String[] args) {

        try {

            Shape[] shapes = {

                new Circle(7),
                new Rectangle(4, 6),
                new Triangle(3, 4, 5)

            };

            System.out.println("Areas of Shapes");

            printAreas(shapes);

            System.out.println();

            System.out.println(
                    "Largest Shape = "
                    + largest(shapes));

            // Demonstrating exception handling

            Triangle t = new Triangle(1, 2, 10);

        }

        catch (InvalidShapeException e) {

            System.out.println(
                    "Exception caught: "
                    + e.getMessage());

        }

    }

}
