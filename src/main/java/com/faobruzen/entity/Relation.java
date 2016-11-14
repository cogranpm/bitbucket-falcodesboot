package com.faobruzen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Relation {
	
	public Relation()
	{
		
	}
	
	public Relation(String name)
	{
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
