import java.util.Scanner;
import java.util.StringTokenizer;

public class Sample {
	
	public static void main(String [] args) {
		
		/* //String original, reverse = "";
	      //Scanner in = new Scanner(System.in);
	 
		 String s = "hari";
		 String s1= "";
	     // System.out.println("Enter a string to reverse");
	     // original = in.nextLine();
	 
	      int length = s.length();
	 
	      //for ( int i = length - 1 ; i >= 0 ; i-- )
	        // reverse = reverse + original.charAt(i);
	      for ( int i=length-1 ; i >=0 ; i--)
	    	  s1 = s1 + s.charAt(i);
	 
	      System.out.println("Reverse of entered string is: "+s1);*/
		
		StringTokenizer st = new StringTokenizer("m,y name is khan");  
        
	      // printing next token  
	      System.out.println("Next token is : " + st.nextToken(",")); 
	}

}
