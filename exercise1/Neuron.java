

import java.util.ArrayList;

public class Neuron{
    private double bias;// To bias kathe nevrona
    private ArrayList<Double> weight = new ArrayList<>();// Krataei ola ta varh tou nevrona
    private ArrayList<Double> derivativeError = new ArrayList<>();// Krataei tis paragogous sfalmatos gia ola ta varh tou nevrona
    private int layer_id;
    private int id;
    private ArrayList<Integer> T = new ArrayList<>();//
    Neuron(int layer_id,int id){
        this.layer_id = layer_id;
        this.id = id;

        for(int i = 0;i < 4000;i++){
            T.add(-5);
        }
    }

    public ArrayList<Integer> getT() {
        return T;
    }
    public void setT(int t) {
        this.T = T;
    }
    public ArrayList<Double> getWeight() {
        return weight;
    }
    public void setWeight(ArrayList<Double> weight) {
        this.weight = weight;
    }
    public int getLayer_id() {
        return layer_id;
    }
    public void setLayer_id(int layer_id) {
        this.layer_id = layer_id;
    }
    public double getBias() {return bias;}
    public void setBias(double bias) {this.bias = bias;}
    public ArrayList<Double> getDerivativeError() {return derivativeError;}
    public void setDerivativeError(ArrayList<Double> derivativeError) {this.derivativeError = derivativeError;}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}