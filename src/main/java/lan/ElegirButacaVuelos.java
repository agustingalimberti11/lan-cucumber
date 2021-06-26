package lan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElegirButacaVuelos extends BasePage {
    public ElegirButacaVuelos(WebDriver driver) {
        super(driver);
    }
    //Objetos//
    @FindBy (id = "seat-5A")
    WebElement ButacaVueloIda;

    @FindBy (css = "#seat-5A")
    WebElement ButacaVueloIdaConfirmacion;

    //#seat-4A

    @FindBy (id = "seat-4B")
    WebElement ButacaVueloVuelta;

    @FindBy (css= "#seat-4B")
    WebElement ButacaVueloVueltaConfirmacion;

    @FindBy (xpath = "//input[@id='legal-conditions-check']")
    WebElement CheckCondiciones;

    @FindBy (xpath = "//button[@id='ok-button']")
    WebElement btnConfirmarSeleccion;

    @FindBy (xpath = "//*[@id=\"mainContent\"]/div/h1")
    WebElement Tittle;

    @FindBy (id = "continue-anyway-button")
    WebElement btnContinuarDeTodasFormas;
    //Metodos//
    public void elegirButaca(){
        waitFor(10);
        waitForElementToAppear(ButacaVueloIda);
        ButacaVueloIda.click();
        ButacaVueloIdaConfirmacion.click();
        waitFor(10);
        Tittle.click();
        waitFor(5);
        waitForElementToAppear(ButacaVueloVuelta);
        ButacaVueloVuelta.click();
        ButacaVueloVueltaConfirmacion.click();
        waitFor(5);
        waitForElementToAppear(CheckCondiciones);
        CheckCondiciones.click();
        btnConfirmarSeleccion.click();
        waitFor(3);
        if(btnContinuarDeTodasFormas.isDisplayed()){
            btnContinuarDeTodasFormas.click();
        }
    }
}
