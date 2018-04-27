
public class BiggestResolution {

	public static void main(String[] args) {
		//int x = 1;
		int y = 1;
		int i = 1;
		while (i <= 1920 && y <= 1080) {
			if (i % 64 == 0) {
				System.out.println(i);
				y = (int)(i*(3.0 / 4.0));
			    if (y % 64 == 0) {
					System.out.println(i + " " + y);
				}
			}
			i++;
		}
	}
}
