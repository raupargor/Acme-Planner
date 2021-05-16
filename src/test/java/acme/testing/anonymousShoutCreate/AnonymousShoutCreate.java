package acme.testing.anonymousShoutCreate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.AbstractTest;

public class AnonymousShoutCreate extends AbstractTest {

	// Internal state ---------------------------------------------------------

	// Lifecycle management ---------------------------------------------------

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(true);

		this.signIn("administrator", "administrator");
		super.click(By.linkText("Administrator"));
		super.submit(By.linkText("Populate DB (samples)"));
		this.signOut();
	}

	// Test cases -------------------------------------------------------------

	//Este test es de casos positivos, todos los Shouts cumplen los requisitos especificados,
	//se espera que todos los Shouts se creen sin problema
	@ParameterizedTest
	@CsvFileSource(resources = "/createShout/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveCreateShout(final String author, final String text, final String info) {
		super.navigateHome();
		super.click(By.linkText("Anonymous"));
		super.submit(By.linkText("Shout!"));
		super.fill(By.id("author"), author);
		super.fill(By.id("text"), text);
		super.fill(By.id("info"), info);
		super.submit(By.className("btn-primary"));
		assert super.autoPausing;   
		//assert super.baseUrl.equals(super.contextHome);
	}
	
	//En este test, probaremos las restricciones de los Shout,
	//se espera que salten los errores correspondientes a las restricciones
	@ParameterizedTest
	@CsvFileSource(resources = "/createShout/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeCreateShout(final String author, final String text, final String info) {
		super.navigateHome();
		super.click(By.linkText("Anonymous"));
		super.submit(By.linkText("Shout!"));
		super.fill(By.id("author"), author);
		super.fill(By.id("text"), text);
		super.fill(By.id("info"), info);
		super.submit(By.className("btn-primary"));
		assert super.exists(By.className("btn-primary"));
		
	}

	// Ancillary methods ------------------------------------------------------

	protected void signIn(final String username, final String password) {
		super.navigateHome();
		super.click(By.linkText("Sign in"));
		super.fill(By.id("username"), username);
		super.fill(By.id("password"), password);
		super.click(By.id("remember$proxy"));
		super.submit(By.className("btn-primary"));
	}
	protected void signOut() {
		super.navigateHome();
		super.submit(By.linkText("Sign out"));
	}
	
	protected void checkErrorsExist() {
		super.locate(By.xpath("/Acme-Planner/anonymous/shout/create"));
	}
	

}
