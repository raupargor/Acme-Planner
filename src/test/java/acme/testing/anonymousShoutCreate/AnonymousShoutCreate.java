package acme.testing.anonymousShoutCreate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.testing.AcmeTest;

public class AnonymousShoutCreate extends AcmeTest {

	// Internal state ---------------------------------------------------------

	// Lifecycle management ---------------------------------------------------

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(true);

		this.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (samples)");
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
		super.clickOnMenu("Anonymous", "Shout!");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");

	}
	
	//En este test, probaremos las restricciones de los Shout,
	//se espera que salten los errores correspondientes a las restricciones
	@ParameterizedTest
	@CsvFileSource(resources = "/createShout/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeCreateShout(final String author, final String text, final String info) {
		super.navigateHome();
		super.clickOnMenu("Anonymous", "Shout!");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");
		super.checkErrorsExist();
		
	}

	// Ancillary methods ------------------------------------------------------

	protected void signIn(final String username, final String password) {
		super.navigateHome();
		super.clickOnLink("Sign in");
		super.clickAndGo(By.linkText("Sign in"));
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.clickAndGo(By.id("remember$proxy"));
		super.clickOnSubmitButton("Sign in");
	}
	protected void signOut() {
		super.navigateHome();
		super.clickOnLink("Sign out");
	}

}
