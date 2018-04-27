
public class Main {

	public static void main(String[] args) {
		long l = System.nanoTime();
		int n = recursiveSum(2);
		long l1 = System.nanoTime();
		System.out.println(n + " Calculated recursively in " + (l1 - l) + " nanoseconds");
		l = System.nanoTime();
		n = iterativeSum(2);
		l1 = System.nanoTime();
		System.out.println(n + " Calculated iteratively in " + (l1 - l) + " nanoseconds");
	}
	
	public static int recursiveSum(int n) {
		if(n > 1) n+= recursiveSum(n-1);
		return n;
	}
	
	public static int iterativeSum(int n) {
		for(int i = n-1; i > 0; i--) n+=i;
		return n;
	}
}
