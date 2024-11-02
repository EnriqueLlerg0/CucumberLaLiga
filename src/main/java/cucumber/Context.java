package cucumber;

import driver.MyWebDriver;
import manager.PageObjectManager;

public class Context
{
    private final MyWebDriver driver;
    private final PageObjectManager manager;
    public Context()
    {
        this.driver = new MyWebDriver();
        this.manager= new PageObjectManager(driver);
    }

    public MyWebDriver getDriver()
    {
        return driver;
    }

    public PageObjectManager getManager()
    {
        return manager;
    }
}
