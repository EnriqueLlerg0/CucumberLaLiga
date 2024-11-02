package stepdefs.steps;

import cucumber.Context;
import driver.MyWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page.AbstrapPageObject.AbstrapPageObject;
import stepdefs.AbstractBaseStep;
import testpages.QuintoPageObject;

public class quinto extends AbstractBaseStep
{
    QuintoPageObject quintopageobject;
    public quinto(Context context)
    {
        super(context);
        quintopageobject=context.getManager().getQuintopageobject();
    }

    @Then("usuario hace click en Estadisticas")
    public void usuarioHaceClickEnEstadisticas()
    {
        quintopageobject.hacerClickEnEstadisticas();
    }

    @And("usuario selecciona aleatoriamente una liga")
    public void usuarioSeleccionaAleatoriamenteUnaLiga()
    {
        quintopageobject.seleccionamosUnaLiga();
    }

    @And("clica en Tarjetas rojas")
    public void clicaEnTarjetasRojas()
    {
        quintopageobject.hacerClickEnTarjetasRojas();
    }

    @Then("usuario selecciona aleatoriamente un equipo")
    public void usuarioSeleccionaAleatoriamenteUnEquipo()
    {
        quintopageobject.seleccionamosUnEquipo();
    }

    @And("recogemos los datos")
    public void recogemosLosDatos()
    {
        quintopageobject.recogemoLosDatos();
    }

    @And("escribimos en el archivo json los datos obtenidos sobre las tarjetas rojas {string}")
    public void escribimosEnElArchivoJsonLosDatosObtenidosSobreLasTarjetasRojas(String nombre)
    {
        quintopageobject.rellenarJson(nombre);
    }
}
