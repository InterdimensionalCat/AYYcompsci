import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		for(int j = 0; j < i; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.print("\n" +  a + " " +summation(b) + " " + summationEven(b) + " " + summationOdd(b));
		}
	}
	
	public static int summation(int n) {
		for(int i = n-1; i > 0; i--) n+=i;
		return n;
	}
	
	public static int summationEven(int n) {
		int j = 0;
		int i = 0;
		while(j <= n) {
			if(i % 2 == 0) {
				j+=i;
			}
			i++;
		}
		return j;
	}
	
	public static int summationOdd(int n) {
		int j = 0;
		int i = 0;
		while(j <= n) {
			if(i % 2 != 0) {
				j+=i;
			}
			i++;
		}
		return j;
	}
	
}
