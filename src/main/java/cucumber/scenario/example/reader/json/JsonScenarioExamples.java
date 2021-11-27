package cucumber.scenario.example.reader.json;

import com.google.gson.JsonObject;
import io.cucumber.java.Scenario;

public class JsonScenarioExamples {

    Scenario scenario;
    JsonObject featureData;

    public JsonScenarioExamples(Scenario scenario) {
        this.scenario = scenario;
    }

    public static JsonScenarioExamples forScenario(Scenario scenario) {
        return new JsonScenarioExamples(scenario);
    }

    public JsonScenarioExamples inJsonObject(JsonObject featureData) {
        this.featureData = featureData;
        return this;
    }

    public JsonObject getExamples() {
        String scenarioName = scenario.getName();
        return featureData.getAsJsonObject(scenarioName);
    }
}
