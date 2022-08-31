package Polymorphism.Shapes;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }


    @Override
    protected void calculatePerimeter() {
        double result = 2 * Math.PI * radius;
        super.setPerimeter(result);
    }

    @Override
    protected void calculateArea() {
        double result = Math.PI * radius * radius;
        super.setArea(result);
    }
}
