package mz.co.abslda.ekayaapi.core.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mz.co.abslda.ekayaapi.core.citizen.entity.CitizenEntity;
import mz.co.abslda.ekayaapi.core.citizen.service.ICitizenService;
import mz.co.abslda.ekayaapi.fwk.event.ResourceCreatedEvent;

@RestController
@RequestMapping("cidadaos")
public class CitizenResource {
	
	@Autowired
	private ICitizenService citizenService;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@GetMapping
	public List<CitizenEntity> getList() {
		
		return citizenService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<CitizenEntity> create(@Valid @RequestBody CitizenEntity citizen,
			HttpServletResponse response) {
		citizenService.create(citizen);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(this, response, citizen.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(citizen);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CitizenEntity> getDocumentTypeById(@PathVariable Long id) {
		Optional<CitizenEntity> citizen = citizenService.findById(id);

		if (!citizen.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(citizen.get());
	}
}