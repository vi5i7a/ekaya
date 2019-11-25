package mz.co.abslda.ekayaapi.fwk.jpa.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author Ivo Abdul
 */
@MappedSuperclass
public abstract class MutableEntity extends CreatableEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6598059987823742062L;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", updatable = true)
	private Date modifiedDate;

	public LocalDateTime getModifiedDate() {
		return getLocalDateTimeFrom(modifiedDate);
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = getDateFrom(modifiedDate);
	}
}