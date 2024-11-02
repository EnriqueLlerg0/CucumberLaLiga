package testpages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import driver.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.CommonElements.CommonElementPageObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuintoPageObject extends CommonElementPageObject
{

    List<WebElement> nombres;
    List<WebElement> total;
    String valor;
    public QuintoPageObject(MyWebDriver driver)
    {
        super(driver);
    }

    public void hacerClickEnEstadisticas()
    {
        waiting(3);
        click(driver.getDriver().findElement(By.xpath("//a[contains(text(),'Estadísticas')][1]")));
    }

    public void hacerClickEnTarjetasRojas()
    {
        waiting(3);
        click(driver.getDriver().findElement(By.xpath("//a[contains(text(),'Tarjetas rojas')][1]")));
    }

    public void seleccionamosUnaLiga()
    {
        waiting(3);
        click(driver.getDriver().findElement(By.xpath("//span[contains(text(),'LaLiga Santander')]//parent::div")));
        waiting(3);

        Random ale=new Random();
        int x=ale.nextInt((driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li")).size()-1)-1+1)+1;

        List<WebElement> values=driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li"));
        String palabra=values.get(x).getText();
        System.out.println(palabra+" -> "+values.size());
        click(driver.getDriver().findElement(By.xpath("//li/div/a[contains(text(),'"+palabra+"')]")));

    }

    public void seleccionamosUnEquipo()
    {
        waiting(3);
        click(driver.getDriver().findElement(By.xpath("//span[contains(text(),'Todos los equipos')]//parent::div")));
        waiting(3);

        Random ale=new Random();
        int x=ale.nextInt((driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li")).size()-1)-1+1)+1;

        List<WebElement> values=driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li"));
        valor=values.get(x).getText();
        System.out.println(valor+" -> "+values.size());
        click(driver.getDriver().findElement(By.xpath("//li/div/a[contains(text(),'"+valor+"')]")));

    }

    public void recogemoLosDatos()
    {
        waiting(3);
        System.out.println(valor.toUpperCase());
        nombres=driver.getDriver().findElements(By.xpath("//p[@class='styled__TextRegularStyled-sc-1raci4c-0 cHonVf']"));
        for(int i=0;i<nombres.size();i++)
        {
                System.out.println(nombres.get(i).getText());
        }

        total=driver.getDriver().findElements(By.xpath("//p[@class='styled__TextRegularStyled-sc-1raci4c-0 dVJgSJ']"));
        for(int i=1;i<total.size();i+=2)
        {
            System.out.println("i"+i+": "+total.get(i).getText());
        }
    }

    public void rellenarJson(String nombre)
    {
        int cont=0;
        JsonObject obj=new JsonObject();

        obj.addProperty("Equipo", valor);

        for(int i=0;i<nombres.size();i++)
        {
            cont++;
            obj.addProperty("Nombre "+cont, nombres.get(i).getText());
        }

        cont=0;

        for(int i=1;i<total.size();i+=2)
        {
            cont++;
            obj.addProperty("Nº tarjetas "+cont, total.get(i).getText());
        }

        try
        {
            FileWriter file=new FileWriter(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"JSON_file"+File.separator+nombre+".json");
            file.write(obj.toString());
            file.flush();
        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
