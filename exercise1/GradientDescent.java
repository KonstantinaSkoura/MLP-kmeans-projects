
import java.util.ArrayList;

public class GradientDescent {
    private int B;
    private ArrayList<Neuron> network;
    private double h;
    private ArrayList<Double> deltas;// Ta sfalmata kathe nevrona
    private Point points[];

    private String  orisma1;
    private String  orisma2;
    private String  orisma3;
    private double a_func;
    private int H1;
    private int H2;
    private int H3;
    private int K;
    private int[] layersize;
    private double katofli;
    double previous_learning_error = -1.0;
    ArrayList<Double> gu;// apothikeyei tis ekdodous twn synarthsewn energopoihsh olwn twn neyrwnwn
    ArrayList<Double> products;// apothikevei ola ta u twn nevronwn
    ArrayList<Double> output;//ta gu poy bgainoyn apo toyw 4 teleutaiou neyrwns toy epipedou eksodou

    public GradientDescent(double katofli, double a_func, Point points[], ArrayList<Neuron> network, double h,ArrayList<Double> deltas, int B,  ArrayList<Double> gu, ArrayList<Double> products, int[] layersize, int H1, int H2, int H3, int K, String orisma1, String orisma2, String orisma3,ArrayList<Double> output) {
        this.gu = gu;
        this.products = products;
        this.layersize = layersize;
        this.network = network;
        this.H1 = H1;
        this.H2 = H2;
        this.H3 = H3;
        this.K = K;
        this.h = h;
        this.B = B;
        this.orisma1 = orisma1;
        this.orisma2 = orisma2;
        this.orisma3 = orisma3;
        this.deltas= deltas;
        this.points = points;
        this.a_func = a_func;
        this.katofli = katofli;
        this.output = output;
    }

    public double[] chooseGradient(double flag){
        double total_learning_error = 0.0;
        int counter = 0;
        int pointCounter = 0;
        int counterPatches = 0;
        ForwardPassModel fModel = new ForwardPassModel(network, orisma1, orisma2, orisma3, a_func, H1, H2, H3, K, layersize, gu, products,output);
        BackPropagationModel bModel = new BackPropagationModel(gu, products, layersize, H1, H2, H3, K, h, orisma1, orisma2, orisma3, network,deltas);

        if(B == 1){
            for(Point element:points){
                fModel.forwardPass(element.getX1(), element.getX2());
                bModel.backPropagation(element.getX1(), element.getX2(), pointCounter);

                updateWeights();
                updateBias();

                for(int i = network.size() - 1;i > network.size() - 5;i--){//Phgainei stous 4 teleutaois nevrones gia kathe point kai prosthetei to error tou kathenos sthn total_learning_error
                    total_learning_error += Math.pow(network.get(i).getT().get(pointCounter) - gu.get(i), 2);
                }

                products.clear();
                gu.clear();
                output.clear();
                deltas.clear();
                for(Neuron element1:network){
                    element1.getDerivativeError().clear();
                }
            }
            if(Math.abs(previous_learning_error - total_learning_error/2) < katofli){
                flag = 1;
            }
            previous_learning_error = total_learning_error/2;
            System.out.println("Error epoxhs: "+previous_learning_error);
            double []A = {previous_learning_error, flag};
            return(A);
        }else{
            for(Point element:points){
                double newDerivativeError;
                products.clear();
                gu.clear();
                output.clear();
                deltas.clear();
                fModel.forwardPass(element.getX1(), element.getX2());
                bModel.backPropagation(element.getX1(), element.getX2(), pointCounter);
                if(counter != 0){
                    for(int i = 0;i < network.size();i++){
                        for(int j = 0;j < network.get(i).getDerivativeError().size()/2;j++){
                            newDerivativeError = network.get(i).getDerivativeError().get(j) + network.get(i).getDerivativeError().get(j + network.get(i).getDerivativeError().size()/2);
                            network.get(i).getDerivativeError().set(j, newDerivativeError);
                        }
                        int halfsize = network.get(i).getDerivativeError().size()/2;
                        network.get(i).getDerivativeError().subList(halfsize,network.get(i).getDerivativeError().size()).clear();//diagrafw to deutero miso
                    }
                }
                for(int i = network.size() - 1;i > network.size() - 5;i--){//Phgainei stouw 4 teleutaois nevrones gia kathe point kai prosthetei to error tou kathenos sthn total_learning_error
                    total_learning_error += Math.pow(network.get(i).getT().get(pointCounter) - gu.get(i), 2);
                }
                if(counterPatches == B){//Elegxo an prepei na ginoun updates epeidh eginan B epanalipseis
                    updateWeights();
                    updateBias();
                    for(int i =0;i<network.size();i++){
                        network.get(i).getDerivativeError().clear();
                    }
                }
                counter = 1;
                pointCounter++;
                counterPatches++;
            }
            if(Math.abs(previous_learning_error - total_learning_error/2) < katofli){
                flag = 1;
            }
            previous_learning_error = total_learning_error/2;
            System.out.println("Error epoxhs: "+previous_learning_error);

            double [] A = {previous_learning_error, flag};
            return(A);
        }
    }
    public void updateWeights(){
        for(int i = 0;i < network.size() - 1;i++){
            for(int j = 0;j < network.get(i).getWeight().size();j++){
                double tempWeight = network.get(i).getWeight().get(j) - h*network.get(i).getDerivativeError().get(j);
                network.get(i).getWeight().set(j, tempWeight);// Prostheto to kainourio varos ston arraylist weights
            }
        }
    }

    public void updateBias(){
        int counter = 0;
        double temp;
        int currentBias;

        for(int i = deltas.size() - 1;i >= 0;i--){
            if(B == 1){
                currentBias = i - (deltas.size() - 1) + counter;
                network.get(currentBias).setBias(deltas.get(i));
                counter++;
            }else{
                currentBias = i - (deltas.size() - 1) + counter;
                temp = deltas.get(i);
                network.get(currentBias).setBias(temp + network.get(currentBias).getBias());
                counter++;
            }
        }
    }
}