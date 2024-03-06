
import java.util.ArrayList;
import static java.lang.Math.exp;

public class BackPropagationModel {
    private ArrayList<Double> gu;
    private ArrayList<Double> products;
    private int[] layersize;
    private int H1;
    private int H2;
    private int H3;
    private int K;
    private double h;
    private String  orisma1;
    private String  orisma2;
    private String  orisma3;
    private ArrayList<Neuron> network;
    private ArrayList<Double> deltas;

    public BackPropagationModel(ArrayList<Double> gu, ArrayList<Double> products, int[] layersize, int H1, int H2, int H3, int K, double h, String orisma1, String orisma2, String orisma3,ArrayList<Neuron> network, ArrayList<Double> deltas) {
        this.gu = gu;
        this.products = products;
        this.layersize = layersize;
        this.network = network;
        this.H1 = H1;
        this.H2 = H2;
        this.H3 = H3;
        this.K = K;
        this.h = h;
        this.orisma1 = orisma1;
        this.orisma2 = orisma2;
        this.orisma3 = orisma3;
        this.deltas= deltas;
    }

    public void backPropagation(double x1, double x2, int pointCounter){
        double derivative;
        double delta;
        double result = 0.0;
        int delta_count = 0;

        for(int i = network.size() - 1;i > network.size() - (K + 1);i--){
            derivative = create_Derivative(products.get(i), i + 1);
            delta = derivative*(gu.get(i) - network.get(i).getT().get(pointCounter));
            deltas.add(delta);
        }
        for(int i = 2; i>=0; i--){
            for(int j = layersize[i] - 1;j >=0; j--){
                if(i == 2){
                    derivative = create_Derivative(products.get(j + H1 + H2 ),j + H1 + H2 + 1 );

                }else if(i ==1){
                    derivative = create_Derivative(products.get(j + H1 + H2 - layersize[i]),j + H1 + H2 + 1 - layersize[i]);

                }else{
                    derivative = create_Derivative(products.get(j + H1  - layersize[i]),j + H1 + 1 - layersize[i]);
                }
                for(int k =layersize[i + 1] -1; k >=0; k--){
                    if (i == 2){
                        result += network.get(H1 + H2 + H3 + k).getWeight().get(j)  * deltas.get(delta_count);
                        delta_count ++;

                    }else if(i ==1){
                        result += network.get(H1 + H2 + H3 + k - layersize[i + 1 ]).getWeight().get(j) * deltas.get(delta_count);
                        delta_count ++;
                    }else{
                        result += network.get(H1 + H2  + k - layersize[i + 1 ]).getWeight().get(j) * deltas.get(delta_count);
                        delta_count ++;
                    }
                }
                delta_count =0;
                delta = derivative * result;
                deltas.add(delta);
                result = 0.0;
            }
            delta_count += layersize[i+ 1];
        }
        compute_Derivative_Error_Weights(x1, x2);
    }
    public void compute_Derivative_Error_Weights(double x1, double x2){
        int deltaSize = deltas.size();
        double metablhth;
        for(int i = 0;i < H1;i++){// 1o krymmeno kai eisodoi
            network.get(i).getDerivativeError().add(x1*deltas.get(deltaSize - 1 - i));
            network.get(i).getDerivativeError().add(x2*deltas.get(deltaSize - 1 - i));
        }
        for(int i = H1;i < H2 + H1;i++){// 2o Krummeno
            for(int j = 0;j < H1;j++){//1o Krummeno
                metablhth = gu.get(j)*deltas.get(deltaSize - 1 - i);
                network.get(i).getDerivativeError().add(metablhth);
            }
        }
        for(int i = H2 + H1;i < H3 + H2 + H1;i++){// 3o krymmeno
            for(int j = H1;j < H1 + H2;j++){// 2o krymmeno
                network.get(i).getDerivativeError().add(gu.get(j)*deltas.get(deltaSize - 1 - i));
            }
        }
        for(int i = H3 + H2 + H1;i < K + H3 + H2 + H1;i++){// Epipedo eksodou
            for(int j = H1 + H2;j < H1 + H2 + H3;j++){// 3o krymmeno
                network.get(i).getDerivativeError().add(gu.get(j)*deltas.get(deltaSize - 1 - i));
            }
        }
    }

    public double create_Derivative(double product, int neuron_id){
        double derivative;

        if(neuron_id > H3 + H2 + H1){
            derivative = helpMeDerivative("sigmoid", product);
        }else if(neuron_id > H2 + H1){
            derivative = helpMeDerivative(orisma3, product);
        }else if(neuron_id > H1){
            derivative = helpMeDerivative(orisma2, product);
        }else{
            derivative = helpMeDerivative(orisma1, product);
        }
        return derivative;
    }

    public double helpMeDerivative(String orisma, double product){
        double derivative;

        if (orisma.equals("relu")){
            if(product > 0){
                derivative = 1.0;
            }else{
                derivative = 0.0;
            }
        }else if(orisma.equals("tahn")){
            derivative = 1 - Math.tanh(product) * Math.tanh(product);
        }else{
            double sigmoidX = 1 / (1 + exp(-product)); //ebgala to math
            derivative = sigmoidX * (1 - sigmoidX);
        }
        return derivative;
    }
}