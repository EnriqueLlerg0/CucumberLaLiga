package stepdefs.steps;

import cucumber.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import stepdefs.AbstractBaseStep;
import testpages.SegundoPageObject;

public class segundo extends AbstractBaseStep
{
    SegundoPageObject segundopageobject;
    public segundo(Context context) {
        super(context);
        segundopageobject=context.getManager().getSegundopageobject();
    }


}
