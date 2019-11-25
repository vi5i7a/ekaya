package mz.co.abslda.ekayaapi.fwk.jpa.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * @author Ivo Abdul
 */
@MappedSuperclass
public abstract class LifeCycleEntity extends MutableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8595401256778485355L;

	@Column(name = "STATE", nullable = false)
	private int state;

	@Column(name = "ACTIVE", nullable = false, columnDefinition = "CHAR(1)")
	@org.hibernate.annotations.Type(type = "mz.co.abslda.ekayaapi.fwk.jpa.entity.type.OneZeroType")
	private boolean active;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString())
				.append("active", this.isActive()).append("state", this.getState()).toString();
	}
}