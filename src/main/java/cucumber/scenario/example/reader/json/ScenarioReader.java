package cucumber.scenario.example.reader.json;

import io.cucumber.java.Scenario;

public class ScenarioReader {

    public static String getFeatureName(Scenario scenario) {
        String[] path = scenario.getUri().toString().split("/");
        String featureName = path[path.length-1].replace(".feature","");
        return featureName;
    }
}
