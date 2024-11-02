package stepdefs.steps;

import cucumber.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import stepdefs.AbstractBaseStep;
import testpages.CuartoPageObject;

import java.util.List;

public class cuarto extends AbstractBaseStep
{
    CuartoPageObject cuartopageobject;
    public cuarto(Context context)
    {
        super(context);
        cuartopageobject=context.getManager().getCuartopageobject();
    }

    @Then("usuario pone el raton sobre La Liga Genuine Santander")
    public void usuarioPoneElRatonSobreLaLigaGenuineSantander()
    {
        cuartopageobject.moverRatonLaLigaGenuineSantander();
    }

    @And("usuario selecciona Resultados La Liga Genuine Santander")
    public void usuarioSeleccionaResultadosLaLigaGenuineSantander()
    {
        cuartopageobject.hacerClickEnResultado();
    }

    @Then("usuario selecciona aleatoriamente una temporada")
    public void usuarioSeleccionaAleatoriamenteUnaTemporada()
    {
        cuartopageobject.seleccionarTemporadaAleatoria();
    }

    @And("usuario selecciona aleatoriamente una fase")
    public void usuarioSeleccionaAleatoriamenteUnaFase()
    {
        cuartopageobject.seleccionarFaseAleatoria();
    }

    @Then("obtenemos nombres equipos y resultados divididos por mañana o tarde, sabado o domingo")
    public void obtenemosNombresEquiposYResultadosDivididosPorMañanaOTardeSabadoODomingo()
    {
        cuartopageobject.obtenerDatos();
    }

    @And("escribimos en el archivo json los datos obtenidos sobre La Liga Genuine Santander {string}")
    public void escribimosEnElArchivoJsonLosDatosObtenidosSobreLaLigaGenuineSantander(String nombre)
    {
        cuartopageobject.rellenarJSON(nombre);
    }
}
