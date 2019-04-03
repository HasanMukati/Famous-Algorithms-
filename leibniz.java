package leibniz;
import javax.swing.JOptionPane;

public class leibniz {
	
    public static double ComputeLeib ( long LIMIT ){  
    
    long den = 1; int sign = 1; double sum = 0;
    while (den <= LIMIT){
    	sum = sum + (sign*(1.0/den));
    	den = den + 2;
    	sign  = -sign;
    	
    }
    return 4*sum;
   

}
    public static void main(String[] args) { 
    	String output =""; long LIMIT = 1000; int kntr = 10;
    	while (kntr-- > 0){
    		double leibniz = ComputeLeib(LIMIT);
    		output +="\nThe output valueof pi, using leibniz, up to " +LIMIT + " = "+ leibniz;
    	LIMIT = LIMIT + 1000000;
	    JOptionPane.showMessageDialog(null, output);     
    	}
    	
    	
    }
    
}