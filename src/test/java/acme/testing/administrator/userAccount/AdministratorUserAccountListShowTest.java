package acme.testing.administrator.userAccount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.core.annotation.Order;

import acme.testing.AcmePlannerTest;

public class AdministratorUserAccountListShowTest extends AcmePlannerTest{
	
	// Internal state ---------------------------------------------------------

			// Lifecycle management ---------------------------------------------------

			// Test cases -------------------------------------------------------------

			/*Caso positivo: Un usuario administrador lista las cuentas de usuario
			 *  y accede a cada una de ellas sin problema.*/ 
			@ParameterizedTest
			@CsvFileSource(resources = "/administrator/userAccount/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
			@Order(10)
			public void positiveListAndShowUserAccount(final int recordIndex, final String username, final String name, 
				final String surname, final String email, final String roles, final String status, final String newStatus) {
				super.navigateHome();
				super.signIn("administrator", "administrator");
				super.clickOnMenu("Administrator", "User accounts");
			
				super.checkColumnHasValue(recordIndex, 0, username);
				super.checkColumnHasValue(recordIndex, 1, name);
				super.checkColumnHasValue(recordIndex, 2, surname);
				
				super.clickOnListingRecord(recordIndex);
				
				super.checkInputBoxHasValue("username", username);
				super.checkInputBoxHasValue("name", name);
				super.checkInputBoxHasValue("surname", surname);
				super.checkInputBoxHasValue("email", email);
				super.checkInputBoxHasValue("roles", roles);
				super.checkInputBoxHasValue("status", status);
				//El atributo newStatus sale para una user Account (la primera) y para las demás no. 
				super.checkInputBoxHasValue("new status", newStatus);			
				super.signOut();
				
			}

}
