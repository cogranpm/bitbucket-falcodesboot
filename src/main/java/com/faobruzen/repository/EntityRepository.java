package com.faobruzen.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.faobruzen.entity.Relation;

public interface EntityRepository extends  PagingAndSortingRepository<Relation, Long>{

}
