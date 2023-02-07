package stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class Hook {

    private static String environmentBase;
    private static EnvironmentVariables environmentVariables;


    @Before
    public void initialConfiguration() {
        setTheStage(new OnlineCast());
        environmentBase = environmentVariables.optionalProperty("restapi.baseurl").orElse("restapi.baseurl");

    }

    public static String getEnvironmentBase(){
        return environmentBase;
    }

    
}
