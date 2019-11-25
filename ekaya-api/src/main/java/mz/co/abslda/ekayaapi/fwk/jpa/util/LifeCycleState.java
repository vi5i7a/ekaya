package mz.co.abslda.ekayaapi.fwk.jpa.util;

import mz.co.abslda.ekayaapi.fwk.jpa.entity.LifeCycleEntity;

public enum LifeCycleState
{
	ACTIVE(true, 0), INACTIVE(false, 1), DELETED(false, 2), BLOCKED(false, 3), BANNED(false, 4);

	private final boolean active;

	private final int state;

	/**
	 * Constructor.
	 * 
	 * @param active Se activo ou n„o
	 * @param state O estado.
	 */
	private LifeCycleState(final boolean active, final int state)
	{
		this.active = active;
		this.state = state;
	}

	/**
	 * Se esta activo ou n„o.
	 * 
	 * @return Se esta activo ou n„o.
	 */
	public boolean isActive()
	{
		return this.active;
	}

	/**
	 * O estado.
	 * 
	 * @return O estado do objecto.
	 */
	public int getState()
	{
		return this.state;
	}
	
	@Override
	public String toString()
	{
		return "(" + isActive() + "," +  getState() +  ")";
	}

	public static final LifeCycleState valueOf(final LifeCycleEntity entity)
	{
		return (((entity.isActive() == ACTIVE.isActive()) && (entity.getState() == ACTIVE.getState()))   ? ACTIVE
		     : ((entity.isActive() == INACTIVE.isActive()) && (entity.getState() == INACTIVE.getState()) ? INACTIVE
		     : ((entity.isActive() == DELETED.isActive()) && (entity.getState() == DELETED.getState())	 ? DELETED
		     : ((entity.isActive() == BLOCKED.isActive()) && (entity.getState() == BLOCKED.getState())	 ? BLOCKED
			 : BANNED))));
	}
}