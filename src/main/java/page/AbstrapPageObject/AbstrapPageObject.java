package page.AbstrapPageObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import driver.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public abstract class AbstrapPageObject
{
    List<WebElement>valuesequipos;
    List<WebElement>valuesresultados;
    protected final MyWebDriver driver;

    protected AbstrapPageObject(MyWebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver.getDriver(),this);
    }

    public void navegar(String url)
    {
        driver.getDriver().get(url);
    }

    public void click(WebElement element)
    {
        //element.click();
        new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waiting(int num)
    {
        try {
            Thread.sleep(num*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void moverRaton(WebElement element)
    {
        Actions action=new Actions(driver.getDriver());
        action.moveToElement(element).perform();
        waiting(3);
    }

    public void seleccionarDatoAleatorioDeUnaListaDesplegable(String xpath)
    {
        waiting(3);
        click(driver.getDriver().findElement(By.xpath("//div[@class='styled__SelectedItem-d9k1bl-1 iLBmRg']")));
        waiting(3);

        Random ale=new Random();
        int x=ale.nextInt((driver.getDriver().findElements(By.xpath(xpath)).size()-1));

        List<WebElement> values=driver.getDriver().findElements(By.xpath(xpath));
        String palabra=values.get(x).getText(); //44
        System.out.println(palabra+" -> "+values.size());
        click(driver.getDriver().findElement(By.xpath("//a[contains(text(),'"+palabra+"')]")));
    }

    public void rellenarEquipos()
    {
        waiting(3);
        valuesequipos=driver.getDriver().findElements(By.xpath("//p[@class='styled__TextRegularStyled-sc-1raci4c-0 hvREvZ']"));
        for(int i=0;i<valuesequipos.size();i+=2)
        {
            System.out.println(valuesequipos.get(i).getText()+" - "+valuesequipos.get(i+1).getText());
        }
    }

    public void rellenarResultados()
    {
        waiting(1);
        valuesresultados=driver.getDriver().findElements(By.xpath("//div[@class='live']//p[@class='styled__TextRegularStyled-sc-1raci4c-0 fYuQIM']"));
        for(int i=0;i<valuesresultados.size();i+=2)
        {
            System.out.println(valuesresultados.get(i).getText()+" - "+valuesresultados.get(i+1).getText());
        }
    }

    public void rellenarJSON(String nombre)
    {
        int cont=0;
        JsonObject obj=new JsonObject();
        JsonArray list=new JsonArray();
        for(int i=0;i<valuesequipos.size();i+=2)
        {
            cont++;
            obj.addProperty("Equipos visitante "+cont, valuesequipos.get(i).getText());
            obj.addProperty("Equipos local "+cont, valuesequipos.get(i+1).getText());
            String palabra=valuesresultados.get(i).getText()+" - "+valuesresultados.get(i+1).getText();
            obj.addProperty("resultado "+cont, palabra);
        }

        try
        {
            FileWriter file=new FileWriter(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"JSON_file"+File.separator+nombre);
            file.write(obj.toString());
            file.flush();
        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
