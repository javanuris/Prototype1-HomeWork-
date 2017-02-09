package nuris.kalenov.epam.pattern;

import java.util.HashMap;
import java.util.Map;
/**
 * Корень шаблона Компоновщик. Класс хранить данные Char.
 * */
public class Bit extends TextPartComposite {

    private Character value;
    StringBuilder stringBuilder;
    private static Map<Character, Bit> bitMap;

    public Bit(char value) {
        this.value = value;
    }

    /**
     * Возвращает стринговые данные.
     * */
    public StringBuilder toText() {
        stringBuilder = new StringBuilder();
        return stringBuilder.append(value);
    }
    /**
     * Хранить значениие типа char в ХешМапе.
     * @param charList принимает поток данных типа char.
     * @return данные типа char.
     * */
    public static Bit valueOf(char charList) {
        if (bitMap == null) {
            bitMap = new HashMap<Character, Bit>();
        }
        Bit bit = bitMap.get(charList);

        if (bit == null) {
            bit = new Bit(charList);
            bitMap.put(charList, bit);
        }
        return bit;
    }
}

