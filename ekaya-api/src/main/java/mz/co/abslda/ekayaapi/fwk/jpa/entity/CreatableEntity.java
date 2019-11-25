package mz.co.abslda.ekayaapi.fwk.jpa.entity;

import static java.time.Instant.ofEpochMilli;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;
import static java.util.Objects.isNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.CreatedDate;

/**
 * @author Ivo Abdul
 */
@MappedSuperclass
public abstract class CreatableEntity implements Comparable<CreatableEntity>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8162455265881899719L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", updatable = false)
	private Date createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return getLocalDateTimeFrom(createdDate);
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = getDateFrom(createdDate);
	}

	protected LocalDateTime getLocalDateTimeFrom(Date date) {
		return isNull(date) ? null : ofInstant(ofEpochMilli(date.getTime()), systemDefault());
	}

	protected Date getDateFrom(LocalDateTime localDateTime) {
		return isNull(localDateTime) ? null : Date.from(localDateTime.atZone(systemDefault()).toInstant());
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!this.getClass().isAssignableFrom(obj.getClass())) {
			return false;
		}

		if (obj instanceof CreatableEntity) {
			CreatableEntity vo = (CreatableEntity) obj;

			if ((this.getId() == null) || (vo.getId() == null)) {
				return false;
			}
			return this.getId().equals(vo.getId());
		}

		return false;
	}

	@Override
	public int compareTo(final CreatableEntity other) {
		if (other == null) {
			throw new NullPointerException();
		}
		return new CompareToBuilder().append((this.getId() == null) && (other.getId() == null), false)
				.append(this.getId(), other.getId()).toComparison();
	}

	@Override
	public int hashCode() {
		return this.id != null ? this.id.hashCode() : super.hashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString())
				.append("id", this.getId()).toString();
	}
}
