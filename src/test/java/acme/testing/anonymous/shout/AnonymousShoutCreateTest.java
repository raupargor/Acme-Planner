package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousShoutCreateTest extends AcmePlannerTest {

	// Lifecycle management ---------------------------------------------------
	
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
		super.checkSimplePath("/master/welcome");

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

}
