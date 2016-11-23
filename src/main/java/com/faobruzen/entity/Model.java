package com.faobruzen.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

@Entity
@Access(AccessType.PROPERTY)
public class Model {

	/*entity properties 
	private Long modelId;
	private String name;
	*/
	
	/* fx properties */
	private SimpleLongProperty modelIdProperty = new SimpleLongProperty(this, "modelId", 0);
	private SimpleStringProperty nameProperty = new SimpleStringProperty(this, "name", "");
	
	public Model()
	{
		
	}
	
	public Model(String name)
	{
		this.nameProperty.set(name);
	}

	@Column(nullable = false)
	public String getName() {
		return this.nameProperty.get();
	}
	public void setName(String name) {
		this.nameProperty.set(name);
	}

	@javax.persistence.Id
    @GeneratedValue(generator="SEQ_MODEL")
	@SequenceGenerator(name="SEQ_MODEL",sequenceName="SEQ_MODEL")
	@Column(name="ModelID")
	public Long getModelId() {
		return this.modelIdProperty.get();
	}
	public void setModelId(Long modelId) {
		this.modelIdProperty.set(modelId);
	}
	
	@Transient
	public SimpleLongProperty getModelIdProperty() {
		return modelIdProperty;
	}

	@Transient
	public void setModelIdProperty(SimpleLongProperty modelIdProperty) {
		this.modelIdProperty = modelIdProperty;
	}

	@Transient
	public SimpleStringProperty getNameProperty() {
		return nameProperty;
	}

	@Transient
	public void setNameProperty(SimpleStringProperty nameProperty) {
		this.nameProperty = nameProperty;
	}	
	
	@Override
	public String toString() {
		return String.format("Model[ modelId=%d, name=%s", modelIdProperty.get(), nameProperty.get() );
	}

}
