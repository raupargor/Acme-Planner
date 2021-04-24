package acme.features.manager.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.entities.tasks.TaskStatus;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerTaskCreateService implements AbstractCreateService<Manager, Task> {

	@Autowired
	protected ManagerTaskRepository repository;
	
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
		Manager manager;
		Date startMoment;
		Date endMoment;
		
		manager = this.repository.findManagerByUsername(request.getPrincipal().getUsername());
		
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
		result.setManager(manager);

		return result;
	}

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		//HAY QUE VALIDAR LAS FECHAS Y EL WORKLOAD COMO ES DEBIDO (POR HACER)
	}

	@Override
	public void create(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;

		Manager manager;
		Date startMoment;
		Date endMoment;
		
		manager = this.repository.findManagerByUsername(request.getPrincipal().getUsername());

		startMoment = new Date(System.currentTimeMillis() - 2);
		endMoment = new Date(System.currentTimeMillis() - 1);
		entity.setStartMoment(startMoment);
		entity.setEndMoment(endMoment);
		
		entity.setStatus(TaskStatus.PUBLIC);
		entity.setWorkload(2.);
		
		entity.setManager(manager);
		
		this.repository.save(entity);
		
	}

}
