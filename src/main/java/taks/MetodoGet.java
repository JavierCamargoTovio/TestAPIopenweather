package taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import utilities.Constant;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MetodoGet implements Task {
    private final String id;

    public MetodoGet(String id) {
        this.id = id;
    }
    public static MetodoGet withId(String id) {
        return instrumented(MetodoGet.class, id);
    }

    @Override
    @Step("{0} fetches the user with id #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("id={id}")
                        .with(request -> request.pathParam("id", id)
                                .queryParam("appid",Constant.API_KEY))
        );
        lastResponse().peek();
    }
}
