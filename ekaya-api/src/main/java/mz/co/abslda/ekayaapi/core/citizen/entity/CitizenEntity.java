package mz.co.abslda.ekayaapi.core.citizen.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import mz.co.abslda.ekayaapi.fwk.jpa.entity.LifeCycleEntity;

/**
 * @author Ivo Abdul
 */
@Entity
@Table(name = "citizen")
public class CitizenEntity  extends LifeCycleEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6410561433485100672L;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Embedded
	private CitizenDetailEntity detail;
	
	@Column(name = "party_id")
	private Long partyId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public CitizenDetailEntity getDetail() {
		return detail;
	}

	public void setDetail(CitizenDetailEntity detail) {
		this.detail = detail;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
}
