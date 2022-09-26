package stepdefinitions;

import interactions.OpenWeatherQ;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import taks.MetodoGet;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenWeather {
    @Given("que un usuario quiere consumir el servicio OpenWeather")
    public void que_un_usuario_quiere_consumir_el_servicio_open_weather() {
        System.out.println("Iniciando");
    }

    @When("envia la peticion por el metodo GET con {string} correcto")
    public void envia_la_peticion_por_el_metodo_get_con_correcto(String id) {
        theActorInTheSpotlight().attemptsTo(MetodoGet.withId(Integer.parseInt(id)));
    }

    @Then("el deberia visualizar idciudad que sea igual al enviado")
    public void el_deberia_visualizar_idciudad_que_sea_igual_al_enviado() {

        JsonPath jp = new JsonPath(lastResponse().asString());
        String value = jp.get("id").toString();
        System.out.println(value);
        assertThat(value,equalTo("3674962"));

    }
}
