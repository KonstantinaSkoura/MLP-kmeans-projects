
public class KMeans {
    private Point[] points;
    private Point[] centers;
    private int numberofPoints;
    private int M;
    private int flag;
    public KMeans(Point[] points, Point[] centers, int numberofPoints, int flag, int M) {
        this.points = points;
        this.centers = centers;
        this.numberofPoints = numberofPoints;
        this.flag = flag;
        this.M = M;
    }

    //Ypologizw ta nea kentra me meso oro twn syntetagmenwn apo ola ta points:
    public void findNewCenters() {
        for (int i = 0; i < M; i++) {
            int counter = 0;
            float sumX1 = 0, sumX2 = 0;
            for (Point point : points) {
                if(point.previousTeam == i + 1){
                    sumX1 += point.x1;
                    sumX2 += point.x2;
                    counter++;
                }
            }
            centers[i].x1 = sumX1 / counter;
            centers[i].x2 = sumX2 / counter;
        }
    }
    public void assignLabels() {
        float min = 100.0f,eDistance = 0.0f;
        int minCenter = -1;

        for (int i = 0; i < numberofPoints; i++){
            for (int j = 0; j < M; j++){
                eDistance = euclideanDistance(points[i], centers[j]);
                if(eDistance < min){
                    min = eDistance;
                    minCenter = j + 1;
                }
            }
            terminate(points[i], minCenter);
            points[i].previousTeam = minCenter;
            min=100.0f;
        }
    }

    public float euclideanDistance(Point p, Point c) {
        return (float) Math.sqrt(Math.pow(p.x1 - c.x1, 2) + Math.pow(p.x2 - c.x2, 2));
    }

    public void terminate(Point p, int currentTeam) {
        if (p.previousTeam != currentTeam) {
            flag = 1;
        }
    }
}