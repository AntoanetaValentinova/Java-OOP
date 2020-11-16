package PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isBiggerThanTheBottom (Point point) {
        return this.x<=point.x&&this.y<=point.y;
    }

    public boolean isLowerThanTheTop (Point point) {
        return this.x>=point.x&&this.y>=point.y;
    }
}
