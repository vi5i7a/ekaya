package mz.co.abslda.ekayaapi.core.residence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import mz.co.abslda.ekayaapi.fwk.jpa.entity.LifeCycleEntity;

/**
 * @author Ivo Abdul
 */
@Entity
@Table(name = "residence")
public class ResidenceEntity  extends LifeCycleEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "parent_id")
	private Long parentId;
	
	@NotNull
	@Column(name = "type")
	private String type;
	
	@NotNull
	@Column(name = "value")
	private String value;
	
	@Column(name = "party_id")
	private Long partyId;
	
	@Column(name = "geo_id")
	private Long geoId;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Long getGeoId() {
		return geoId;
	}

	public void setGeoId(Long geoId) {
		this.geoId = geoId;
	}
}