package nuris.kalenov.epam.pattern;
/**
 * Реализация шаблона Компоновщик(Composite).
 * */
public abstract class TextPartComposite {
    /**
     * @return весь собраннвый текст.
     * */
    public abstract StringBuilder toText();
}
