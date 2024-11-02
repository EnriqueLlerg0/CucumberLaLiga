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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CuartoPageObject extends CommonElementPageObject
{
    ArrayList<String> valuesequipossabadomañana=new ArrayList<String>();
    ArrayList<String> valuesequipossabadotarde=new ArrayList<String>();
    ArrayList<String> valuesequiposdomingomañana=new ArrayList<String>();
    ArrayList<String>valuesresultadossabadomañana=new ArrayList<String>();
    ArrayList<String>valuesresultadossabadotarde=new ArrayList<String>();
    ArrayList<String>valuesresultadodomingomañana=new ArrayList<String>();
    List<WebElement>valueshoras;
    List<WebElement>valuesnombresequipos;
    List<WebElement>valuesresultados;

    public CuartoPageObject(MyWebDriver driver) {
        super(driver);
    }

    public void moverRatonLaLigaGenuineSantander()
    {
        moverRaton(driver.getDriver().findElement(By.xpath("//a[contains(@href,'genuine')][1]")));
    }

    public void hacerClickEnResultado()
    {
        click(driver.getDriver().findElement(By.xpath("//a[contains(text(),'Resultados') and contains(@href,'genuine')][1]")));
    }

    public void seleccionarTemporadaAleatoria()
    {
        waiting(3);
        click(driver.getDriver().findElement(By.xpath("//div[@class='styled__SelectedItem-d9k1bl-1 iLBmRg']")));
        waiting(3);

        Random ale=new Random();
        int x=ale.nextInt((driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li")).size()-1)-1+1)+1;

        List<WebElement> values=driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li"));
        String palabra=values.get(x).getText();
        System.out.println(palabra+" -> "+values.size());
        click(driver.getDriver().findElement(By.xpath("//li[contains(text(),'"+palabra+"')]")));

    }

    public void seleccionarFaseAleatoria()
    {
        waiting(3);
        click(driver.getDriver().findElement(By.xpath("//div[@class='styled__DropdownContainer-d9k1bl-0 kmhQzc'][2]")));
        waiting(3);

        Random ale=new Random();
        int x=ale.nextInt((driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li")).size()-1)-1+1)+1;

        List<WebElement> values=driver.getDriver().findElements(By.xpath("//ul[@class='styled__ItemsList-d9k1bl-2 kFWIjB']//li"));
        String palabra=values.get(x).getText();
        System.out.println(palabra+" -> "+values.size());
        click(driver.getDriver().findElement(By.xpath("//li[contains(text(),'"+palabra+"')]")));
    }

    public void obtenerDatos()
    {
        waiting(3);
        valueshoras=driver.getDriver().findElements(By.xpath("//p[contains(text(),'SAB')]//parent::td//parent::tr/td[2]/p")); //Obtenemos horas
        valuesnombresequipos=driver.getDriver().findElements(By.xpath("//p[contains(text(),'SAB')]//parent::td//parent::tr/td[3]/div/div/a/div/p"));
        valuesresultados=driver.getDriver().findElements(By.xpath("//p[contains(text(),'SAB')]//parent::td//parent::tr/td[3]/div/div[2]/div/p[@class='styled__TextRegularStyled-sc-1raci4c-0 fYuQIM']"));

        int cont =0;

        //SABADO MAÑANA
        try {
            Date inicio= new SimpleDateFormat("HH:mm").parse("00:01".trim());
            Date fin= new SimpleDateFormat("HH:mm").parse("14:00".trim());
            Date comprobar;

            for(int i=0;i<valueshoras.size();i++)
            {
                comprobar= new SimpleDateFormat("HH:mm").parse(valueshoras.get(i).getText().trim());

                if(comprobar.after(inicio)&&comprobar.before(fin))
                {
                    valuesequipossabadomañana.add(valuesnombresequipos.get(cont).getText()+"-"+valuesnombresequipos.get(cont+1).getText());
                    valuesresultadossabadomañana.add(valuesresultados.get(cont).getText()+"-"+valuesresultados.get(cont+1).getText());
                }

                cont+=2;
            }

            System.out.println("SABADO -> MAÑANA");

            for(int i=0;i<valuesequipossabadomañana.size();i++)
            {
                System.out.println(valuesequipossabadomañana.get(i));
                System.out.println(valuesresultadossabadomañana.get(i));
            }
            System.out.println();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //SABADO TARDE
        try {
            Date inicio= new SimpleDateFormat("HH:mm").parse("15:00".trim());
            Date fin= new SimpleDateFormat("HH:mm").parse("23:59".trim());
            Date comprobar;

            cont=0;

            for(int i=0;i<valueshoras.size();i++)
            {
                comprobar= new SimpleDateFormat("HH:mm").parse(valueshoras.get(i).getText().trim());

                if(comprobar.after(inicio)&&comprobar.before(fin))
                {
                    valuesequipossabadotarde.add(valuesnombresequipos.get(cont).getText()+"-"+valuesnombresequipos.get(cont+1).getText());
                    valuesresultadossabadotarde.add(valuesresultados.get(cont).getText()+"-"+valuesresultados.get(cont+1).getText());
                }

                cont+=2;
            }

            System.out.println("SABADO -> TARDE");

            for(int i=0;i<valuesequipossabadotarde.size();i++)
            {
                System.out.println(valuesequipossabadotarde.get(i));
                System.out.println(valuesresultadossabadotarde.get(i));
            }
            System.out.println();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //DOMINGO MAÑANA
        valueshoras=driver.getDriver().findElements(By.xpath("//p[contains(text(),'DOM')]//parent::td//parent::tr/td[2]/p")); //Obtenemos horas
        valuesnombresequipos=driver.getDriver().findElements(By.xpath("//p[contains(text(),'DOM')]//parent::td//parent::tr/td[3]/div/div/a/div/p"));
        valuesresultados=driver.getDriver().findElements(By.xpath("//p[contains(text(),'DOM')]//parent::td//parent::tr/td[3]/div/div[2]/div/p[@class='styled__TextRegularStyled-sc-1raci4c-0 fYuQIM']"));

        cont =0;

        try {
            Date inicio= new SimpleDateFormat("HH:mm").parse("00:01".trim());
            Date fin= new SimpleDateFormat("HH:mm").parse("14:00".trim());
            Date comprobar;

            for(int i=0;i<valueshoras.size();i++)
            {
                comprobar= new SimpleDateFormat("HH:mm").parse(valueshoras.get(i).getText().trim());

                if(comprobar.after(inicio)&&comprobar.before(fin))
                {
                    valuesequiposdomingomañana.add(valuesnombresequipos.get(cont).getText()+"-"+valuesnombresequipos.get(cont+1).getText());
                    valuesresultadodomingomañana.add(valuesresultados.get(cont).getText()+"-"+valuesresultados.get(cont+1).getText());
                }

                cont+=2;
            }

            System.out.println("DOMINGO -> MAÑANA");

            for(int i=0;i<valuesequiposdomingomañana.size();i++)
            {
                System.out.println(valuesequiposdomingomañana.get(i));
                System.out.println(valuesresultadodomingomañana.get(i));
            }
            System.out.println();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        /*
        * //p[contains(text(),'SAB')]//parent::td//parent::tr/td[3]/div/div/a/div/p  Obtener equipo los sabados
        */

    }

    public void rellenarJSON(String nombre)
    {
        int cont=0;
        JsonObject obj=new JsonObject();
        JsonArray list=new JsonArray();
        JsonArray list2=new JsonArray();
        JsonArray list3=new JsonArray();

        for(int i=0;i<(valuesresultadossabadomañana.size());i++)
        {
            list.add(valuesequipossabadomañana.get(i));
            list.add(valuesresultadossabadomañana.get(i));
        }
        obj.add("Sabado - mañana",list);

        for(int i=0;i<(valuesequipossabadotarde.size());i++)
        {
            list2.add(valuesequipossabadotarde.get(i));
            list2.add(valuesresultadossabadotarde.get(i));
        }
        obj.add("Sabado - tarde",list2);

        for(int i=0;i<(valuesequiposdomingomañana.size());i++)
        {
            list3.add(valuesequiposdomingomañana.get(i));
            list3.add(valuesresultadodomingomañana.get(i));
        }
        obj.add("Domingo - mañana",list3);

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
