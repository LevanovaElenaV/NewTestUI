package lesson4;

public class TriangleDemo {
    public static void main(String[] args)  {
        try {
            Triangle t1 = new Triangle(1, 3, 3);
            t1.getArea();
        } catch (SizeLengthIsNotPositiveException e) {
            e.printStackTrace();
        }
    }
}
