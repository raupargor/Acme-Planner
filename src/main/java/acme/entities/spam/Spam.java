package acme.entities.spam;

import javax.persistence.Entity;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends DomainEntity {
	
	// Serialisation identifier -----------------------------------------------
	protected static final long	serialVersionUID	= 1L;


	// Attributes -------------------------------------------------------------
	protected String spamWords;


	@Override
	public String toString() {
		return this.spamWords;
	}

}
	