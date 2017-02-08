package nuris.kalenov.epam.pattern;

import java.util.HashMap;
import java.util.Map;

public class Bit extends TextPartComposite {
    private Character value;
    StringBuilder stringBuilder;
    private static Map<Character , Bit>  bitMap;

    public Bit(char value) {
        this.value = value;
    }


    public StringBuilder toText() {
        stringBuilder = new StringBuilder();
        return stringBuilder.append(value);
    }



    public static Bit valueOf(char c) {
        if(bitMap == null){
            bitMap = new HashMap<Character, Bit>();
        }
        Bit bit = bitMap.get(c);

        if (bit == null) {
            bit = new Bit(c);
            bitMap.put(c , bit);
        }
        return bit;
    }


   }

