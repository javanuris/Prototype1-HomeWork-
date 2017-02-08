package nuris.kalenov.epam.logic;

import nuris.kalenov.epam.pattern.Bit;
import nuris.kalenov.epam.pattern.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingLogic {
    public static int COUNT_SENTENCE = 0;
    public static int COUNT_PARAGRAPH = 0;
    public static int COUNT_WORD = 0;
    public static int COUNT_LETTER = 0;

    public static Text parseText(String sourceString) {
        Text text = new Text();
        Pattern p = Pattern.compile("(\\n|^).*?(?=\\n|$)");
        Matcher m = p.matcher(sourceString);
        while (m.find()) {
            COUNT_PARAGRAPH++;
            Text paragraph = parseSentence(m.group());
            text.addComponent(paragraph);
        }
        return text;
    }

    public static Text parseSentence(String sentenceString) {
        Text sentenced = new Text();
        Pattern p = Pattern.compile("\\s+[^.!?]*[.!?]");
        Matcher m = p.matcher(sentenceString);
        while (m.find()) {
            COUNT_SENTENCE++;
            Text sentence = parseWord((m.group()));
            sentenced.addComponent(sentence);
        }
        return sentenced;
    }

    private static Text parseWord(String sentenceString) {
        Text word = new Text();
        Pattern p = Pattern.compile("(\\w+)");
        Matcher m = p.matcher(sentenceString);
        while (m.find()) {
            COUNT_WORD++;
            Text words = parseLetter((m.group()));
            word.addComponent(words);
        }
        return word;
    }

    public static Text parseLetter(String letters) {
        Text bit = new Text();
        char[] letter = letters.toCharArray();
        for (char wordSymbol : letter) {
            COUNT_LETTER++;
            Bit chars = Bit.valueOf(wordSymbol);
            bit.addComponent(chars);
        }
        return bit;
    }


}
