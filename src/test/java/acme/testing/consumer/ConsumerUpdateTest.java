package acme.testing.consumer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.core.annotation.Order;

import acme.testing.AcmePlannerTest;

public class ConsumerUpdateTest extends AcmePlannerTest{
		
		@ParameterizedTest
		@CsvFileSource(resources = "/updateConsumerAndProvider/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveUpdateConsumer(final String Company,final String Sector) {
			super.navigateHome();
			
			super.signIn("consumer", "consumer");
			
			super.clickOnMenu("Account", "Consumer data");
			super.fillInputBoxIn("company", Company);
			super.fillInputBoxIn("sector", Sector);

			super.clickOnSubmitButton("Update");
			
			//Comprobamos que se haya updateado bien
			super.navigate("/authenticated/consumer/update",null);
			super.checkInputBoxHasValue("company", Company);
			super.checkInputBoxHasValue("sector", Sector);
			super.clickOnReturnButton("Return");
			super.signOut();
	
		}
		
		@ParameterizedTest
		@CsvFileSource(resources = "/updateConsumerAndProvider/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void negativeUpdateConsumer(final String Company,final String Sector) {
			super.navigateHome();
			
			super.signIn("consumer", "consumer");
			
			super.clickOnMenu("Account", "Consumer data");
			super.fillInputBoxIn("company", Company);
			super.fillInputBoxIn("sector", Sector);
	
			super.clickOnSubmitButton("Update");
			
			super.checkErrorsExist();
			
			super.signOut();
	
		}

}