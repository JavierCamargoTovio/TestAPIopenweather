package interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

import static org.hamcrest.MatcherAssert.assertThat;

public class OpenWeatherQ {


    public static Question<String> theExpectedUser() {
        return actor -> SerenityRest.lastResponse()
                .jsonPath()
                .getString("id");
    }

}


