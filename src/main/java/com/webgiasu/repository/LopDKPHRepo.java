package com.webgiasu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webgiasu.entity.LopDKPHEntity;

@Repository
public interface LopDKPHRepo extends JpaRepository<LopDKPHEntity,Long> {

	@Query("SELECT s FROM LopDKPHEntity s ORDER BY s.id DESC")
    Page<LopDKPHEntity> findsort(Pageable pageable);
}
