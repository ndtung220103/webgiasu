package com.webgiasu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webgiasu.entity.LopPHEntity;

@Repository
public interface LopPHRepo extends JpaRepository<LopPHEntity,Long>{

	Page<LopPHEntity> findByStatus(Boolean status, Pageable pageable);
	
	Page<LopPHEntity> findByTrinhdoAndStatus(String trinhdo,Boolean status , Pageable pageable);
	Page<LopPHEntity> findByMondayAndStatus(String monday, Boolean status, Pageable pageable);
	Page<LopPHEntity> findByDiadiemAndStatus(String diadiem, Boolean status, Pageable pageable);
	
	Page<LopPHEntity> findByTrinhdoAndMondayAndStatus(String trinhdo,String monday,Boolean status , Pageable pageable);
	Page<LopPHEntity> findByMondayAndDiadiemAndStatus(String monday,String diadiem, Boolean status, Pageable pageable);
	Page<LopPHEntity> findByTrinhdoAndDiadiemAndStatus(String trinhdo,String diadiem, Boolean status, Pageable pageable);
	
	Page<LopPHEntity> findByTrinhdoAndMondayAndDiadiemAndStatus(String trinhdo,String monday,String diadiem,Boolean status , Pageable pageable);
	
	
	//sql
	
	@Query("SELECT s FROM LopPHEntity s WHERE s.status=?1 AND s.thoigian LIKE %?2% ORDER BY s.createDate DESC")
    Page<LopPHEntity> find1(Boolean status, String thoigian, Pageable pageable);
	
	@Query("SELECT s FROM LopPHEntity s WHERE s.trinhdo=?1 AND s.status=?2 AND s.thoigian LIKE %?3% ORDER BY s.createDate DESC")
	Page<LopPHEntity> find2(String trinhdo,Boolean status ,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopPHEntity s WHERE s.monday=?1 AND s.status=?2 AND s.thoigian LIKE %?3% ORDER BY s.createDate DESC")
	Page<LopPHEntity> find3(String monday, Boolean status,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopPHEntity s WHERE s.diadiem=?1 AND s.status=?2 AND s.thoigian LIKE %?3% ORDER BY s.createDate DESC")
	Page<LopPHEntity> find4(String diadiem, Boolean status, String thoigian,Pageable pageable);
	
	@Query("SELECT s FROM LopPHEntity s WHERE s.trinhdo=?1 AND s.monday=?2 AND s.status=?3 AND s.thoigian LIKE %?4% ORDER BY s.createDate DESC")
	Page<LopPHEntity> find5(String trinhdo,String monday,Boolean status ,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopPHEntity s WHERE s.monday=?1 AND s.diadiem=?2 AND s.status=?3 AND s.thoigian LIKE %?4% ORDER BY s.createDate DESC")
	Page<LopPHEntity> find6(String monday,String diadiem, Boolean status,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopPHEntity s WHERE s.trinhdo=?1 AND s.diadiem=?2 AND s.status=?3 AND s.thoigian LIKE %?4% ORDER BY s.createDate DESC")
	Page<LopPHEntity> find7(String trinhdo,String diadiem, Boolean status,String thoigian, Pageable pageable);
	
	@Query("SELECT s FROM LopPHEntity s WHERE s.trinhdo=?1 AND s.monday=?2 AND s.diadiem=?3 AND s.status=?4 AND s.thoigian LIKE %?5% ORDER BY s.createDate DESC")
	Page<LopPHEntity> find8(String trinhdo,String monday,String diadiem,Boolean status ,String thoigian, Pageable pageable);
}
