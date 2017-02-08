package nuris.kalenov.epam.main;

import nuris.kalenov.epam.logic.ParsingLogic;
import nuris.kalenov.epam.pattern.Text;

public class Main {

    public static void main(String[] args) {

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ullamcorper non arcu eget tristique. Vivamus tincidunt, lectus quis aliquet congue, odio arcu dignissim massa, id tincidunt mauris felis at tortor. Nulla aliquam interdum purus, a suscipit est fermentum vel. Nunc tempus interdum ex ac scelerisque. Phasellus fermentum leo ut arcu dictum luctus. Cras vulputate dui justo, faucibus efficitur nisl finibus aliquam. Phasellus porttitor eros at leo facilisis, vitae feugiat mauris bibendum.\n" +

                "Sed egestas elit nec consequat condimentum. Cras eros lectus, lacinia et suscipit sit amet, aliquam sit amet ipsum. Morbi lectus nibh, ultricies nec lectus eget, sagittis porta nunc. Pellentesque pharetra sapien quis tellus lobortis feugiat. Etiam et ligula accumsan, hendrerit tortor sit amet, lacinia ipsum. Proin urna odio, commodo sed posuere sit amet, venenatis eget lorem. Curabitur gravida quis arcu et commodo. Cras non porta sem. Cras sollicitudin interdum orci ac porta. Sed et ultricies elit, vel iaculis massa. Curabitur interdum lorem magna, in varius justo malesuada et. Integer bibendum bibendum enim, vitae pulvinar ante vulputate vitae. Cras imperdiet libero id lorem euismod maximus. Proin pretium quam sit amet massa ultrices, ut fermentum metus consequat. Quisque commodo pretium erat et tincidunt. Quisque placerat lobortis orci nec tristique.\n" +

                "Donec rutrum justo ac purus eleifend sollicitudin. Aenean porttitor aliquet fermentum. Proin tincidunt neque vel vulputate varius. Vestibulum cursus quam ullamcorper diam ultricies commodo. Fusce et orci sit amet nunc tincidunt elementum. Morbi sapien dolor, imperdiet ut nulla vel, mattis mattis nulla. Mauris eget lorem sed urna mollis tempus. Sed venenatis elementum blandit. Integer aliquam nibh mollis luctus semper. Maecenas vulputate feugiat lacinia. Nunc nec bibendum erat, sit amet commodo arcu. Sed eget orci porta, egestas elit nec, dapibus augue. Nam vitae tellus aliquet, porttitor lorem ut, sollicitudin velit. Sed vestibulum id lacus vitae finibus.";

        execute(text);

        System.out.println();
        System.out.println(ParsingLogic.COUNT_PARAGRAPH + "-Параграфов "
                + ParsingLogic.COUNT_SENTENCE + "- Предложений "
                + ParsingLogic.COUNT_WORD + "- Слов "
                + ParsingLogic.COUNT_LETTER + " - Букв");
    }

    private static void execute(String str) {
        Text text = ParsingLogic.parseText(str);
        StringBuilder stringBuilder = text.getBuilder();
        System.out.println(str);

    }

}

