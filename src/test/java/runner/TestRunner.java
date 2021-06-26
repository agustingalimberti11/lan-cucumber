package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/lan/test.feature",
        glue = ("seleniumCode"),
        plugin = {"json:test/report/cucumber_report.json"},
        tags = {"@Prueba1"}
)



public class TestRunner {

    @BeforeClass()
    public static void setUp(){
        LOGGER.log(Level.INFO, "Comienza la ejecución de las pruebas...");
    }

    @AfterClass
    public static void teardown(){
        try {
            LOGGER.log(Level.INFO, "Generando reporte...");
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            LOGGER.log(Level.INFO, "Reporte generado satisfactoriamente!");
        }catch (Exception ex){
            LOGGER.log(Level.WARNING, "No se pudo generar el reporte.");
            ex.printStackTrace();
        }
    }

}



