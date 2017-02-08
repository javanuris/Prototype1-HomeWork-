package nuris.kalenov.epam.pattern;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextPartComposite {
    public List<TextPartComposite> components = new ArrayList<TextPartComposite>();
    StringBuilder builder = new StringBuilder();


    public StringBuilder toText(StringBuilder sb) {
        for (TextPartComposite component : components) {
            builder = new StringBuilder();
            component.toText(builder);
        }
        return builder;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public void addComponent(TextPartComposite component) {
        components.add(component);
    }


}
