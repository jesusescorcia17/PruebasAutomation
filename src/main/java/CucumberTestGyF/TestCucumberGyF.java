package CucumberTestGyF;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"Modulos/pagwong/PaginaWong.feature"},
		glue = {""},
		tags = {"@tagPruebaGirosYfinanza"}
		
		)
public class TestCucumberGyF {

}
