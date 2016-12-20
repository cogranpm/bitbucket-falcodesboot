package com.faobruzen.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.faobruzen.entity.Model;

public interface ModelRepository extends PagingAndSortingRepository<Model, Long> {

}
