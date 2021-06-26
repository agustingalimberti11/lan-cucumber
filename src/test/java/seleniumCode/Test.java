package seleniumCode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lan.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
    public ChromeDriver driver;
    PaginaInicioPo PI;
    SeleccionDeVuelo SV;
    InformacionDelPasajero IP;
    ElegirButacaVuelos EB;
    MedioDePago MP;

    @Given(": como cliente ingreso a la URL {string}")
    public void como_cliente_ingreso_a_la_url(String string) throws Throwable {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("enable-automation");
    options.addArguments("start-maximized","--ignore-certificate-errors");
    options.addArguments("--no-sandbox");
    ChromeOptions chromeOptions = options.setPageLoadStrategy(PageLoadStrategy.NONE);
    driver = new ChromeDriver(options);
    this.PI = new PaginaInicioPo(driver);
    this.SV = new SeleccionDeVuelo(driver);
    this.IP = new InformacionDelPasajero(driver);
    this.EB = new ElegirButacaVuelos(driver);
    this.MP = new MedioDePago(driver);
        PI.Inicio();
    }
    @When(": selecciono un destino.")
    public void selecciono_un_destino() throws Exception {
    PI.cierreAlerta();
    PI.elegirOrigen();
    PI.elegirDestino();
    PI.elegirFechasVuelo();
    }

    @When(": Lo agrego a la bolsa.")
    public void lo_agrego_a_la_bolsa() throws Exception {
    PI.buscarVuelo();
    SV.ElegirVueloDeIda();
    SV.ElegirVueloDeVuelta();
    IP.CompletarDatosPasajero();
    EB.elegirButaca();
    }

    @When(": escojo un medio de pago.")
    public void escojo_un_medio_de_pago() throws Exception {
    MP.SeleccionarMedioDePago();
    MP.reporter();
    }
}
