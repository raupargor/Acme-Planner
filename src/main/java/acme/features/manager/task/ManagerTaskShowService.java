package acme.features.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class ManagerTaskShowService implements AbstractShowService<Manager, Task>{

	@Autowired
	protected ManagerTaskRepository repository;
	
	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;

		boolean result;
		int id;
		Task task;

		id = request.getModel().getInteger("id");
		task = this.repository.findOneTaskById(id);
		
		result = task.getStatus().name().equals("PRIVADO");//PUEDE QUE NO FUNCIONE

		return result;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "startMoment", "endMoment", "description", "workload", "link", "status");
		
		
	}

	@Override
	public Task findOne(final Request<Task> request) {
		assert request != null;

		Task result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneTaskById(id);

		return result;
	}

}
