package acme.features.authenticated.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.entities.tasks.TaskStatus;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedTaskCreateService implements AbstractCreateService<Authenticated, Task>{

	// Internal state ---------------------------------------------------------

		@Autowired
		protected AuthenticatedTaskRepository repository;

		// AbstractCreateService<Administrator, Task> interface --------------
		
	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
		
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "startMoment", "endMoment", "description", "workload", "link", "status");
		
	}

	@Override
	public Task instantiate(final Request<Task> request) {
		assert request != null;

		Task result;
		Date startMoment;
		Date endMoment;
		
		startMoment = new Date(System.currentTimeMillis() - 2);
		endMoment = new Date(System.currentTimeMillis() - 1);

		result = new Task();
		result.setStartMoment(startMoment);
		result.setEndMoment(endMoment);
		result.setDescription("description");
		result.setLink("http://example.org");
		result.setStatus(TaskStatus.PUBLIC);
		result.setTitle("title");
		result.setWorkload(2.50);

		return result;
	}

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void create(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;

		Date startMoment;
		Date endMoment;

		startMoment = new Date(System.currentTimeMillis() - 2);
		endMoment = new Date(System.currentTimeMillis() - 1);
		entity.setStartMoment(startMoment);
		entity.setEndMoment(endMoment);
		
		entity.setStatus(TaskStatus.PUBLIC);
		entity.setWorkload(2.);
		this.repository.save(entity);
		
	}

	
		
	

}
