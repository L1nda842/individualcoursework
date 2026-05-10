public class Triangle extends Shape {
    private double sideA, sideB, sideC;

    public Triangle(double a, double b, double c) throws InvalidShapeException {
        if (!isValidTriangle(a, b, c))
            throw new InvalidShapeException("Invalid triangle sides");
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public Triangle(double a, double b, double c, String color, boolean filled) throws InvalidShapeException {
        super(color, filled);
        if (!isValidTriangle(a, b, c))
            throw new InvalidShapeException("Invalid triangle sides");
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a) && a > 0 && b > 0 && c > 0;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) throw new InvalidShapeException("Resize factor must be positive");
        sideA *= factor;
        sideB *= factor;
        sideC *= factor;
    }

    @Override
    public String toString() {
        return "Triangle[sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + ", " + super.toString() + "]";
    }
}
