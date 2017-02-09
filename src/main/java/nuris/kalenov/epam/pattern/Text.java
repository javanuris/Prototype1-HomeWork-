package nuris.kalenov.epam.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Один из ключевых классов шаблона Компоновщик, который хранить в себе компоненты классов себе подобных.(Рекурсия)
 */
public class Text extends TextPartComposite {
    /**
     * Хранит классы себе подобнвх(Рекурсия)
     */
    public List<TextPartComposite> components = new ArrayList<TextPartComposite>();

    /**
     * Возаращает поток данных , кусочки одного текста.
     */
    public StringBuilder toText() {
        StringBuilder sb = new StringBuilder();
        for (TextPartComposite component : components) {
            sb.append(component.toText());
        }
        return sb;
    }

    /**
     * Добовляет обьекты типа TextPartComposite , достижимо при помощий рекурсий.
     */
    public void addComponent(TextPartComposite component) {
        components.add(component);
    }


}
