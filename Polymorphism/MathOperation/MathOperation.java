package MathOperation;

public class MathOperation {

    public Integer add(int a, int b) {
        return a+b;
    }
    public Integer add(int a, int b,int c) {
        return this.add(a,b)+c;
    }

    public Integer add(int a, int b, int c, int d) {
        return this.add(a,b,c)+d;
    }
}
