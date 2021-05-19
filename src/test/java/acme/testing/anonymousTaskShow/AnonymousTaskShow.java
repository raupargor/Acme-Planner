package acme.testing.anonymousTaskShow;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.testing.AcmeTest;

public class AnonymousTaskShow extends AcmeTest{
	
	// Internal state ---------------------------------------------------------

		// Lifecycle management ---------------------------------------------------

		@Override
		@BeforeAll
		public void beforeAll() {
			super.beforeAll();

			super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
			super.setAutoPausing(true);

			//this.signIn("administrator", "administrator");
			//super.clickOnMenu("Administrator", "Populate DB (samples)");
			//this.signOut();
		}

		// Test cases -------------------------------------------------------------

		//Caso positivo: Un usuario anónimo lista las tasks y accede a una de ellas sin ningún problema. 
		@ParameterizedTest
		@CsvFileSource(resources = "/showTask/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		public void positiveShowTask(final int recordIndex, final String title, final String startMoment, 
			final String endMoment, final String description, final String workload,
			final String link, final String status) {
			super.navigateHome();
			super.clickOnMenu("Anonymous", "List tasks");
		
			super.checkColumnHasValue(recordIndex, 0, title);
			super.checkColumnHasValue(recordIndex, 1, startMoment);
			super.checkColumnHasValue(recordIndex, 2, endMoment);
			super.checkColumnHasValue(recordIndex, 3, workload);
			
			super.clickOnListingRecord(recordIndex);
			
			super.checkInputBoxHasValue("title", title);
			super.checkInputBoxHasValue("startMoment", startMoment);
			super.checkInputBoxHasValue("endMoment", endMoment);
			super.checkInputBoxHasValue("workload", workload);
			super.checkInputBoxHasValue("status", status);
			super.checkInputBoxHasValue("description", description);
			super.checkInputBoxHasValue("link", link);
			
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
