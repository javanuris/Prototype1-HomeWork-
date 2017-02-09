package nuris.kalenov.epam.main;

import nuris.kalenov.epam.inout.ReadWrite;
import nuris.kalenov.epam.logic.ParsingLogic;
import nuris.kalenov.epam.pattern.Text;

import java.io.IOException;
/**
 * Главный класс , отвечает за запуск программы.
 * @author Kalenov Nurislam
 * @version 1.0
 * */
public class Main {

    public static void main(String[] args) {
        String filetxt = "";
        try {
            filetxt = ReadWrite.readFile(ReadWrite.PATH_TO_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            execute(filetxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(ParsingLogic.COUNT_PARAGRAPH + "-Параграфов "
                + ParsingLogic.COUNT_SENTENCE + "- Предложений "
                + ParsingLogic.COUNT_WORD + "- Слов "
                + ParsingLogic.COUNT_LETTER + " - Букв + Символ");
    }

    private static void execute(String str) throws IOException {
        Text text = ParsingLogic.parseText(str);
        StringBuilder stringBuilder = text.toText();
        ReadWrite.writeFile(stringBuilder.toString());
        System.out.print(stringBuilder);
    }

}

