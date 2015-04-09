package be.vdab.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//table per hierarchy
//@DiscriminatorValue("G")

//table per subclass:
@Table(name = "groepscursussen")

//altijd:
@Entity
public class GroepsCursus extends Cursus {
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date van;
	@Temporal(TemporalType.DATE)
	private Date tot;
}
