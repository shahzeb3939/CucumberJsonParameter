package cucumber.parameters;

import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;

import static cucumber.scenario.example.reader.json.TestData.getExamplesForScenario;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Parameters {

    public static final String SCENARIO_MEMORY_KEY = "Scenario";

    @Before
    public void rememberTheScenario(Scenario scenario) {
        theActorInTheSpotlight().remember(SCENARIO_MEMORY_KEY, scenario);
    }

    @ParameterType(".*")
    public static JsonObject jsonTestData(String exampleReference) {
        Scenario scenario = OnStage.theActorInTheSpotlight().recall(SCENARIO_MEMORY_KEY);
        JsonObject currentExample = new JsonObject();

        try {
            currentExample = getExamplesForScenario(scenario).get(exampleReference).getAsJsonObject();
        } catch (NullPointerException exception) {
            throw new RuntimeException("Unable to find Example reference \""+exampleReference+"\" in Json data file");
        }
        return currentExample;
    }
}
