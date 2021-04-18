package acme.entities.tasks;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends DomainEntity{
	
	protected static final long	serialVersionUID	= 1L;
	
	@NotEmpty
	@Length(max = 80)
	protected String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected Date startMoment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected Date endMoment;
	
	@NotEmpty
	@Length(max=500)
	protected String description;
	
	@NotNull
	protected Double workload;
	
	
	@URL
	protected String link;
	
	@NotNull
	protected TaskStatus status;

}
