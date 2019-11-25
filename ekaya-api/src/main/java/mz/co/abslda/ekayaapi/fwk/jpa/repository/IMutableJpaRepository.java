package mz.co.abslda.ekayaapi.fwk.jpa.repository;

import java.io.Serializable;
import java.time.LocalDateTime;

import mz.co.abslda.ekayaapi.fwk.jpa.entity.MutableEntity;


/** 
 * @author Ivo Abdul
 *
 * @param <T>
 * @param <ID>
 */
public interface IMutableJpaRepository<T extends MutableEntity, ID extends Serializable>
		extends ICreatableJpaRepository<T, ID> {

	default <S extends T> S update(S entity) {
		return updateEntity(entity);
	}
	
	default <S extends T> S updateEntity(S entity) {
		
		if (entity.getId() != null) {
			entity.setModifiedDate(LocalDateTime.now());
			return save(entity);
		}

		return createEntity(entity);
	}
}