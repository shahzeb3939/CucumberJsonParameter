package cucumber.scenario.example.reader.json;

import com.google.gson.JsonObject;
import io.cucumber.java.Scenario;
import json.JsonFile;

public class TestData {

    public static final String TEST_DATA_FOLDER_PATH = "src/test/resources/test_data/";
    public static JsonObject getExamplesForScenario(Scenario scenario) {
        String featureName = ScenarioReader.getFeatureName(scenario);
        JsonObject jsonData = JsonFile.fromPath(TEST_DATA_FOLDER_PATH+featureName+".json").retrieve().getAsJsonObject();
        JsonObject scenarioExamples = JsonScenarioExamples.forScenario(scenario).inJsonObject(jsonData).getExamples();

        return scenarioExamples;
    }
}
