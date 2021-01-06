package ClassBoxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        checkSide(length);
        this.length=length;
    }

    private void checkSide(double length) {
        if (length<=0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        checkSide(width);
        this.width = width;
    }

    private void setHeight(double height) {
        checkSide(height);
        this.height = height;
    }

    public double calculateSurfaceArea () {
        return 2*this.length*this.width + 2*this.length*this.height + 2*this.width*this.height;
    }

    public double calculateLateralSurfaceArea () {
        return 2*this.length*this.height + 2*this.width*this.height;
    }

    public double calculateVolume() {
        return this.length*this.width*this.height;
    }
}
