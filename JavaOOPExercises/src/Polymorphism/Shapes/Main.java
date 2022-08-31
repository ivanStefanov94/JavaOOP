package Polymorphism.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(13, 2);

        Shape circle = new Circle(3);

        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
    }
}
