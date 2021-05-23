package acme.testing.provider;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.core.annotation.Order;

import acme.testing.AcmePlannerTest;

public class ProviderUpdateTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/updateConsumerAndProvider/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveUpdateProvider(final String Company,final String Sector) {
		super.navigateHome();
		
		super.signIn("provider", "provider");
		
		super.clickOnMenu("Account", "Provider data");
		super.fillInputBoxIn("company", Company);
		super.fillInputBoxIn("sector", Sector);

		super.clickOnSubmitButton("Update");
		
		//Comprobamos que se haya updateado bien
		super.navigate("/authenticated/provider/update",null);
		super.checkInputBoxHasValue("company", Company);
		super.checkInputBoxHasValue("sector", Sector);
		super.clickOnReturnButton("Return");
		super.signOut();

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/updateConsumerAndProvider/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeUpdateProvider(final String Company,final String Sector) {
		super.navigateHome();
		
		super.signIn("provider", "provider");
		
		super.clickOnMenu("Account", "Provider data");
		super.fillInputBoxIn("company", Company);
		super.fillInputBoxIn("sector", Sector);

		super.clickOnSubmitButton("Update");
		
		super.checkErrorsExist();
		
		super.signOut();

	}

}