package nuris.kalenov.epam.inout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
     * Загружает файл , и считывает его.
     * @param file текствое поле , котрый указывает пут загрузкий файла.
     * */
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