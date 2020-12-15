import java.util.Scanner;
import java.util.FormatFlagsConversionMismatchException;
public class FileReader
{
    public static void main(String[] args) {
        File file = new File("data.txt");
        Scanner input = null;
        try {
            input = new Scanner( file);
            while (input.hasNextLine()) {
                System.out.println( input.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) input.close();
        }
    }
}