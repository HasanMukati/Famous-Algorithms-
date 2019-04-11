package Zeller;
import java.util.Scanner;


public class Zeller  {
   
    // asks for input of year and month 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n Enter year e.g. 2012:");
        int year = input.nextInt();
        System.out.print("\n Enter month 1-12:");
        int month = input.nextInt();
        
        //program needs Jan and Feb to be 13 and 14 
        
        if ( month == 1 ) { month = 13; year --; }
        if ( month == 2 ) { month = 14; year --; }
         
        // asks for day of month to calculate the day of week 
        System.out.print("\n Enter the day of the month 1-31:" );
        int dayofmonth = input.nextInt();
        
        //outputs 
        String day = dayname(zeller(year, month, dayofmonth));
        System.out.println("\n Day of the week is " + day);
        
        
    }
    // calculation 
    private static int zeller(int y, int m, int d){
        int k = y % 100;
        int j = y / 100;
        int h = (d + (( 26 * (m + 1)) / 10) + k + (int)(k / 4)+ (int)(j / 4) + (5 * j)) % 7;
        return h;
        
    }
    // depending on above input program assigns day
    private static String dayname(int day){
        StringBuilder s = new StringBuilder();
        switch (day){
            case 0: s.append("Saturday"); break;
            case 1: s.append("Sunday"); break;
            case 2: s.append("Monday"); break;
            case 3: s.append("Tuesday"); break;
            case 4: s.append("Wenesday"); break;
            case 5: s.append("Thusrday"); break;
            case 6: s.append("Friday"); break;
        }
        
        return s.toString();
    } 
    
}

