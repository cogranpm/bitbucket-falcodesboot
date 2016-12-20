package com.faobruzen.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

@Entity
@Table(schema="APP")
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

	public void setModelIdProperty(SimpleLongProperty modelIdProperty) {
		this.modelIdProperty = modelIdProperty;
	}

	@Transient
	public SimpleStringProperty getNameProperty() {
		return nameProperty;
	}

	public void setNameProperty(SimpleStringProperty nameProperty) {
		this.nameProperty = nameProperty;
	}	
	
	@Override
	public String toString() {
		return String.format("Model[ modelId=%d, name=%s", modelIdProperty.get(), nameProperty.get() );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((modelIdProperty == null) ? 0 : 1);
		result = prime * result + ((nameProperty == null) ? 0 : nameProperty.get().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (modelIdProperty == null) {
			if (other.modelIdProperty != null)
				return false;
		} else if (!(modelIdProperty.get() == other.modelIdProperty.get()))
			return false;
		
		return true;
	}


	
	

}
