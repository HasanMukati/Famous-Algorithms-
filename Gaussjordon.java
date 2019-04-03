package gaussjordon;
import javax.swing.JOptionPane;

public class Gaussjordon {
	public static double[] Solve( double [][] a, double [] b){ 
	      
	      int n = b.length; 
	      for ( int p = 0; p < n; p++){ 
	    	  //pivot row and swap 
	          int max = p; 
	          for ( int i = p + 1; i < n; i++){ 
	              if (Math.abs(a[i][p])  > Math.abs(a[max][p])){ 
	                  max = i; 
	              } 
	          } 
	        double [] temp = a[p];  a[p] = a[max]; a[max] = temp; 
	        double t = b[p];        b[p] = b[max]; b[max] = t; 
	        
	        //pivot witin a and b 
	        for ( int i = p + 1; i < n; i++){ 
	            double alpha = a[i][p] / a[p][p]; 
	            b[i] = b[i] - alpha * b[p]; 
	           for ( int j = p; j < n; j++){ 
	               a[i][j] = a[i][j] - alpha * a[p][j]; 
	           } 
	        } 
	      } 
	    double [] x = new double[n]; 
	    for ( int i = n - 1; i >= 0; i--){ 
	        double sum = 0; 
	        for ( int j = i + 1; j < n; j++){ 
	            sum += a[i][j] * x[j]; 
	        } 
	        x[i] = (b[i] - sum) / a[i][i]; 
	    } 
	    return x; 
	  } 
	 public static String output = ""; 
	 public static void main(String[] args) { 
	  
	      int n = 3; 
	      double [][] a = { {0, 1, 1}, {2,4, -2}, {0, 3, 15}}; 
	      double [] b = { 4, 2, 36}; 
	      
	      double [] x = Solve ( a, b); 
	      
	      output += "\n The Result = "; 
	      //for ( int index = 0; index < 3; ++index){ 
	          output += "\n X^3  =   " + x[0];   output += "\n  X^2   =   " + x[1]; 
	          output += "\n  X   =   " + x[2]; 
	       //} 
	      JOptionPane.showMessageDialog(null, output); 
	 }    
	}

	

