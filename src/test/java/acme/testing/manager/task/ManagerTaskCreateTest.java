package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskCreateTest  extends AcmePlannerTest  {
	

	@ParameterizedTest
	@CsvFileSource(resources = "/createTask/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveCreateTask(final String title, final String startMoment, final String endMoment,final String status, final String description, final String workload, final String link) {
		super.signIn("manager", "manager");

		super.clickOnMenu("Manager", "Create task");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("startMoment", startMoment);
		super.fillInputBoxIn("endMoment", endMoment);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);

		super.clickOnSubmitButton("Create Task");
	}

	
	@ParameterizedTest
	@CsvFileSource(resources = "/createTask/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeCreateTask(final String title, final String startMoment, final String endMoment, final String workload, final String status, final String description,final String link) {
		
		super.signIn("manager", "manager");
		super.clickOnMenu("Manager", "Create task");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("startMoment", startMoment);
		super.fillInputBoxIn("endMoment", endMoment);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);

		super.clickOnSubmitButton("Create Task");
		super.checkErrorsExist();	
	}
	
}
