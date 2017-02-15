package nuris.kalenov.epam.pattern;

import java.util.HashMap;
import java.util.Map;
/**
 * Корень шаблона Компоновщик. Класс хранить данные Char.
 * */
public class Bit extends TextPartComposite {

    private Character value;
    StringBuilder stringBuilder;

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





}

