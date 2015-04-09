package be.vdab.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

//table per hierarchy
//@DiscriminatorValue("I")

//table per subclass:
@Table(name = "individuelecursussen")

//altijd:
@Entity
public class IndividueleCursus extends Cursus {
	private static final long serialVersionUID = 1L;
	private int duurtijd;
}
