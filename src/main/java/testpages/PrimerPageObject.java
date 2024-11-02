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
import java.util.List;

public class PrimerPageObject extends CommonElementPageObject
{
    public PrimerPageObject(MyWebDriver driver)
    {
        super(driver);
    }

    public void moverRatonEncimaLigaSantander()
    {
        moverRaton(driver.getDriver().findElement(By.xpath("//a[contains(@href,'santander')][1]")));
    }

    public void hacerClickEnResultado()
    {
        click(driver.getDriver().findElement(By.xpath("//a[contains(text(),'Resultados') and contains(@href,'santander')][1]")));
    }
}
