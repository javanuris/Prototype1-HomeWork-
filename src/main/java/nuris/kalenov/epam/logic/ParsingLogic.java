package nuris.kalenov.epam.logic;

import nuris.kalenov.epam.pattern.Bit;
import nuris.kalenov.epam.pattern.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Класс, отвечающий за сортировку текста , а именно разбиение его на мелкий части
 * , и востановление структуры текста по принципу рекурсий.
 * */
public class ParsingLogic {
    /**
     * Количество предложеиний.
     * */
    public static int COUNT_SENTENCE = 0;
    /**
     * Количество параграфов.
     * */
    public static int COUNT_PARAGRAPH = 0;
    /**
     * Количество слов.
     * */
    public static int COUNT_WORD = 0;
    /**
     * Количество букв.
     * */
    public static int COUNT_LETTER = 0;
    /**
     * Регулярное выражение определяет параграф.
     * */
    public static final String SPLIT_PARAGRAPH = "(?<=\\n)";
    /**
     * Регулярное выражение определяет предложение.
     * */
    public static final String SPLIT_SENTENCE = "(?<=[.!?]\\s)(?=[A-ZА-Я])";
    /**
     * Регулярное выражение определяет слова.
     * */
    public static final String SPLIT_WORD = "(?<=\\w)";


    /**
     * Разбивает текст на параграфы
     * @param fullString , принимает целый текст.
     * */
    public static Text parseText(String fullString) {
        Text text = new Text();
        String[] paragraphStrings = fullString.split(SPLIT_PARAGRAPH);
        for (String paragraphString : paragraphStrings) {
            COUNT_PARAGRAPH++;
            Text paragraph = parseSentence(paragraphString);
            text.addComponent(paragraph);
        }
        return text;
    }
    /**
     * Разбивает текст на предложение.
     * @param sentenceString , принимает целый текст.
     * */
    public static Text parseSentence(String sentenceString) {
        Text sentenced = new Text();
        String[] sentenceStrings = sentenceString.split(SPLIT_SENTENCE);
        for (String s : sentenceStrings) {
            COUNT_SENTENCE++;
            Text sentence = parseWord(s);
            sentenced.addComponent(sentence);
        }
        return sentenced;
    }
    /**
     * Разбивает текст на слова.
     * @param wordString , принимает целый текст.
     * */
    private static Text parseWord(String wordString) {
        Text word = new Text();
        String[] sentencePartStrings = wordString.split(SPLIT_WORD);
        for (String sentencePartString : sentencePartStrings) {
            COUNT_WORD++;
            Text words = parseLetter(sentencePartString);
            word.addComponent(words);
        }
        return word;
    }
    /**
     * Разбивает текст на буквы.
     * @param letterString , принимает целый текст.
     * */
    public static Text parseLetter(String letterString) {
        Text bit = new Text();
        char[] letter = letterString.toCharArray();
        for (char wordSymbol : letter) {
            COUNT_LETTER++;
            Bit chars = Bit.valueOf(wordSymbol);
            bit.addComponent(chars);
        }
        return bit;
    }


}
