package mz.co.abslda.ekayaapi.core.citizen.service;

import java.util.List;
import java.util.Optional;

import mz.co.abslda.ekayaapi.core.citizen.entity.CitizenEntity;

/**
 * @author Ivo Abdul
 */
public interface ICitizenService {
	
	public void create(CitizenEntity person);

	public List<CitizenEntity> findAll();

	public Optional<CitizenEntity> findById(Long id);
}