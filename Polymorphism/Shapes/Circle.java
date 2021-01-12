package Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(double radius) {
        this.radius=radius;
    }

    @Override
    public Double calculatePerimeter() {
        Double result=2*Math.PI*radius;
        setPerimeter(result);
        return result;
    }

    @Override
    public Double calculateArea() {
        Double result=Math.PI*radius*radius;
        super.setArea(result);
        return result;
    }
}
