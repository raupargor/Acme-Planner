package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskDeleteTest extends AcmePlannerTest {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/deleteTaskManager/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveDeleteTask(final int recordIndex,final int id) {
		
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");
		super.clickOnListingRecord(recordIndex);
		super.clickOnSubmitButton("Delete Task");
		super.navigate("/manager/work-plan/show", "id=" + id);
		super.checkPanicExists();
	}

}
