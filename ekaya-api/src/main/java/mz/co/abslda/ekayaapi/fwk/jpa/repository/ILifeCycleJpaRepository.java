package mz.co.abslda.ekayaapi.fwk.jpa.repository;

import java.io.Serializable;
import java.time.LocalDateTime;

import mz.co.abslda.ekayaapi.fwk.jpa.entity.LifeCycleEntity;
import mz.co.abslda.ekayaapi.fwk.jpa.util.LifeCycleState;


/**
 * @author Ivo Abdul
 *
 * @param <T>
 * @param <ID>
 */
public interface ILifeCycleJpaRepository<T extends LifeCycleEntity, ID extends Serializable>
		extends IMutableJpaRepository<T, ID> {

	@Override
	default <S extends T> S update(S entity) {	
		
		if (entity.getId() != null) {
			return updateEntity(entity);
		}

		return create(entity);
	}

	@Override
	default <S extends T> S create(S entity) {
		entity.setActive(LifeCycleState.ACTIVE.isActive());
		entity.setState(LifeCycleState.ACTIVE.getState());

		return createEntity(entity);
	}

	default T inactivate(T entity) {
		return lifecycle(entity, LifeCycleState.INACTIVE);
	}

	default T activate(T entity) {
		return lifecycle(entity, LifeCycleState.ACTIVE);
	}

	default T block(T entity) {
		return lifecycle(entity, LifeCycleState.BLOCKED);
	}

	default T banish(T entity) {
		return lifecycle(entity, LifeCycleState.BANNED);
	}
	
	default T remove(T entity) {
		return lifecycle(entity, LifeCycleState.DELETED);
	}

	default T lifecycle(final T entity, final LifeCycleState lifeCycleState) {

		@SuppressWarnings("unchecked")
		T reference = findByPrimaryKey((ID) entity.getId());
		reference.setActive(lifeCycleState.isActive());
		reference.setState(lifeCycleState.getState());
		reference.setModifiedDate(LocalDateTime.now());

		return save(reference);
	}
}