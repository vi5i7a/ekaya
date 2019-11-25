package mz.co.abslda.ekayaapi.core.document.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import mz.co.abslda.ekayaapi.fwk.jpa.entity.CreatableEntity;
/**
 * @author Ivo Abdul
 */
@Entity
@Table(name = "document_type")
public class DocumentTypeEntity extends CreatableEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5005970815645821047L;

	@NotNull
	@Size(min = 3, max = 20)
	private String code;
	
	@NotNull
	@Size(min = 3, max = 20)
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
