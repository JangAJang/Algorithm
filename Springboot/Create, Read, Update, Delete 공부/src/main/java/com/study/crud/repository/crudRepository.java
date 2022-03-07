package com.study.crud.repository;

import com.study.crud.entity.Crud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface crudRepository extends JpaRepository<Crud, Integer> {
    Page<Crud> findByTitleContaining(String searchKeyword, Pageable pageable);
}
