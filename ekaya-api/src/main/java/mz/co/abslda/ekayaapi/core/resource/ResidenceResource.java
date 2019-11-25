package mz.co.abslda.ekayaapi.core.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mz.co.abslda.ekayaapi.core.residence.entity.ResidenceEntity;
import mz.co.abslda.ekayaapi.core.residence.service.IResidenceService;
import mz.co.abslda.ekayaapi.fwk.event.ResourceCreatedEvent;

/**
 * @author Ivo Abdul
 */
@RestController
@RequestMapping("residencias")
public class ResidenceResource {
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Autowired
	private IResidenceService residenceService;
	
	@GetMapping
	public List<ResidenceEntity> getList() {
		return residenceService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<ResidenceEntity> create(@Valid @RequestBody ResidenceEntity residence,
			HttpServletResponse response) {
		residenceService.create(residence);

		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(this, response, residence.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(residence);
	}
}