
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        float x1= 0.0F;
        float x2= 0.0F;
        int upperbound1 = 0;
        int lowerbound1 = 0;
        int upperbound2 = 0;
        int lowerbound2 = 0;


        try {
            FileWriter myObj = new FileWriter("examples.txt");

            Random rand = new Random();
            upperbound1 = 119;
            lowerbound1 = 80;
            upperbound2 = 119;
            lowerbound2 = 80;

            for (int i=0;i<150;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 49;
            lowerbound1 = 0;
            upperbound2 = 49;
            lowerbound2 = 0;

            for (int i=0;i<150;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 199;
            lowerbound1 = 150;
            upperbound2 = 49;
            lowerbound2 = 0;
            for (int i=0;i<150;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 49;
            lowerbound1 = 0;
            upperbound2 = 199;
            lowerbound2 = 150;

            for (int i=0;i<150;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 199;
            lowerbound1 = 150;
            upperbound2 = 199;
            lowerbound2 = 150;

            for (int i=0;i<150;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 39;
            lowerbound1 = 0;
            upperbound2 = 119;
            lowerbound2 = 80;

            for (int i=0;i<75;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 199;
            lowerbound1 = 160;
            upperbound2 = 119;
            lowerbound2 = 80;

            for (int i=0;i<75;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 119;
            lowerbound1 = 80;
            upperbound2 = 69;
            lowerbound2 = 30;

            for (int i=0;i<75;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 119;
            lowerbound1 = 80;
            upperbound2 = 169;
            lowerbound2 = 130;

            for (int i=0;i<75;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            upperbound1 = 119;
            lowerbound1 = 0;
            upperbound2 = 119;
            lowerbound2 = 0;

            for (int i=0;i<150;i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1 + 1) + lowerbound1)/100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2 + 1) + lowerbound2)/100;

                String formattedFloat1 = String.format("%.2f", x1);
                String formattedFloat2 = String.format("%.2f", x2);
                myObj.write(formattedFloat1);
                myObj.write("\t");
                myObj.write(formattedFloat2);
                myObj.write("\n");
            }

            myObj.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}