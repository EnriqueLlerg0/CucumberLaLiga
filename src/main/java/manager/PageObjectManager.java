package manager;

import driver.MyWebDriver;
import page.CommonElements.CommonElementPageObject;
import testpages.*;

public class PageObjectManager
{
    private MyWebDriver driver;
    PrimerPageObject primerpageobject;
    SegundoPageObject segundopageobject;
    TerceroPageObject tercerpageobject;
    CuartoPageObject cuartopageobject;
    QuintoPageObject quintopageobject;
    public PageObjectManager(MyWebDriver driver)
    {
        this.driver=driver;
    }

    CommonElementPageObject commonElementPageObject;
    public CommonElementPageObject getCommonElementPageObject()
    {
        return (commonElementPageObject==null)?commonElementPageObject=new CommonElementPageObject(driver):commonElementPageObject;
    }

    public PrimerPageObject getPrimeropageobject()
    {
        return (primerpageobject==null)?primerpageobject=new PrimerPageObject(driver):primerpageobject;
    }
    public SegundoPageObject getSegundopageobject()
    {
        return (segundopageobject==null)?segundopageobject=new SegundoPageObject(driver):segundopageobject;
    }
    public TerceroPageObject getTercerpageobject()
    {
        return (tercerpageobject==null)?tercerpageobject=new TerceroPageObject(driver):tercerpageobject;
    }
    public CuartoPageObject getCuartopageobject()
    {
        return (cuartopageobject==null)?cuartopageobject=new CuartoPageObject(driver):cuartopageobject;
    }
    public QuintoPageObject getQuintopageobject()
    {
        return (quintopageobject==null)?quintopageobject=new QuintoPageObject(driver):quintopageobject;
    }
}
