package page.CommonElements;

import config.ReadConfig;
import driver.MyWebDriver;
import org.openqa.selenium.By;
import page.AbstrapPageObject.AbstrapPageObject;

public class CommonElementPageObject extends AbstrapPageObject
{

    public CommonElementPageObject(MyWebDriver driver)
    {
        super(driver);
    }

    public void navegarLaLiga()
    {
        navegar(ReadConfig.devolverURL());
    }

    public void cerrarPestañaEmergente()
    {
        waiting(5);
        click(driver.getDriver().findElement(By.xpath("//div[@class='rctfl-lightbox-container ']/div[1]/div[3]")));
    }

    public void aceptarCoockies()
    {
        waiting(5);
        click(driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
    }

    public void seleccionarOpcionCombobox()
    {
        seleccionarDatoAleatorioDeUnaListaDesplegable("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li");
    }

    public void obtenerEquipos()
    {
        rellenarEquipos();
    }

    public void obtenerResultados()
    {
        rellenarResultados();
    }

    public void escribirJSON(String palabra)
    {
        rellenarJSON(palabra+".json");
    }

    public void moverRatonEncimaElemento(String palabra)
    {
        waiting(3);
        if(palabra.compareTo("LaLiga Santander")==0)
        {
            moverRaton(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 PFwWw']/a")));
            waiting(1);
            click(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 PFwWw']/div/div/span[2]/a")));
        }
        else if(palabra.compareTo("LaLiga SmartBank")==0)
        {
            moverRaton(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 iVjJbI']/a")));
            waiting(1);
            click(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 iVjJbI']/div/div/span[2]/a")));
        }
        else if(palabra.compareTo("Futbol Femenino")==0)
        {
            moverRaton(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 gxKAzL']/a")));
            waiting(1);
            click(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 gxKAzL']/div/div/span[2]/a")));
        }
        else if(palabra.compareTo("LaLiga Genuine Santander")==0)
        {
            moverRaton(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 hTYiLC']/a")));
            waiting(1);
            click(driver.getDriver().findElement(By.xpath("//div[@class='styled__CompetitionMenuItem-sc-7qz1ev-3 hTYiLC']/div/div/span[2]/a")));
        }
        else
        {
            click(driver.getDriver().findElement(By.xpath("//a[contains(text(),'Estadísticas')][1]")));
        }

    }

    public void hacerClickEnResultado()
    {
        click(driver.getDriver().findElement(By.xpath("//a[contains(text(),'Resultados') and contains(@href,'santander')][1]")));
    }
}
