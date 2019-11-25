package mz.co.abslda.ekayaapi.fwk.jpa.repository;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.co.abslda.ekayaapi.fwk.jpa.entity.CreatableEntity;


public interface ICreatableJpaRepository<T extends CreatableEntity, ID extends Serializable> extends JpaRepository<T, ID> {

	default <S extends T> S create(S entity) {
		return createEntity(entity);
	}
	
	default <S extends T> S createEntity(S entity) {
		entity.setCreatedDate(LocalDateTime.now());
		return save(entity);
	}

	default T findByPrimaryKey(ID id) {
		return null;
		//return findOne(id);
	}
}