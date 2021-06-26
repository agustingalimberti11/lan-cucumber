package lan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MedioDePago extends BasePage {

    public MedioDePago(WebDriver driver) {
        super(driver);
    }


    //Objetos//
    @FindBy (css= "#titulo_grupo_mp_caja_contenido_CREDIT_CARD")
    WebElement MenuTarjetaDeCredito;

    @FindBy (xpath = "//input[@title='Tarjeta Naranja']")
    WebElement ElegirTarjetaNaranja;

    @FindBy (xpath = "//input[@name='checkbox']")
    WebElement AceptarTerminosyCondiciones;

    @FindBy (xpath = "//input[@name='next_step']")
    WebElement btnContinuar;

    @FindBy (css = "#id_rut_titular")
    WebElement DNITitular;
    //   Datos para reporte     //
    //Datos tramo1 del vuelo//
    @FindBy (css = "#id_tabla_itinerario > tbody > tr:nth-child(2) > td:nth-child(1)")
    WebElement Tramo1;


    @FindBy (xpath = "//td[contains(text(),'EZE')] [1]")
    WebElement Salida1;
    @FindBy (xpath = "//td[contains(text(),'SCL')] [1]")
    WebElement Llegada1;
    @FindBy (xpath = "//td[contains(text(),'LA474')] ")
    WebElement Vuelo1;
    @FindBy (xpath = "//td[contains(text(),'Economy-S')]")
    WebElement Cabina1;
    @FindBy (xpath = "//tbody/tr[2]/td[6]")
    WebElement Equipaje1;
    //Datos tramo2 del vuelo//
    @FindBy (xpath = "")
    WebElement Tramo2;
    @FindBy (xpath = "")
    WebElement Salida2;
    @FindBy (xpath = "")
    WebElement Llegada2;
    @FindBy (xpath = "")
    WebElement Vuelo2;
    @FindBy (xpath = "")
    WebElement Cabina2;
    @FindBy (xpath = "")
    WebElement Equipaje2;
    //Metodos//
    public void SeleccionarMedioDePago(){
        waitFor(30);
        waitForElementToAppear(MenuTarjetaDeCredito);
        MenuTarjetaDeCredito.click();
        ElegirTarjetaNaranja.click();
        Select SelectDNI = new Select(driver.findElement(By.xpath("//*[@id=\"id_tipo_foid\"]")));
        SelectDNI.selectByValue("ni");
        DNITitular.sendKeys("32795430");
        AceptarTerminosyCondiciones.click();
        waitFor(2);
       // btnContinuar.click();
    }


    private  WriteExcelFile writeFile;

    public void reporter() throws Exception{
        writeFile = new WriteExcelFile();

        Tramo1.isDisplayed();
        String resultText1 = Tramo1.getText();
        /*Salida1.isDisplayed();
        String resultText2 = Salida1.getText();
        Llegada1.isDisplayed();
        String resultText3 = Llegada1.getText();
        Vuelo1.isDisplayed();
        String resultText4 = Vuelo1.getText();
        Cabina1.isDisplayed();
        String resultText5 = Cabina1.getText();
        Equipaje1.isDisplayed();
        String resultText6 = Equipaje1.getText();*/

        String filepath = "C:\\Users\\agustin.galimberti\\Desktop\\lan2\\Test.xlsx";
        System.out.println("Resultado es "+ resultText1);


        writeFile.writeCellValue(filepath,"Hoja1",2,2,resultText1);
       /* writeExcelFile.writeCellValue(filepath,"Hoja1",1,3,resultText2);
        writeExcelFile.writeCellValue(filepath,"Hoja1",1,4,resultText3);
        writeExcelFile.writeCellValue(filepath,"Hoja1",1,5,resultText4);
        writeExcelFile.writeCellValue(filepath,"Hoja1",1,6,resultText5);
        writeExcelFile.writeCellValue(filepath,"Hoja1",1,7,resultText6);*/

    }
}
