import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class WriteFile
{
    public static void main(String[] args) {
        String outFileName = "myData.txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(outFileName);
            for (int i = 1; i <= 9; i++) {
                writer.printf("%d, ", i * i);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Unable to write to " + outFileName);
        } finally {
            /*  if printWriter is not closed, data will not 
                write into "mydata.txt"
            */
            if (writer != null) writer.close();
        }

    }
}

