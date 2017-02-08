package nuris.kalenov.epam.main;

import nuris.kalenov.epam.inout.ReadWrite;
import nuris.kalenov.epam.logic.ParsingLogic;
import nuris.kalenov.epam.pattern.Text;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filetxt = "";
        try {
            filetxt = ReadWrite.readFile(ReadWrite.pathToRead);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = "Lorem ipsum dolor sit amet, consectetur" +
                " adipiscing elit. Duis ullamcorper non arcu" +
                " eget tristique. Vivamus tincidunt, lectus quis aliquet congue, odio arcu digni" +
                "ssim massa, id tincidunt mauris felis at tortor. Nulla aliquam interdum purus, a s" +
                "uscipit est fermentum vel. Nunc tempus interdum ex ac scelerisque. Phasellus ferment" +
                "um leo ut arcu dictum luctus. Cras vulputate dui justo, faucibus efficitur nisl fini" +
                "bus aliquam. Phasellus porttitor eros at leo facilisis, vitae feugiat mauris bibendum.\n";


        try {
            execute(filetxt);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(ParsingLogic.COUNT_PARAGRAPH + "-Параграфов "
                + ParsingLogic.COUNT_SENTENCE + "- Предложений "
                + ParsingLogic.COUNT_WORD + "- Слов "
                + ParsingLogic.COUNT_LETTER + " - Букв");
    }

    private static void execute(String str) throws IOException {
        Text text = ParsingLogic.parseText(str);
        StringBuilder stringBuilder = text.toText();
        ReadWrite.writeFile(stringBuilder.toString());
        System.out.print(stringBuilder);
    }

}

