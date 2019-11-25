package mz.co.abslda.ekayaapi.core.residence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.abslda.ekayaapi.core.party.entity.PartyEntity;
import mz.co.abslda.ekayaapi.core.party.entity.PartyType;
import mz.co.abslda.ekayaapi.core.party.repository.PartyRepository;
import mz.co.abslda.ekayaapi.core.residence.entity.ResidenceEntity;
import mz.co.abslda.ekayaapi.core.residence.repository.ResidenceRepository;

/**
 * @author Ivo Abdul
 */
@Service
public class ResidenceService implements IResidenceService {
	
	@Autowired
	private ResidenceRepository residenceRepository;
	
	@Autowired
	private PartyRepository partyRepository;

	@Override
	public void create(ResidenceEntity residence) {
		PartyEntity party = new PartyEntity();
		party.setType(PartyType.CITIZEN);
		partyRepository.create(party);
		
		residence.setPartyId(party.getId());
		residenceRepository.create(residence);
	}

	@Override
	public List<ResidenceEntity> findAll() {
		return residenceRepository.findAll();
	}

	@Override
	public Optional<ResidenceEntity> findById(Long id) {
		return residenceRepository.findById(id);
	}
}