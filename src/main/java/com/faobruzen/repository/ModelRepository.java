package com.faobruzen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.faobruzen.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
