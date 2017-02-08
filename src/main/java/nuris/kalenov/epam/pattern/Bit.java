package nuris.kalenov.epam.pattern;

import java.util.HashMap;
import java.util.Map;

public class Bit implements TextPartComposite {
    private Character value;
    private static Map<Character , Bit>  bitMap;
    public Bit(char c) {
        this.value = c;
    }


    public StringBuilder toText(StringBuilder sb) {
        sb = sb.append(value);
        return sb;
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

