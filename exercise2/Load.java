
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Load {
    private Point[] points;
    private Point[] centers;
    private int numberofPoints;
    private int M;
    public Load(Point[] points, Point[] centers, int numberofPoints, int M) {
        this.points = points;
        this.centers = centers;
        this.numberofPoints = numberofPoints;
        this.M = M;
    }

    public void readFile(String filename) {
        Scanner reader = null;
        int pointIndex = 0;

        try {
            reader = new Scanner(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file, please verify the path location!!");
            System.exit(0);
        }
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String currentPoint[] = line.split("\t");
            Point point = new Point(Float.parseFloat(currentPoint[0]), Float.parseFloat(currentPoint[1]));
            points[pointIndex++] = point;
        }
        reader.close();
    }

    public void findRandomCenters() {
        Random r = new Random();
        Point center;
        int randomIndex;
        for (int i = 0; i < M; i++) {
            randomIndex = r.nextInt(numberofPoints - 1);
            //random point
            center = points[randomIndex];
            centers[i] = center;
            centers[i].previousTeam = i + 1; //Arxikopoiw to previousTeam gia ola ta kentra
        }
    }
}