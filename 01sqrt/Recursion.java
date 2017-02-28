public class Recursion {
	public static String name() {
		return "Lin,Stanley";
	}
	
	public static boolean doubEq(double exp, double actual) {
		//true if less than .9%
		return Math.abs((exp-actual)/actual) < .000000000009;
	}
	
	private static double approximate(	double n,
						double guess) {
		if (n == 0) return 0;
		if (doubEq(n, guess*guess)) {
			return guess;
		}
		else {
			return approximate(n,
				((n / guess) + guess) / 2);
		}
	}
	
	public static double sqrt(double n) {
		if (n < 0)
			throw new IllegalArgumentException(
				"number less than 0: " + n);
		return approximate(n, 1);
	} 
	
	
	 public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//very generous %error accepted
  }
	public static void main(String args[]) {
		//System.out.println(doubEq(1, 2));
		//System.out.println(doubEq(1.0, 1.00000000000000001));
		//System.out.println(doubEq(100.005, 100));
		/*System.out.println(sqrt(100));
		System.out.println(sqrt(2));
		System.out.println(sqrt(49));
		System.out.println(sqrt(250000));
		System.out.println(sqrt(-1));*/
		
		double[] input = {1.0,2.0,4.0,7.0,10.0,100.0,1024.0,-1.0,0.0};
    int score = 0;
    for(double in : input){
      try{
        if(closeEnough(Recursion.sqrt(in),Math.sqrt(in))){
          score++;
          //System.out.println("PASS test "+in+" "+Recursion.sqrt(in));
        }
        else{
          System.out.println("Fail test "+in+" "+Recursion.sqrt(in)+" vs "+Math.sqrt(in));
        }
      }catch(IllegalArgumentException n){
        if(in == -1){
          score++;
        }
      }catch(Exception e){
        System.out.println("Some exception in test case:"+in);
      }
    }
    System.out.println(score+";out of: "+input.length+";"+Recursion.name());
  
	}
}
