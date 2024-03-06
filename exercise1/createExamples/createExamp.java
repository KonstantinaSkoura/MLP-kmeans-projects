import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.File;
import java.lang.Math;



public class createExamp {
    public static void main(String[] args) {
		float x1= 0.0F;
        float x2= 0.0F;
        int upperbound1 = 0;
        int lowerbound1 = 0;
        int upperbound2 = 0;
        int lowerbound2 = 0;
        try {
            FileWriter myObj1 = new FileWriter("ekpaideusi1.txt");
            FileWriter myObj2 = new FileWriter("ekpaideusi2.txt");
            FileWriter myObj3 = new FileWriter("ekpaideusi3.txt");
            FileWriter myObj4 = new FileWriter("ekpaideusi4.txt");
			FileWriter myObj5 = new FileWriter("elegxos1.txt");
            FileWriter myObj6 = new FileWriter("elegxos2.txt");
            FileWriter myObj7 = new FileWriter("elegxos3.txt");
            FileWriter myObj8 = new FileWriter("elegxos4.txt");

            Random rand = new Random();
            upperbound1 = 100;
            lowerbound1 = -100;
            upperbound2 = 100;
            lowerbound2 = -100;

            for (int i = 0; i < 4000; i++) {
                x1 = (rand.nextFloat() * (upperbound1 - lowerbound1) + lowerbound1) / 100;
                x2 = (rand.nextFloat() * (upperbound2 - lowerbound2) + lowerbound2) / 100;
				String formattedFloat1 = String.format("%.2f", x1);
				String formattedFloat2 = String.format("%.2f", x2);
				if(formattedFloat1.equals("-0.00")){
					formattedFloat1 = "0.00";
				}
				if(formattedFloat2.equals("-0.00")){
					formattedFloat2 = "0.00";	
				}
                if((Math.pow((x1-0.5),2) + Math.pow((x2-0.5),2) < 0.2) && (x1 > 0.5)){
                    myObj1.write(formattedFloat1);
                    myObj1.write("\t");
                    myObj1.write(formattedFloat2);
                    myObj1.write("\n");
                }else if(( Math.pow((x1-0.5),2) +  Math.pow((x2-0.5),2) < 0.2) && (x1 < 0.5)){
                    myObj2.write(formattedFloat1);
                    myObj2.write("\t");
                    myObj2.write(formattedFloat2);
                    myObj2.write("\n");
                }else if((Math.pow((x1+0.5),2) + Math.pow((x2+0.5),2) < 0.2) && (x1 > -0.5)){
                    myObj1.write(formattedFloat1);
                    myObj1.write("\t");
                    myObj1.write(formattedFloat2);
                    myObj1.write("\n");
                }else if(( Math.pow((x1+0.5),2) +  Math.pow((x2+0.5),2) < 0.2) && (x1 < -0.5)){
                    myObj2.write(formattedFloat1);
                    myObj2.write("\t");
                    myObj2.write(formattedFloat2);
                    myObj2.write("\n");
                }else if(( Math.pow((x1-0.5),2) +  Math.pow((x2+0.5),2) < 0.2) && (x1 > 0.5)){
                    myObj1.write(formattedFloat1);
                    myObj1.write("\t");
                    myObj1.write(formattedFloat2);
                    myObj1.write("\n");
                }else if(( Math.pow((x1-0.5),2) +  Math.pow((x2+0.5),2) < 0.2) && (x1 < 0.5)){
                    myObj2.write(formattedFloat1);
                    myObj2.write("\t");
                    myObj2.write(formattedFloat2);
                    myObj2.write("\n");
                }else if(( Math.pow((x1+0.5),2) +  Math.pow((x2-0.5),2) < 0.2) && (x1 > -0.5)){
                    myObj1.write(formattedFloat1);
                    myObj1.write("\t");
                    myObj1.write(formattedFloat2);
                    myObj1.write("\n");
                }else if(( Math.pow((x1+0.5),2) +  Math.pow((x2-0.5),2) < 0.2) && (x1 < -0.5)){
                    myObj2.write(formattedFloat1);
                    myObj2.write("\t");
                    myObj2.write(formattedFloat2);
                    myObj2.write("\n");
                }else{
					if(x1 > 0){
						myObj3.write(formattedFloat1);
						myObj3.write("\t");
						myObj3.write(formattedFloat2);
						myObj3.write("\n");
						
					}else{
						myObj4.write(formattedFloat1);
						myObj4.write("\t");
						myObj4.write(formattedFloat2);
						myObj4.write("\n");
						
					}
				}
			}
			for (int i = 0; i < 4000; i++) {
				x1 = (rand.nextFloat() * (upperbound1 - lowerbound1) + lowerbound1) / 100;
				x2 = (rand.nextFloat() * (upperbound2 - lowerbound2) + lowerbound2) / 100;
				String formattedFloat1 = String.format("%.2f", x1);
				String formattedFloat2 = String.format("%.2f", x2);
				if(formattedFloat1.equals("-0.00")){
					formattedFloat1 = "0.00";
				}
				if(formattedFloat2.equals("-0.00")){
					formattedFloat2 = "0.00";	
				}
				if((Math.pow((x1-0.5),2) + Math.pow((x2-0.5),2) < 0.2) && (x1 > 0.5)){
					myObj5.write(formattedFloat1);
					myObj5.write("\t");
					myObj5.write(formattedFloat2);
					myObj5.write("\n");
				}else if(( Math.pow((x1-0.5),2) +  Math.pow((x2-0.5),2) < 0.2) && (x1 < 0.5)){
					myObj6.write(formattedFloat1);
					myObj6.write("\t");
					myObj6.write(formattedFloat2);
					myObj6.write("\n");
				}else if((Math.pow((x1+0.5),2) + Math.pow((x2+0.5),2) < 0.2) && (x1 > -0.5)){
					myObj5.write(formattedFloat1);
					myObj5.write("\t");
					myObj5.write(formattedFloat2);
					myObj5.write("\n");
				}else if(( Math.pow((x1+0.5),2) +  Math.pow((x2+0.5),2) < 0.2) && (x1 < -0.5)){
					myObj6.write(formattedFloat1);
					myObj6.write("\t");
					myObj6.write(formattedFloat2);
					myObj6.write("\n");
				}else if(( Math.pow((x1-0.5),2) +  Math.pow((x2+0.5),2) < 0.2) && (x1 > 0.5)){
					myObj5.write(formattedFloat1);
					myObj5.write("\t");
					myObj5.write(formattedFloat2);
					myObj5.write("\n");
				}else if(( Math.pow((x1-0.5),2) +  Math.pow((x2+0.5),2) < 0.2) && (x1 < 0.5)){
					myObj6.write(formattedFloat1);
					myObj6.write("\t");
					myObj6.write(formattedFloat2);
					myObj6.write("\n");
				}else if(( Math.pow((x1+0.5),2) +  Math.pow((x2-0.5),2) < 0.2) && (x1 > -0.5)){
					myObj5.write(formattedFloat1);
					myObj5.write("\t");
					myObj5.write(formattedFloat2);
					myObj5.write("\n");
				}else if(( Math.pow((x1+0.5),2) +  Math.pow((x2-0.5),2) < 0.2) && (x1 < -0.5)){
					myObj6.write(formattedFloat1);
					myObj6.write("\t");
					myObj6.write(formattedFloat2);
					myObj6.write("\n");
				}else{
					if(x1 > 0){
						myObj7.write(formattedFloat1);
						myObj7.write("\t");
						myObj7.write(formattedFloat2);
						myObj7.write("\n");
						
					}else{
						myObj8.write(formattedFloat1);
						myObj8.write("\t");
						myObj8.write(formattedFloat2);
						myObj8.write("\n");
						
					}
				}
			}
            myObj1.close();
            myObj2.close();
			myObj3.close();
			myObj4.close();
			myObj5.close();
            myObj6.close();
			myObj7.close();
			myObj8.close();		

		}catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
