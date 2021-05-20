package acme.testing.administrator.threshold;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorThresholdUpdateTest extends AcmePlannerTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/updateThreshold/positive2.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveUpdateThreshold(final String threshold) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Spam");
		super.clickOnReturnButton(AdministratorThresholdShowTest.Label);
		
		super.fillInputBoxIn("number", threshold);
		super.clickOnSubmitButton("Update Threshold");
		
		//Comprobamos que se haya updateado bien
		super.clickOnMenu("Administrator", "Spam");
		super.clickOnReturnButton(AdministratorThresholdShowTest.Label);
		super.checkInputBoxHasValue("number", threshold);
		super.clickOnReturnButton("Return");
		
		super.signOut();

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/updateThreshold/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeUpdateThreshold(final String threshold) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Spam");
		super.clickOnReturnButton(AdministratorThresholdShowTest.Label);
		
		super.fillInputBoxIn("number", threshold);
		super.clickOnSubmitButton("Update Threshold");
		
		super.checkErrorsExist();
		
		super.signOut();

	}


}
