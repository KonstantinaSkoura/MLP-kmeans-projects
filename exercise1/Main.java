

import static java.lang.System.exit;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("You should choose only 3 function names for the hidden layers");
            exit(1);
        }

        String  orisma1 = args[0];//Synarthsh energopoihsh gia epipedo1
        String  orisma2 = args[1];//Synarthsh energopoihsh gia epipedo2
        String  orisma3 = args[2];//Synarthsh energopoihsh gia epipedo3
        int success_counter = 0;// Gia to ypologismo twn sostwn apofaswn
        int N = 4000;
        int B = N/10;
        int d = 2;// Εisodoi
        int H1 = 10;
        int H2 = 6;
        int H3 = 3;
        int K = 4;
        int total_Neurons = H1 + H2 + H3 + K;
        int[] layersize = {H1,H2,H3,K};
        int pointIndex = 0;// Index gia to load tou pinaka points sthn readFile
        int pointIndex2 = 0;// Index gia to load tou pinaka elegxos sthn readFile
        double katofli = 0.0001;
        double flag = 0.0; //flag termatitsmoy katwflioy
        double h = 0.1;//Rythmos Mathisis
        double a_func = -100.0;// activation function
        Point points[] = new Point[4000];// Pinakas me ola ta zevgh x1,x2 apo ta arxeia ekpaideush.txt
        Point elegxos[] = new Point[4000];// Pinakas me ola ta zevgh x1,x2 apo ta arxeia elegxos.txt
        ArrayList<Neuron> network = new ArrayList<>();// To diktyo apo neurwnes
        ArrayList<Double> gu = new ArrayList<>();// Apothikeyei tis ekdodous gia twn synarthsewn energopoihsh olwn twn neyrwnwn
        ArrayList<Double> products = new ArrayList<>();// Apothikevei ola ta u twn nevronwn
        ArrayList<Double> output= new ArrayList<>();// Ta gu poy bgainoyn apo toyw 4 teleutaiou neyrwns toy epipedou eksodou
        ArrayList<Double> deltas = new ArrayList<>();// Ta sfalmata kathe nevrona

        Load load = new Load(elegxos, pointIndex2, points,pointIndex,network, total_Neurons,layersize,H1,H2,H3,K,d);
        load.readFile("ekpaideusi1.txt");
        load.readFile("ekpaideusi2.txt");
        load.readFile("ekpaideusi3.txt");
        load.readFile("ekpaideusi4.txt");


        Load load2 = new Load(elegxos, pointIndex2, points, pointIndex,network, total_Neurons,layersize,H1,H2,H3,K,d);
        load2.readFile("elegxos1.txt");
        load2.readFile("elegxos2.txt");
        load2.readFile("elegxos3.txt");
        load2.readFile("elegxos4.txt");

        for(int i=0;i< total_Neurons;i++){// Arxikopoihsh twn nevronwn
            if(i < H1){
                Neuron n = new Neuron(1,i+1);
                network.add(n);
            }else if((i >= H1) && (i < H1 + H2)){
                Neuron n = new Neuron(2,i+1);
                network.add(n);
            }else if((i >= H1 + H2) && (i < H1 + H2 + H3)){
                Neuron n = new Neuron(3,i+1);
                network.add(n);
            }else{
                Neuron n = new Neuron(4,i+1);
                network.add(n);
            }
        }

        load.initializeRandomWeights();

        for(int i = 0; i < points.length;i++){
            if(points[i].getFlag() == 1){
                network.get(network.size() - 1).getT().set(i,0);
                network.get(network.size() - 2).getT().set(i,0);
                network.get(network.size() - 3).getT().set(i,0);
                network.get(network.size() - 4).getT().set(i,1);
            }else if(points[i].getFlag() == 2){
                network.get(network.size() - 1).getT().set(i,0);
                network.get(network.size() - 2).getT().set(i,0);
                network.get(network.size() - 3).getT().set(i,1);
                network.get(network.size() - 4).getT().set(i,0);
            }else if(points[i].getFlag() == 3){
                network.get(network.size() - 1).getT().set(i,0);
                network.get(network.size() - 2).getT().set(i,1);
                network.get(network.size() - 3).getT().set(i,0);
                network.get(network.size() - 4).getT().set(i,0);
            }else{
                network.get(network.size() - 1).getT().set(i,1);
                network.get(network.size() - 2).getT().set(i,0);
                network.get(network.size() - 3).getT().set(i,0);
                network.get(network.size() - 4).getT().set(i,0);
            }
        }

        for(int i = 0; i < elegxos.length;i++){
            if(elegxos[i].getFlag() == 1){
                network.get(network.size() - 1).getT().set(i,0);
                network.get(network.size() - 2).getT().set(i,0);
                network.get(network.size() - 3).getT().set(i,0);
                network.get(network.size() - 4).getT().set(i,1);
            }else if(elegxos[i].getFlag() == 2){
                network.get(network.size() - 1).getT().set(i,0);
                network.get(network.size() - 2).getT().set(i,0);
                network.get(network.size() - 3).getT().set(i,1);
                network.get(network.size() - 4).getT().set(i,0);
            }else if(elegxos[i].getFlag() == 3){
                network.get(network.size() - 1).getT().set(i,0);
                network.get(network.size() - 2).getT().set(i,1);
                network.get(network.size() - 3).getT().set(i,0);
                network.get(network.size() - 4).getT().set(i,0);
            }else{
                network.get(network.size() - 1).getT().set(i,1);
                network.get(network.size() - 2).getT().set(i,0);
                network.get(network.size() - 3).getT().set(i,0);
                network.get(network.size() - 4).getT().set(i,0);
            }
        }

        int g = 0;
        GradientDescent gradientDescent = new GradientDescent(katofli, a_func, points, network, h, deltas, B, gu, products, layersize, H1, H2, H3, K, orisma1, orisma2, orisma3,output);
        while((g <=700) || (flag == 0)){
            flag = 0;
            double []A = gradientDescent.chooseGradient(flag);
            flag = A[1];
            g ++;
        }

        double max;
        int output_pos = -1;
        int T_pos = -1;
        for(int i = 0;i< elegxos.length;i++){
            output.clear();
            products.clear();
            gu.clear();
            ForwardPassModel felegxou = new ForwardPassModel(network,orisma1,orisma2,orisma3,a_func,H1,H2,H3,K,layersize,gu,products,output);
            felegxou.forwardPass(elegxos[i].getX1(),elegxos[i].getX2());

            max = Math.max(Math.max(output.get(0),output.get(1)),Math.max(output.get(2),output.get(3)));
            for(int j =0;j< output.size();j++){
                if(max == output.get(j)){
                    output_pos = j;
                }
            }
            for(int k =network.size()-4;k<=network.size() -1;k++ ){
                if(network.get(k).getT().get(i) == 1){
                    T_pos =k - (network.size() - 4);
                }
            }
            if(output_pos == T_pos){
                success_counter++;
            }
        }
        System.out.println("This is success counter: "+success_counter);
    }
}