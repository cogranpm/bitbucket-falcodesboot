package com.faobruzen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Entity", schema="APP")
public class Relation {
	
	public Relation()
	{
		
	}
	
	public Relation(String name)
	{
		this.name = name;
	}
	
	@Id
    @GeneratedValue(generator="SEQ_ENTITY")
	@SequenceGenerator(name="SEQ_ENTITY",sequenceName="SEQ_ENTITY")
	private Long entityId;
	
	@Size(max = 30)
	private String name;

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
