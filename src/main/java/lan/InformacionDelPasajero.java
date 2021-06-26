package lan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformacionDelPasajero extends BasePage{
    public InformacionDelPasajero(WebDriver driver) {
        super(driver);
    }
    //Objetos//
   @FindBy (xpath = "//input[@name='adult-0.name']")
    WebElement NombrePasajero;

    @FindBy (xpath = "//input[@name='adult-0.surname']")
    WebElement ApellidoPasajero;

    @FindBy (xpath = "//input[@name='adult-0.documentNumber']")
    WebElement DNIPasajero;

   @FindBy (xpath = "//input[@name='contact.email']")
   WebElement MailPasajero;

   @FindBy (xpath = "//input[@name='contact.phoneAreaCode']")
    WebElement CodigoDeAreaTelefonico;

   @FindBy (xpath = "//input[@name='contact.phoneNumber']")
    WebElement NumeroTelefonico;

   @FindBy (xpath = "//button[@class='forward-button btn-flat first-level flat-medium']")
   WebElement btnContinuar;
    //Metodos//
    public void CompletarDatosPasajero(){
        NombrePasajero.sendKeys("Agsdasdn");
        ApellidoPasajero.sendKeys("sddd");
        DNIPasajero.sendKeys("23567412");
        MailPasajero.sendKeys("aaaaaaaaaaaaaaaaaaa@gmail.com");
        CodigoDeAreaTelefonico.sendKeys("380");
        NumeroTelefonico.sendKeys("154325791");
        btnContinuar.click();
    }
}
