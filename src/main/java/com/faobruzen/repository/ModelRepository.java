package com.faobruzen.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.faobruzen.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Serializable>{

}
