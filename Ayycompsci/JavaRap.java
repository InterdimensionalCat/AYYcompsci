
/**
 * Write a description of class JavaRap here.
 * 
 * @author Mr. Emch
 * 
 */
public class JavaRap
{
    public static void main(String args[])
    {
    	boolean isEnd = false;

                   for (int verse = 0; verse <= 5; verse++) {
    	            rapBeginning();
    	            rapVerse (verse);
    	                if (verse == 5)
    	                {
    		            isEnd = true;
    	                }
                    rapEnding(isEnd);
    	           }
        
    }
public static void rapBeginning()
{
    System.out.println("Hey homies, my code is gonna rock this place");
    System.out.println("With a method named main and a curly brace");
}
      
public static void rapEnding(boolean end)  
{
	 System.out.println("I put a semicolon at the end of each line");
     System.out.println("You playas never seen code that looked so fine");
     if (!end)
     {
     System.out.println();
     }
}
    public static void rapVerse (int x)
   {
	switch (x) {
	case 5:
	System.out.println("All the pretty girls think I'm hot as lava");//replace with boys as desired
    System.out.println("But I kick 'em to the curb unless they program in Java");
	case 4:
	System.out.println("I got full credit for external correctness");
    System.out.println("Dude check this, my code eats yours for breakfast");
	case 3:
	System.out.println("Got help from Mr. Emch and it was swell.");
    System.out.println("But I didn't need it cuz I code so well.");
	case 2:
	System.out.println("The first time I try, my code compiles");
    System.out.println("Lost a point for style cuz my comments are vile");
	case 1:
	System.out.println("BlueJ loves my code, no need to debug");
    System.out.println("I can rap in Java until it unplug.");
    default:
    break;
	}
   }
}       