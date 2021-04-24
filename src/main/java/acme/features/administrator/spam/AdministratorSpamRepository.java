package acme.features.administrator.spam;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spam.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamRepository extends AbstractRepository {
	
	@Query("SELECT s FROM SPAM s WHERE s.ID = ?1")
	Spam findOneSpamById(int id);
	
	@Query("SELECT s from SPAM s")
	Collection<Spam> findAllSpams();

}
