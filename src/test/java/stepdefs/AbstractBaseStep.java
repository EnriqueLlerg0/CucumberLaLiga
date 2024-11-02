package stepdefs;

import cucumber.Context;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.Scenario;

public abstract class AbstractBaseStep
{
    protected final Context context;
    protected Scenario scenario;
    protected Step step;

    protected AbstractBaseStep(Context context)
    {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }
}
