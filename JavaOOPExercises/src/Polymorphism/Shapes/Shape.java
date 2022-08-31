package Polymorphism.Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        calculatePerimeter();
        return perimeter;
    }

    public double getArea() {
        calculateArea();
        return area;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();
}
