package lesson4;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws SizeLengthIsNotPositiveException {
        if (a <= 0) {
            throw new SizeLengthIsNotPositiveException("Сторона a треугольника не положительная");
        }
        if (b <= 0) {
            throw new SizeLengthIsNotPositiveException("Сторона b треугольника не положительная");
        }
        if (c <= 0) {
            throw new SizeLengthIsNotPositiveException("Сторона c треугольника не положительная");
        }
        if ((a + b > c ) && (a + c > b) && (b + c > a)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new SizeLengthIsNotPositiveException("Треугольник с такими сторонами не существует");
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getArea() {
        double p= (a+b+c)/2;
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
//      System.out.println("Площадь треугольника равна " + s);
        return s;
    }

}
