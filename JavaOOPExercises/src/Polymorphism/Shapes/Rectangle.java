package Polymorphism.Shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
//        calculatePerimeter();
//        calculateArea();
    }


    @Override
    protected void calculatePerimeter() {
        double result = height*2 + width*2;
        super.setPerimeter(result);
    }

    @Override
    protected void calculateArea() {
        double result = height*width;
        super.setArea(result);
    }
}
