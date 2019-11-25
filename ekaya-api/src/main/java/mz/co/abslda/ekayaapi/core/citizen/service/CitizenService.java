package mz.co.abslda.ekayaapi.core.citizen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.abslda.ekayaapi.core.citizen.entity.CitizenEntity;
import mz.co.abslda.ekayaapi.core.citizen.repository.CitizenRepository;
import mz.co.abslda.ekayaapi.core.party.entity.PartyEntity;
import mz.co.abslda.ekayaapi.core.party.entity.PartyType;
import mz.co.abslda.ekayaapi.core.party.repository.PartyRepository;

/**
 * @author Ivo Abdul
 */
@Service
public class CitizenService implements ICitizenService {
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private PartyRepository partyRepository;

	@Override
	public void create(final CitizenEntity person) {	
		PartyEntity party = new PartyEntity();
		party.setType(PartyType.CITIZEN);
		partyRepository.create(party);
		
		person.setPartyId(party.getId());
		citizenRepository.create(person);
	}

	@Override
	public List<CitizenEntity> findAll() {
		return citizenRepository.findAll();
	}

	@Override
	public Optional<CitizenEntity> findById(Long id) {
		return citizenRepository.findById(id);
	}
}