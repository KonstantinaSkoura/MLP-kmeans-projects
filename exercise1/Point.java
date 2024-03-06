public class Point {
    private double x1;
    private double x2;
    private int flag;// Gia na ksero se poio arxeio ekpaiushs brisketai kai ti kathgorias einai h eksodos
    Point(double x1, double x2, int flag) {
        this.x1 = x1;
        this.x2 = x2;
        this.flag = flag;
    }

    public double getX1() {
        return x1;
    }
    public void setX1(double x1) {
        this.x1 = x1;
    }
    public double getX2() {
        return x2;
    }
    public void setX2(double x2) {
        this.x2 = x2;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
}