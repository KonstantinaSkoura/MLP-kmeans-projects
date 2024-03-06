
import java.util.ArrayList;
import static java.lang.Math.*;
import static java.lang.System.exit;

public class ForwardPassModel {
    private String  orisma1;
    private String  orisma2;
    private String  orisma3;
    private double a_func;
    private int H1;
    private int H2;
    private int H3;
    private int K;
    private int[] layersize;
    private ArrayList<Neuron> network;
    private ArrayList<Double> gu;
    private ArrayList<Double> products;
    private ArrayList<Double> output;
    public ForwardPassModel( ArrayList<Neuron> network, String orisma1, String orisma2, String orisma3,double a_func, int H1, int H2, int H3, int K, int[] layersize, ArrayList<Double> gu, ArrayList<Double> products,ArrayList<Double> output) {
        this.orisma1 = orisma1;
        this.orisma2 = orisma2;
        this.orisma3 = orisma3;
        this.a_func = a_func;
        this.H1 = H1;
        this.H2 = H2;
        this.H3 = H3;
        this.K = K;
        this.layersize = layersize;
        this.gu = gu;
        this.products = products;
        this.network = network;
        this.output = output;
    }

    public void forwardPass(double x1,double x2){
        double result = 0.0;
        double gu1;
        for(int i =0;i<H1;i++){//diatrexw tous neyrwnes  apo to 1o krummeno
            result += x1 * network.get(i).getWeight().get(0) + x2* network.get(i).getWeight().get(1); //prwto baros prwtou nwurwna
            products.add(result + network.get(i).getBias());
            gu1 = activate_function(result + network.get(i).getBias(),network.get(i).getLayer_id());
            gu.add(gu1);
            result = 0.0;
        }
        for(int i = H1;i < H1 + H2;i ++){ //diatrexw neyrwnes toy  2ou krymmenou
            for(int j = 0;j <network.get(i).getWeight().size();j++){ //barh toy 2ou krymmenou kathe neurwna
                result += gu.get(j) * network.get(i).getWeight().get(j);//xrhsimopoiw j kai sta 2 gt yparxei antistoixia
            }
            products.add(result + network.get(i).getBias());//prosthetw to u sto arraylist
            gu1 = activate_function(result + network.get(i).getBias(),network.get(i).getLayer_id());
            gu.add(gu1);
            result = 0.0;
        }
        for(int i = H1+H2;i < H1+ H2+ H3;i ++){ //diatrexw neyrwnes toy 3ou krymmenou
            for(int j = 0;j <network.get(i).getWeight().size();j++){ //barh toy 3ou krymmenou kathe nwurwna
                result += gu.get(j+H1) * network.get(i).getWeight().get(j);
            }
            products.add(result +  network.get(i).getBias());
            gu1 = activate_function(result + network.get(i).getBias(),network.get(i).getLayer_id());
            gu.add(gu1);
            result = 0.0;
        }
        for(int i = H1+H2+H3;i < H1+ H2+ H3 + K;i ++){ //diatrexw neyrwnes toy 4ou epipedou eksodou
            for(int j = 0;j <network.get(i).getWeight().size();j++){ //barh toy 4ou epipedou kathe nwurwna
                result += gu.get(j+H1+H2) * network.get(i).getWeight().get(j);
            }
            products.add(result + network.get(i).getBias());
            gu1 = activate_function(result + network.get(i).getBias(),network.get(i).getLayer_id());
            gu.add(gu1);
            output.add(gu1);
            result = 0.0;
        }
    }

    public double activate_function(double u, int s) {
        double scale = Math.pow(10, 10);  // 10^10 for 10 decimal places
        u = Math.round(u * scale) / scale;

        if(s == 1){
            if (orisma1.equals("relu")){
                a_func = max(0, u); //relu
            }else if(orisma1.equals("tahn")){
                a_func = (exp(u) - exp(-u)) / (exp(u) + exp(-u));//tahn

            }else if(orisma1.equals("sigmoid")){
                a_func = (double) 1 / (1 + exp(-u));//sigmoid
            }else{
                System.out.println("Wrong name");
                exit(1);
            }
        }else if(s==2){
            if (orisma2.equals("relu")){
                a_func = max(0, u); //relu
            }else if(orisma2.equals("tahn")){
                a_func = (exp(u) - exp(-u)) / (exp(u) + exp(-u)); //tahn
            }else if(orisma2.equals("sigmoid")){
                a_func = (double) 1 / (1 + exp(-u));//sigmoid
            }else{
                System.out.println("Wrong name");
                exit(1);
            }
        }else if(s==3){
            if (orisma3.equals("relu")){
                a_func = max(0, u); //relu
            }else if(orisma3.equals("tahn")){
                a_func = (exp(u) - exp(-u)) / (exp(u) + exp(-u)); //tahn
            }else if(orisma3.equals("sigmoid")){
                a_func = (double) 1 / (1 + exp(-u));//sigmoid
            }else{
                System.out.println("Wrong name");
                exit(1);
            }
        }else{
            a_func = (double) 1 / (1 + exp(-u));//sigmoid;
        }
        return a_func;
    }
}