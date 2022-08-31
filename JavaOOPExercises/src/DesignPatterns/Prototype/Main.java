package DesignPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        Point2D a = new Point2D(13,42);

        Point2D b = a.clone();

        System.out.println(a.getX() + " " + a.getY());
        System.out.println(b.getX() + " " + b.getY());

    }
}
