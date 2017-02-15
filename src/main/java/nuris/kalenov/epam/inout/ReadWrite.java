package nuris.kalenov.epam.inout;

import java.io.*;

/**
 * Загружает записывает и выгружает файл формата txt.
 */
public class ReadWrite {


    /**
     * Путь до рассположение файла, с которого будут считанны данные.
     */
    public static final String PATH_TO_READ = "./src/main/resources/test.txt";
    /**
     * Наименоание файла который будет создан
     */
    public static final String FILE_NAME = "the-file-name.txt";
    /**
     * Кодировка текста который будет записан.
     */
    public static final String CODING = "UTF-8";

    /**
     * Загружает файл , и считывает его.  */
    public static String readFile(String file) throws IOException {
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

   public static String readTextFile(){
        String myText = "";
        char lf =  0x0A;
        String endLine = ""+lf;
        try (FileInputStream myFile = new FileInputStream("./src/main/resources/test.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(myFile, "UTF-8");
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String nextLine;
            boolean eof = false;
            while (!eof) {
                nextLine = reader.readLine();
                if (nextLine == null){
                    eof = true;
                } else {

                    myText += nextLine+endLine;

                }
            }

        }catch (IOException e){
            System.out.println("Can't read Stalking.txt");
        }
return myText;
    }

    /**
     * Записывает файл.
     * @param file текствое поле , котрый дает имя файлу.
     * */
    public static void writeFile(String file) {
        try {
            PrintWriter writer = new PrintWriter(FILE_NAME, CODING);
            writer.print(file);
            writer.close();
        } catch (IOException e) {

        }
    }






}