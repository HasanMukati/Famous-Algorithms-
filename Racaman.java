package Racaman; 
import javax.swing.JOptionPane;
public class Racaman {

	public static String output = ""; 
    public static void recamans(){ 
       final int[] seq = new int[11]; 
       final boolean [] check = new boolean[9 * seq.length]; 
       
       seq[0] = 0; 
       //precompute all values 
       for ( int i = 1; i <= 10; i++){ 
           seq[i] = seq[i - 1] - i; 
           //if result is positive and is not in the sequence 
           if ( (seq[i] > 0)  && !check[seq[i]]){ 
               check[seq[i]] = true; 
           }else { 
               seq[i] = seq[i-1] + i; 
               check[seq[i]] = true; 
           } 
          output += "    " + seq[i]; 
       } 
    }   
   public static void main(String[] args) { 
           recamans(); 
       JOptionPane.showMessageDialog(null, output); 
   } 
   
}

