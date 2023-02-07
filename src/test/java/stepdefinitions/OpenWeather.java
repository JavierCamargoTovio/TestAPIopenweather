package stepdefinitions;

import interactions.OpenWeatherQ;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import taks.MetodoGet;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class OpenWeather {

    @Given("que un usuario quiere consumir el servicio OpenWeather")
    public void que_un_usuario_quiere_consumir_el_servicio_open_weather() {
        theActorCalled("Usuario").whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
    }

    @When("envia la peticion por el metodo GET con {string}  correcto")
    public void envia_la_peticion_por_el_metodo_get_con_correcto(String id) {
        theActorInTheSpotlight().attemptsTo(MetodoGet.withId(id));
    }

    @Then("el deberia visualizar {string} que sea igual al enviado")
    public void el_deberia_visualizar_que_sea_igual_al_enviado(String id) {
        theActorInTheSpotlight().should(seeThat("Se verifica que el idCiudad", OpenWeatherQ.expected(), equalTo(id)));
    }
}
