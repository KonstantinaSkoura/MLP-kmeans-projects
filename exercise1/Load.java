
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Load {
    private Point points[];
    private Point elegxos[];
    private int pointIndex;
    private int pointIndex2;
    private ArrayList<Neuron> network;
    private int total_Neurons;
    private int[] layersize;
    private int H1;
    private int H2;
    private int H3;
    private int K;
    private int d;


    public Load(Point[] elegxos, int pointindex2, Point[] points, int pointIndex, ArrayList<Neuron> network, int total_Neurons,int [] layersize,int H1,int H2,int H3,int K,int d) {
        this.points = points;
        this.pointIndex = pointIndex;
        this.network = network;
        this.total_Neurons = total_Neurons;
        this.layersize = layersize;
        this.H1 = H1;
        this.H2 = H2;
        this.H3 = H3;
        this.K = K;
        this.d = d;
        this.elegxos = elegxos;
        this.pointIndex2 = pointindex2;
    }

    public void readFile(String filename) {

        Scanner reader = null;
        try {
            reader = new Scanner(new FileInputStream(filename)); //Diavazw to arxeio filename sth metablhth reader
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file, please verify the path location!!");
            System.exit(0);
        }
        while (reader.hasNextLine()) {
            String line = reader.nextLine();// Apothikevo mia mia tis grammes tou reader sth line
            Point point;
            Point point2;
            String currentPoint[] = line.split("\t"); //Kanw split ta x1, x2 me tab giati auths ths morfhs einai to arxeios txt mas kai ta apothikevo se ena temp array
            if(filename == "ekpaideusi1.txt"){
                point = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 1);
                points[pointIndex++] = point;
            }else if(filename == "ekpaideusi2.txt"){
                point = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 2);
                points[pointIndex++] = point;
            }else if(filename == "ekpaideusi3.txt"){
                point = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 3);
                points[pointIndex++] = point;
            }else if(filename == "ekpaideusi4.txt"){
                point = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 4);
                points[pointIndex++] = point;
            }

            if(filename == "elegxos1.txt"){
                point2 = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 1);
                elegxos[pointIndex2++] = point2;
            }else if(filename == "elegxos2.txt"){
                point2 = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 2);
                elegxos[pointIndex2++] = point2;
            }else if(filename == "elegxos3.txt"){
                point2 = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 3);
                elegxos[pointIndex2++] = point2;
            }else if(filename == "elegxos4.txt"){
                point2 = new Point(Double.parseDouble(currentPoint[0]), Double.parseDouble(currentPoint[1]), 4);
                elegxos[pointIndex2++] = point2;
            }
        }
        reader.close();
    }

    public void initializeRandomWeights() {
        Random r = new Random();

        for (int i = 0; i < H1; i++) {//gia kathe neyrwna toy prwtoy krymmenoy
            for (int j = 0; j < d; j++) {//bazei 2 random weights se kathe neurwna
                network.get(i).getWeight().add(Math.round((-1 + 2 * r.nextDouble()) * 100.0) / 100.0);
            }
        }
        for (int i = H1; i < H1 + H2; i++) {//gia kathe neyrwna toy deyterou krymmenoy
            for (int j = 0; j < H1; j++) {//bazei H1 random weights se kathe neurwna
                network.get(i).getWeight().add(Math.round((-1 + 2 * r.nextDouble()) * 100.0) / 100.0);
            }
        }
        for (int i = H1 + H2; i < H1 + H2 + H3; i++) {//gia kathe neyrwna toy tritoy krymmenoy
            for (int j = 0; j < H2; j++) {//bazei H2 random weights se kathe neurwna
                network.get(i).getWeight().add(Math.round((-1 + 2 * r.nextDouble()) * 100.0) / 100.0);
            }
        }
        for (int i = H1 + H2 + H3; i < H1 + H2 + H3 + K; i++) {//gia kathe neyrwna toy tetartoy epipedou
            for (int j = 0; j < H3; j++) {//bazei H3 random weights se kathe neurwna
                network.get(i).getWeight().add(Math.round((-1 + 2 * r.nextDouble()) * 100.0) / 100.0);
            }
        }

        for (int i = 0; i < total_Neurons; i++) {
            network.get(i).setBias(Math.round((-1 + 2 * r.nextDouble()) * 100.0) / 100.0);
        }
    }
}
