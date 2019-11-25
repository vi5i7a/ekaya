package mz.co.abslda.ekayaapi.core.residence.service;

import java.util.List;
import java.util.Optional;

import mz.co.abslda.ekayaapi.core.residence.entity.ResidenceEntity;

/**
 * @author Ivo Abdul
 */
public interface IResidenceService {
	
	public void create(ResidenceEntity residence);

	public List<ResidenceEntity> findAll();

	public Optional<ResidenceEntity> findById(Long id);
}