package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class OpenWeatherQ implements Question<String> {

    public static OpenWeatherQ expected() {
        return new OpenWeatherQ();
    }

    public String answeredBy(Actor actor){
        String idRepuesta = lastResponse().jsonPath().get("id").toString();
        return idRepuesta;
    }

}


