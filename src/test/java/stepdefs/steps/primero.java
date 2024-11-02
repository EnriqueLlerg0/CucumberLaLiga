package stepdefs.steps;

import cucumber.Context;
import driver.MyWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page.CommonElements.CommonElementPageObject;
import stepdefs.AbstractBaseStep;
import testpages.PrimerPageObject;

public class primero extends AbstractBaseStep
{
    PrimerPageObject primerpageobject;
    public primero(Context context) {
        super(context);
        primerpageobject=context.getManager().getPrimeropageobject();
    }


}
