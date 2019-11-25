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

import mz.co.abslda.ekayaapi.core.document.entity.DocumentTypeEntity;
import mz.co.abslda.ekayaapi.core.document.repository.DocumentTypeRepository;
import mz.co.abslda.ekayaapi.fwk.event.ResourceCreatedEvent;

@RestController
@RequestMapping("tiposDeDocumentos")
public class DocumentTypeResource {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@GetMapping
	public List<DocumentTypeEntity> getList() {
		return documentTypeRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<DocumentTypeEntity> create(@Valid @RequestBody DocumentTypeEntity documentType,
			HttpServletResponse response) {
		documentTypeRepository.create(documentType);
		applicationEventPublisher.publishEvent(new ResourceCreatedEvent(this, response, documentType.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(documentType);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DocumentTypeEntity> getDocumentTypeById(@PathVariable Long id) {
		Optional<DocumentTypeEntity> documentType = documentTypeRepository.findById(id);

		if (!documentType.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(documentType.get());
	}
}
