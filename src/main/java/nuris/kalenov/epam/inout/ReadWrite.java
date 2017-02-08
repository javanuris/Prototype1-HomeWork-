package nuris.kalenov.epam.inout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 07.02.2017.
 */
public class ReadWrite {

    public static final String pathToRead = "./src/main/resources/test.txt";

   public  static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    public static void writeFile(String file) {

        try {
            PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
            writer.print(file);
            writer.close();
        } catch (IOException e) {

        }

    }


}