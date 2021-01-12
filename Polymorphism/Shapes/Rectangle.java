package Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        Double result=2*height+2*width;
        super.setPerimeter(result);
        return result;
    }

    @Override
    public Double calculateArea() {
        Double result= height*width;
        super.setArea(result);
        return result;
    }
}
