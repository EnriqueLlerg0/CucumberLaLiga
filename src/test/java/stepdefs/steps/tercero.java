package stepdefs.steps;

import cucumber.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import stepdefs.AbstractBaseStep;
import testpages.TerceroPageObject;

public class tercero extends AbstractBaseStep
{
    TerceroPageObject terceropageobject;
    public tercero(Context context)
    {
        super(context);
        terceropageobject=context.getManager().getTercerpageobject();
    }
}
