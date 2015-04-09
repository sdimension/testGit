package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//Table per class hierarchy
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Soort")
//@Table(name = "cursussen")

//table per subclass
//@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name = "cursussen")

//table per concrete class
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Entity

public abstract class Cursus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue  voor table per concrete class verwijder @generated value
	private long id;
	private String naam;

	@Override
	public String toString() {
		return naam;
	}
}