package lan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SeleccionDeVuelo extends BasePage {
    public SeleccionDeVuelo(WebDriver driver) {
        super(driver);
    }
    //Seleccion de Objetos//
    @FindBy (xpath = "//abbr[contains(text(),'EZE')]")
    WebElement VueloEzeiza;

    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    WebElement btnContinuar;

    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    WebElement btnConfirmar;
    /*
    @FindBy(xpath = "//abbr[contains(text(),'EZE')] [1]")
    WebElement VueloVuelta;
*/
    @FindBy (xpath="//div[@class='flight-summary with-duration'] [1]")
    WebElement VueloVuelta;

    @FindBy(xpath = "//div[@class='no-bags-included-dialog-buttons']/button[contains(text(),'Confirmar')][1]")
    WebElement btnConfirmarVuelo;


    //Metodos//
    public void ElegirVueloDeIda(){
        waitFor(10);
        VueloEzeiza.click();
        waitFor(2);
        btnContinuar.click();
        waitFor(2);
        btnConfirmar.click();
    }
    public void ElegirVueloDeVuelta(){
        waitFor(5);
        VueloVuelta.click();
        waitFor(2);
        btnConfirmar.click();
        waitFor(2);
        btnConfirmarVuelo.click();
        waitFor(5);
    }
}
