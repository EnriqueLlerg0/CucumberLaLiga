package stepdefs.Hook;

import cucumber.Context;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import stepdefs.AbstractBaseStep;

public class hook extends AbstractBaseStep
{
    public hook(Context context) {
        super(context);
    }
    @Before
    public void lanzar(Scenario escenario)
    {
        setScenario(escenario);
    }

    @After
    public void cerrar()
    {
        //context.getDriver().getDriver().quit();
        System.out.println("termino");
    }
}
