import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.Math;




public class RamanujanChudnovsky {

			public static BigDecimal fact( int n ) {
				BigDecimal result = BigDecimal.ONE;
				while (n > 0) {
				    result = result.multiply(new BigDecimal(n + "")); 
					n--;
				}
				return result;
			}
			
			public static BigDecimal pow( BigDecimal a, int b ) {
				BigDecimal result = a;
				if(b == 0) {
					return BigDecimal.ONE;
				}
				while ( b > 1 ) {
					result = result.multiply(new BigDecimal(a + ""));
					b--;
				}
				return result;
			}
			
			
			public static BigDecimal Chudnovsky( int n ) {
				
				BigDecimal coefficient = BigDecimal.valueOf(53360.0).multiply(BigDecimal.valueOf(Math.sqrt(640320.0)));	//multiplication again
				coefficient = BigDecimal.ONE.divide(coefficient, 100, RoundingMode.HALF_UP);
				
				BigDecimal pi_C = BigDecimal.ONE;
				BigDecimal sum = BigDecimal.ZERO;		//same as above slightly modified.
				BigDecimal quotient;
				BigDecimal numer;
				BigDecimal denom;
				for(int i = 0; i <= n; i++ ) {
					
					BigDecimal bigI = BigDecimal.valueOf(i); // slightly different calculations
					// Calculations below: //545140134n // + 13591409 // * (-1)^n // * (6n)! // (n!)^3 // * (3n!) // * (340320 ^ (3n))
					
					numer = BigDecimal.valueOf(545140134.0).multiply(bigI);				
					numer = numer.add(BigDecimal.valueOf(13591409.0));					
					numer = numer.multiply(pow( BigDecimal.valueOf(-1.0), i ));			
					numer = numer.multiply(fact( 6 * i ));								
					
					denom = pow( fact(i), 3 );												
					denom = denom.multiply( fact( 3 * i ));									
					denom = denom.multiply( pow( BigDecimal.valueOf(340320.0), (3*i) ));	
					
					quotient = numer.divide(denom, 100, RoundingMode.HALF_UP);
					sum = sum.add(quotient);
					System.out.print(i + "\n");
				}
				
				pi_C = pi_C.divide(coefficient.multiply(sum), 100, RoundingMode.HALF_UP);
			
				
				return pi_C;
			}
			
			public static BigDecimal Ramanujan( int n ) {
				
				BigDecimal coefficient = BigDecimal.valueOf(Math.sqrt(8.0)).divide(BigDecimal.valueOf(9801.0), 100, RoundingMode.HALF_UP);	// multipication 
				BigDecimal pi_R = BigDecimal.ONE;
				BigDecimal sum = BigDecimal.ZERO;
				BigDecimal quotient;
				BigDecimal numerator;			//Calculating the numerator
				BigDecimal denomenator;			//Calculating the Denominator 
				for(int i = 0; i <= n; i++ ) {
					BigDecimal bigI = BigDecimal.valueOf(i);  //arithmetic with ints and arithmetic with BigDecimals
					//calculations below: (26390n) // + 1103 // * (4n)! // (n!)^4 // * (396 ^ (4n))
					
					numerator = (BigDecimal.valueOf(26390.0).multiply(bigI));	
					numerator = numerator.add(BigDecimal.valueOf(1103.0));			
					numerator = numerator.multiply(fact( 4 * i ));					
					
					denomenator = pow( fact(i), 4 );											
					denomenator = denomenator.multiply(pow(BigDecimal.valueOf(396.0), (4 * i)) );	
					
					quotient = numerator.divide(denomenator, 100, RoundingMode.HALF_UP);
					sum = sum.add(quotient);
					System.out.print(i + "\n");
				}
				
				pi_R = pi_R.divide(coefficient.multiply(sum), 100, RoundingMode.HALF_UP);  // Ramanujan =  1/pi

				return pi_R;
			}
			
			
			public static void main(String[] args) {
				BigDecimal chudPi = Chudnovsky(100);
				BigDecimal ramanPi = Ramanujan(100);
				
				// Print statements 
				System.out.print("Ramanujan's algorithm for pi, for n = 100:\n" + ramanPi + "\n");
				System.out.print("Chudnovsky brothers' algorithm for pi, for n = 100:\n" + chudPi);
			}

		}


