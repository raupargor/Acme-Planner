package acme.testing.administrator.threshold;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorThresholdShowTest  extends AcmePlannerTest {
	
	static final String Label= "Update the Spam Threshold";
	
	@ParameterizedTest
	@CsvFileSource(resources = "/showThreshold/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveShowThreshold(final String threshold) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam");
		
		super.clickOnSubmitButton(AdministratorThresholdShowTest.Label);
		
		super.checkInputBoxHasValue("number", threshold);
	
		super.clickOnReturnButton("Return");
		
		super.signOut();

	}

}
