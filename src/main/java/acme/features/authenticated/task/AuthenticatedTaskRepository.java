package acme.features.authenticated.task;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTaskRepository extends AbstractRepository{
	
	@Query("select t from Task t where t.id=?1")
	Task findOneTaskById(int id);
	
	@Query(value = "SELECT * FROM TASK WHERE NOW() > END_MOMENT AND STATUS = 0 ORDER BY START_MOMENT,END_MOMENT,WORKLOAD", nativeQuery = true)
	Collection<Task> findNotFinishedByExecutionPeriod();
	

	
}
