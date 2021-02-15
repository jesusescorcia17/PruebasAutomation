package PasoTest;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MetodosTestGyF {
	//inicializo las variables
	WebDriver driver;
	By TerminosLocator = By.xpath("//*[@id=\"search-results-page\"]/div[36]/div/div[3]/button[1]");
	By Agregar = By.linkText("Porción de Papas Fritas Especiales x 300 g");
	By Selecciono = By.xpath("//*[@id=\"product-food-page\"]/div[22]/div/div[1]/div[1]/div[5]/div[2]/div[6]/div[5]/button[1]");
	By AgregarCorreo = By.id("delivery-email");
	By Click = By.xpath("//*[@id=\"footer\"]/div[3]/div/div/div/div/div/div[3]/button");
	By LugarRecogida = By.xpath("//*[@id=\"footer\"]/div[3]/div/div/div/div/div/div[2]/div[2]/button[1]");
	By AceptarSi = By.xpath("//*[@id=\"google-input\"]");
	By EscribirNum = By.id("complement");
	By ClickSeleccionar = By.xpath("//*[@id=\"footer\"]/div[3]/div/div/div/div/div[1]/button");

@Given("^abrir la pagina Prueba wong$")
public void abrir_la_pagina_Prueba_wong() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.setProperty("webdriver.chrome.driver", "src/LugarDriver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.wong.pe/especiales/cyberwong");
	Thread.sleep(5000);
}

@Given("^validar politicas generales y aceptar terminos$")
public void validar_politicas_generales_y_aceptar_terminos() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	if (driver.findElement(TerminosLocator).isDisplayed()) {
		driver.findElement(TerminosLocator).click();
	}
	else {
		System.out.print("si no muestra es por que ya se abrio la pagina anteriormente");
}
}
@Given("^seleccionas el producto$")
public void seleccionas_el_producto() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(Agregar).click();
	Thread.sleep(4000);
	driver.findElement(Selecciono).click();
}

@Given("^si pide correo se agrega \"([^\"]*)\"$")
public void si_pide_correo_se_agrega(String correo) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(3000);
	if (driver.findElement(AgregarCorreo).isDisplayed()) {
		Thread.sleep(3000);
		driver.findElement(AgregarCorreo).sendKeys(correo);
	}
	else {
		System.out.print("si no muestra es por que ya se abrio la pagina anteriormente");
}
}

@Given("^si pide click en recojo en tienda$")
public void si_pide_click_en_recojo_en_tienda() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	if (driver.findElement(Click).isDisplayed()) {
		driver.findElement(Click).click();
	}
	else {
		System.out.print("si no muestra es por que ya se abrio la pagina y guardo cache");
}
}

@Given("^selecciona tienda$")
public void selecciona_tienda() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		WebElement dropdown_arrow = driver.findElement(LugarRecogida);
		dropdown_arrow.click();
	}

@Given("^seleccionas direccion\"([^\"]*)\"$")
public void seleccionas_direccion(String Dirccion) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
		driver.findElement(AceptarSi).sendKeys(Dirccion);
		if (driver.findElement(AceptarSi).isDisplayed()){
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"google-input\"]")).sendKeys(Keys.ENTER);
		}

}
@Given("^click recojo aqui\"([^\"]*)\"$")
public void click_recojo_aqui(String numero) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(2000);
	driver.findElement(EscribirNum).sendKeys(numero);
}

@Given("^aceptar si click$")
public void aceptar_si_click() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(ClickSeleccionar).click();
	Thread.sleep(10000);
}

@Then("^Verificar el producto$")
public void verificar_el_producto() throws Throwable {

	// Write code here that turns the phrase above into concrete actions
	//Robot rob = new Robot();
	//aqui baja el scroll y busca los elementos y valida el lo que se agrego al carro
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,2000)");
	//(//a[contains(@href, '/cart')])[4]
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"product-food-page\"]/div[22]/div/div[2]/div[1]/div[2]/a")).click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,2000)");
	String texto;
	texto = driver.findElement(By.xpath("//*[@id=\"cart-page\"]/div[9]/div/div[3]/div[1]/div[5]/div[2]/div/div[3]/a")).getText();
	System.out.println("El texto es: "+texto);
	
	assertEquals("Porción de Papas Fritas Especiales x 300 g", texto);
	Thread.sleep(5000);
}

@Then("^Cerramos la pagina$")
public void cerramos_la_pagina() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.quit();
	
	//System.out.println("nos salimosssssssssssssssss");
}

}
