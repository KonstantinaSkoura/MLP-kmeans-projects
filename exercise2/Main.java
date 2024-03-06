
public class Main {
    public static void main(String[] args) {

        int numberofPoints = 1200;
        int M = 12; // Arithmos omadwn
        int flag = 1; //Flag gia ton termatismo tou algorithmou
        Point points[] = new Point[numberofPoints];
        Point centers[] = new Point[M];
		String filepath = args[0];

        KMeans kmeans = new KMeans(points, centers, numberofPoints, flag, M);
        Error error = new Error(points, centers, numberofPoints);
        Load load = new Load(points, centers, numberofPoints, M);
        load.readFile(filepath);
        load.findRandomCenters();

        while (flag == 1) {
            flag = 0;
            kmeans.assignLabels();
            kmeans.findNewCenters();
        }
        //Ektypose ta telika kentra:
        System.out.println("Final centers:");
        for (int i = 0; i < M; i++) {
            System.out.println("Cluster " + (i + 1) + ": " + centers[i].x1 + ", " + centers[i].x2);
        }
        error.computeError();
    }
}