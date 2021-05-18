package authenticated.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedTaskListTest extends AcmePlannerTest {

	// Lifecycle management ---------------------------------------------------
	
		// Test cases -------------------------------------------------------------

		//en este test probaremos el listado de Task, probaremos que se muestra en el orden correspondiente
		//se espera que sea correcto el orden de las Task
		//POSIBLE PROBLEMA: con el tiempo el contenido se puede ver cambiado dado que se muestran las Task del populate Sample actual
		@ParameterizedTest
		@CsvFileSource(resources = "/listTaskAuthenticated/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveAuthenticatedListTask(final int recordIndex, final String title, final String startMoment, final String endMoment,final String description ,final String workload,final String status,final String link) {
			super.navigateHome();
			super.signIn("administrator", "administrator");
			super.clickOnMenu("Authenticated", "List Task");
			super.checkColumnHasValue(recordIndex, 0, title);
			super.checkColumnHasValue(recordIndex, 1, startMoment);
			super.checkColumnHasValue(recordIndex, 2, endMoment);
			super.checkColumnHasValue(recordIndex, 3, workload);

			
			super.navigateHome();

		}

		// Ancillary methods ------------------------------------------------------

}
