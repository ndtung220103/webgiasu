package com.webgiasu.repository;



import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webgiasu.entity.LopSVEntity;

@Repository
public interface LopSVRepo extends JpaRepository<LopSVEntity,Long> {
	Page<LopSVEntity> findByStatus(Boolean status, Pageable pageable);
	
	Page<LopSVEntity> findByTrinhdoAndStatus(String trinhdo,Boolean status , Pageable pageable);
	Page<LopSVEntity> findByMondayAndStatus(String monday, Boolean status, Pageable pageable);
	Page<LopSVEntity> findByDiadiemAndStatus(String diadiem, Boolean status, Pageable pageable);
	
	Page<LopSVEntity> findByTrinhdoAndMondayAndStatus(String trinhdo,String monday,Boolean status , Pageable pageable);
	Page<LopSVEntity> findByMondayAndDiadiemAndStatus(String monday,String diadiem, Boolean status, Pageable pageable);
	Page<LopSVEntity> findByTrinhdoAndDiadiemAndStatus(String trinhdo,String diadiem, Boolean status, Pageable pageable);
	
	Page<LopSVEntity> findByTrinhdoAndMondayAndDiadiemAndStatus(String trinhdo,String monday,String diadiem,Boolean status , Pageable pageable);
	
	
	//sql
	
	@Query("SELECT s FROM LopSVEntity s WHERE s.status=?1 AND s.thoigian LIKE %?2% ORDER BY s.createDate DESC")
    Page<LopSVEntity> find1(Boolean status, String thoigian, Pageable pageable);
	
	@Query("SELECT s FROM LopSVEntity s WHERE s.trinhdo=?1 AND s.status=?2 AND s.thoigian LIKE %?3% ORDER BY s.createDate DESC")
	Page<LopSVEntity> find2(String trinhdo,Boolean status ,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopSVEntity s WHERE s.monday=?1 AND s.status=?2 AND s.thoigian LIKE %?3% ORDER BY s.createDate DESC")
	Page<LopSVEntity> find3(String monday, Boolean status,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopSVEntity s WHERE s.diadiem=?1 AND s.status=?2 AND s.thoigian LIKE %?3% ORDER BY s.createDate DESC")
	Page<LopSVEntity> find4(String diadiem, Boolean status, String thoigian,Pageable pageable);
	
	@Query("SELECT s FROM LopSVEntity s WHERE s.trinhdo=?1 AND s.monday=?2 AND s.status=?3 AND s.thoigian LIKE %?4% ORDER BY s.createDate DESC")
	Page<LopSVEntity> find5(String trinhdo,String monday,Boolean status ,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopSVEntity s WHERE s.monday=?1 AND s.diadiem=?2 AND s.status=?3 AND s.thoigian LIKE %?4% ORDER BY s.createDate DESC")
	Page<LopSVEntity> find6(String monday,String diadiem, Boolean status,String thoigian, Pageable pageable);
	@Query("SELECT s FROM LopSVEntity s WHERE s.trinhdo=?1 AND s.diadiem=?2 AND s.status=?3 AND s.thoigian LIKE %?4% ORDER BY s.createDate DESC")
	Page<LopSVEntity> find7(String trinhdo,String diadiem, Boolean status,String thoigian, Pageable pageable);
	
	@Query("SELECT s FROM LopSVEntity s WHERE s.trinhdo=?1 AND s.monday=?2 AND s.diadiem=?3 AND s.status=?4 AND s.thoigian LIKE %?5% ORDER BY s.createDate DESC")
	Page<LopSVEntity> find8(String trinhdo,String monday,String diadiem,Boolean status ,String thoigian, Pageable pageable);
}
