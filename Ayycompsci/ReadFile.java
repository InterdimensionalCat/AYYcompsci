import java.io.File;
import java.util.Scanner;

public class ReadFile {

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        try {

            Scanner input = null;

            File file = new File("C:\\Users\\bennett\\Downloads\\commonWords.txt");

            input = new Scanner(file);


            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
