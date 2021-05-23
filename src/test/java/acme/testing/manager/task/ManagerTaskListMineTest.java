package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskListMineTest  extends AcmePlannerTest {
	
	//Test de la lista de tasks de un Manager. Se espera que cada columna tenga el valor asignado en /listTask/positive.csv
	@ParameterizedTest
	@CsvFileSource(resources = "/listTask/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveListTask(final int recordIndex, final String title, final String startMoment, 
		final String endMoment,final String workload,final String status, final String description, final String link) {
		
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, startMoment);
		super.checkColumnHasValue(recordIndex, 2, endMoment);
		super.checkColumnHasValue(recordIndex, 3, workload);


	}
}
