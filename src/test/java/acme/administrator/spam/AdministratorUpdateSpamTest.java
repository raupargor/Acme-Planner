package acme.administrator.spam;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorUpdateSpamTest extends AcmePlannerTest{

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spam/updateFailure.csv", encoding="utf-8", numLinesToSkip=1)
	@Order(10)
	public void updateFailure(final int recordIndex, final String spamWords) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam");
		super.checkColumnHasValue(recordIndex, 0, spamWords);
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("spamWords", "");
		super.clickOnSubmitButton("Update Spam");
		super.checkErrorsExist();
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spam/updatePositive.csv", encoding="utf-8", numLinesToSkip=1)
	@Order(20)
	public void updatePositive(final int recordIndex, final String spamWords,final String updateWord) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam");
		super.checkColumnHasValue(recordIndex, 0, spamWords);
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("spamWords", updateWord);
		super.clickOnSubmitButton("Update Spam");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("spamWords", updateWord);
		super.signOut();
	}
	
	
	
	
}
