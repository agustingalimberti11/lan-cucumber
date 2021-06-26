package lan;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaInicioPo extends BasePage {
    public PaginaInicioPo(WebDriver driver) {
        super(driver);
    }

    String url = "https://www.latam.com/es_ar/";

    //captura de elementos//

    @FindBy(css = "#onesignal-slidedown-cancel-button")
    WebElement btnCerrarAlerta;

    @FindBy(xpath = "//input[@id='compra-select-origin']")
    WebElement origenVuelo;

   // @FindBy(css = "#ui-id-10")
   // WebElement ciudadBuenosAires;
    @FindBy(xpath = "//span[contains(text(),'Bue')]")
    WebElement ciudadBuenosAires;


    @FindBy(xpath = "//input[@id='compra-select-destination']")
    WebElement destinoVuelo;

    @FindBy(css = "#ui-id-2")
    WebElement ciudadSantiagoChile;

    @FindBy(xpath = "//button[contains(text(),'Busca tu vuelo')]")
    WebElement btnBuscar;

    @FindBy(xpath = "//div[@id='onesignal-slidedown-dialog']")
    WebElement bannerInicio;

    @FindBy(xpath="//input[@inputmode='numeric'] [1]")
    WebElement FechaInicio;

    @FindBy(xpath = "//a[contains(text(),18)] [1]")
    WebElement Fecha18;

    @FindBy(xpath = "//a[contains(text(),25)] [1]")
    WebElement FechaVuelta;

    @FindBy(xpath = "//a[@class='ui-datepicker-next ui-corner-all NoFocusable'] [1]")
    WebElement CambiarMes;
    //Metodos//
    public void Inicio() {
        Log("iniciando");
        driver.get(url);
    }

    public void cierreAlerta() {
        waitFor(20);
        waitForElementToAppear(bannerInicio);
        if (isVisible(bannerInicio)) {
            btnCerrarAlerta.click();
        } else {
            Log("no aparecio el banner de inicio");
        }
    }

    public void elegirOrigen(){
        waitFor(5);
        waitForElementToAppear(origenVuelo);
       origenVuelo.click();
       origenVuelo.sendKeys("BUE");
       waitFor(5);
        ciudadBuenosAires.click();
    }
    public void elegirDestino(){
        destinoVuelo.click();
        destinoVuelo.sendKeys("Santiago de Chile");
        waitFor(5);
        ciudadSantiagoChile.click();
    }
    public void elegirFechasVuelo(){
        FechaInicio.click();
        waitFor(2);
        CambiarMes.click();
        waitFor(2);
        Fecha18.click();
        waitFor(2);
        FechaVuelta.click();
    }
    public void buscarVuelo(){
        btnBuscar.click();
    }

}
