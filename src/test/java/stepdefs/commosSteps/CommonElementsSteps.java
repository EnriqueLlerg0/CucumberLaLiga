package stepdefs.commosSteps;

import cucumber.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CommonElements.CommonElementPageObject;
import stepdefs.AbstractBaseStep;

public class CommonElementsSteps extends AbstractBaseStep
{
    private CommonElementPageObject commonelementpageobject;
    public CommonElementsSteps(Context context)
    {
        super(context);
        commonelementpageobject=context.getManager().getCommonElementPageObject();
    }

    @Given("usuario abre la pagina")
    public void usuarioAbreLaPagina()
    {
        commonelementpageobject.navegarLaLiga();
    }
    @When("usuario acepta las cookies")
    public void usuarioAceptaLasCookies()
    {
        commonelementpageobject.aceptarCoockies();
        commonelementpageobject.cerrarPestañaEmergente();
    }

    @Then("usuario pone el raton sobre {string}")
    public void usuarioPoneElRatonSobre(String nombre)
    {
        commonelementpageobject.moverRatonEncimaElemento(nombre);
    }

    @Then("usuario selecciona aleatoriamente una jornada")
    public void usuarioSeleccionaAleatoriamenteUnaJornadaDeLaLigaSantander()
    {
        commonelementpageobject.seleccionarOpcionCombobox();
    }

    @And("obtenemos nombres equipos y resultados")
    public void obtenemosNombresEquiposYResultadosDeLaLigaSantander()
    {
        commonelementpageobject.obtenerEquipos();
        commonelementpageobject.obtenerResultados();
    }

    @Then("escribimos en el archivo json los datos obtenidos {string}")
    public void escribimosEnElArchivoJsonLosDatosObtenidosDeLaLigaSantander(String nombre)
    {
        commonelementpageobject.escribirJSON(nombre);
    }


}
