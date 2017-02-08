package nuris.kalenov.epam.pattern;

import java.util.ArrayList;
import java.util.List;

public class Text extends TextPartComposite {
    public List<TextPartComposite> components = new ArrayList<TextPartComposite>();

    public StringBuilder toText() {
        StringBuilder sb = new StringBuilder();
        for (TextPartComposite component : components) {
            sb.append(component.toText());
        }
        return sb;
    }

    public void addComponent(TextPartComposite component) {
        components.add(component);
    }


}
