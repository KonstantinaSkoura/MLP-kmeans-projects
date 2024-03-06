

public class Error {
    private Point[] points;
    private Point[] centers;
    private int numberofPoints;
    public Error(Point[] points, Point[] centers, int numberofPoints) {
        this.points = points;
        this.centers = centers;
        this.numberofPoints = numberofPoints;
    }
    public void computeError(){
        float  sfalma = 0;
        for (int i=0;i<numberofPoints;i++){
            sfalma += Math.sqrt(Math.pow(centers[points[i].previousTeam - 1].x1-points[i].x1,2)+Math.pow(centers[points[i].previousTeam - 1].x2-points[i].x2,2));
        }
        System.out.println();
        System.out.println("Sfalma Omadopoihshs:" + sfalma);
    }
}