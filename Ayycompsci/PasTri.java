import java.util.ArrayList;

public class PasTri {

	public static void main(String[] args) {
		int n = 7;
		ArrayList<Long> row = new ArrayList<Long>();
		row.add(1L);
		row.add(1L);
		System.out.println("1 ");
		System.out.print("1 ");
		System.out.println("1 ");
		for (int i = 3; i <= n; i++) {
			System.out.print("1 ");
			row.add(1L);
			for (int j = 2; j <= i-1; j++) {
				long x = row.get(0) + row.get(1);
				System.out.print(x+ " ");
				row.add(x);
				row.remove(0);
			}
			System.out.println("1");
			row.add(1L);
			row.remove(0);
		}
	}
	
}
