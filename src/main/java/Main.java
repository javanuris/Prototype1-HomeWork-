import java.io.IOException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 06.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        String text1 = null;
        try {
            text1 = Read.readFile(Read.pathToRead);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eget tristique ligula. Vestibulum interdum libero vitae mauris imperdiet, non tincidunt velit consectetur. Fusce finibus blandit justo quis laoreet. Ut nec iaculis libero, sit amet mollis libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nam vitae urna ipsum. Morbi turpis velit, dapibus at efficitur vitae, suscipit a tellus. Fusce fringilla, neque et bibendum rutrum, sem mi facilisis mi, sed mollis urna nibh sed tellus. Nullam vitae neque vel mauris egestas pellentesque." +
                "\n" +
                "Pellentesque sed iaculis ante. Nunc vitae eleifend risus. Nulla commodo purus fringilla sem malesuada, a tincidunt magna eleifend. In augue sem, aliquam interdum sodales aliquam, euismod vel libero. Duis at ultricies est. Suspendisse auctor pellentesque metus, sed sodales felis eleifend id. Proin vehicula nisl vitae sem semper lacinia. Sed hendrerit efficitur dapibus. Donec porta mauris sit amet dolor sollicitudin, posuere luctus urna congue. Donec erat ligula, tempor blandit lorem nec, dignissim eleifend lectus. Aliquam erat volutpat. Nam et sagittis massa.";
        toLetter(toWord(toSentenct(toParagraph(text))));


    }

    public static ArrayList<String> toParagraph(String text) {
        Pattern p = Pattern.compile("(\\n|^).*?(?=\\n|$)");
        Matcher m = p.matcher(text);
        ArrayList<String> tokens = new ArrayList<String>();

        String str = "";
        int i = 0;
        while (m.find()) {
            i++;
            str = m.group();
            tokens.add(str);
        }
        System.out.println("Параграфов " + i);
        return tokens;
    }

    public static ArrayList<String> toSentenct(ArrayList<String> paragraph) {

        ArrayList<String> tokens = new ArrayList<String>();
        // Matcher m;

        Pattern p = Pattern.compile("\\s+[^.!?]*[.!?]");
        int i = 0;
        for (String s : paragraph) {
            Matcher m = p.matcher(s);
            String str = "";

            while (m.find()) {
                i++;
                str = m.group();
                tokens.add(str);

            }

        }
        System.out.println("Предложений " + i);
        return tokens;
    }


    public static ArrayList<String> toWord(ArrayList<String> paragraph) {

        ArrayList<String> tokens = new ArrayList<String>();
        int i = 0;
        Pattern p = Pattern.compile("(\\w+)");
        for (String s : paragraph) {
            Matcher m = p.matcher(s);
            String str = "";
            while (m.find()) {
                i++;
                str = m.group();
                tokens.add(str);
            }
        }
        System.out.println("Слов " + i);
        return tokens;
    }


    public static ArrayList<String> toLetter(ArrayList<String> paragraph) {

        ArrayList<String> tokens = new ArrayList<String>();
        int i = 0;
        Pattern p = Pattern.compile("[a-zA-Z]");

        for (String s : paragraph) {
            Matcher m = p.matcher(s);
            String str = "";
            while (m.find()) {
                i++;
                str = m.group();
                tokens.add(str);

            }
        }
        System.out.println("Букв " + i);
        return tokens;
    }


}
