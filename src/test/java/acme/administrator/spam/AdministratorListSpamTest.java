package acme.administrator.spam;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorListSpamTest extends AcmePlannerTest{

	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spam/listPositive.csv", encoding="utf-8", numLinesToSkip=1)
	@Order(10)
	public void listAll(final int recordIndex, final String spamWords) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam");
		super.checkColumnHasValue(recordIndex, 0, spamWords);
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("spamWords", spamWords);
		
		super.signOut();
	}
	
	
}
