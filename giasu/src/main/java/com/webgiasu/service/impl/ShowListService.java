package com.webgiasu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webgiasu.converter.LoptoLopDTO;
import com.webgiasu.dto.NoticeDTO;
import com.webgiasu.entity.LopPHEntity;
import com.webgiasu.entity.LopSVEntity;
import com.webgiasu.entity.NoticeEntity;
import com.webgiasu.repository.LopDKPHRepo;
import com.webgiasu.repository.LopDKSVRepo;
import com.webgiasu.repository.LopPHRepo;
import com.webgiasu.repository.LopSVRepo;
import com.webgiasu.repository.NoticeRepo;
import com.webgiasu.service.IShowList;



@Service
public class ShowListService implements IShowList {

	@Autowired
	private NoticeRepo noticerepo;
	@Autowired
	private LopSVRepo lopsvrepo;
	@Autowired
	private LopPHRepo lopphrepo;
	@Autowired
	private LopDKSVRepo svdkrepo;
	@Autowired
	private LopDKPHRepo phdkrepo;
	
	@Autowired
	private LoptoLopDTO convert;
	
	@Override
	public List<NoticeDTO> dstb(Long id_user) {
		List<NoticeEntity> notice=noticerepo.findallnotice(id_user);
		List<NoticeDTO> dto=new ArrayList<>();
		for(NoticeEntity e: notice) {
			NoticeDTO tem=new NoticeDTO();
			tem.setContent(e.getContent());
			tem.setCreatedDate(e.getCreateDate());
			dto.add(tem);
		}
		return dto;
	}

	@Override
	public Page<LopSVEntity> dslopsv(int page, String trinhdo, String monday,String diadiem,String thoigian) { // lấy ra một danh sách lớp đã convert ra dto và phân trang
		Page<LopSVEntity> dsLop;//lấy về là entity
		Pageable pageable =new PageRequest(page-1, 2);
		Boolean status=true;
		if(thoigian==null) {
			if(trinhdo==null&&monday==null&&diadiem==null) {
				dsLop=lopsvrepo.findByStatus(status, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem==null) {
				dsLop=lopsvrepo.findByTrinhdoAndStatus(trinhdo, status, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem==null) {
				dsLop=lopsvrepo.findByMondayAndStatus(monday, status, pageable);
			}else if(trinhdo==null&&monday==null&&diadiem!=null) {
				dsLop=lopsvrepo.findByDiadiemAndStatus(diadiem, status, pageable);
			}else if(trinhdo!=null&&monday!=null&&diadiem==null) {
				dsLop=lopsvrepo.findByTrinhdoAndMondayAndStatus(trinhdo, monday, status, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem!=null) {
				dsLop=lopsvrepo.findByMondayAndDiadiemAndStatus(monday, diadiem, status, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem!=null) {
				dsLop=lopsvrepo.findByTrinhdoAndDiadiemAndStatus(trinhdo, diadiem, status, pageable);
			}else {
				dsLop=lopsvrepo.findByTrinhdoAndMondayAndDiadiemAndStatus(trinhdo, monday, diadiem, status, pageable);
			}
		}else {
			if(trinhdo==null&&monday==null&&diadiem==null) {
				dsLop=lopsvrepo.find1(status, thoigian, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem==null) {
				dsLop=lopsvrepo.find2(trinhdo, status, thoigian, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem==null) {
				dsLop=lopsvrepo.find3(monday, status, thoigian, pageable);
			}else if(trinhdo==null&&monday==null&&diadiem!=null) {
				dsLop=lopsvrepo.find4(diadiem, status, thoigian, pageable);
			}else if(trinhdo!=null&&monday!=null&&diadiem==null) {
				dsLop=lopsvrepo.find5(trinhdo, monday, status, thoigian, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem!=null) {
				dsLop=lopsvrepo.find6(monday, diadiem, status, thoigian, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem!=null) {
				dsLop=lopsvrepo.find7(trinhdo, diadiem, status, thoigian, pageable);
			}else {
				dsLop=lopsvrepo.find8(trinhdo, monday, diadiem, status, thoigian, pageable);
			}
		}
		return dsLop;
	}

	@Override
	public Page<LopPHEntity> dslopph(int page, String trinhdo, String monday, String diadiem, String thoigian) {
		Page<LopPHEntity> dsLop;//lấy về là entity
		Pageable pageable =new PageRequest(page-1, 2);
		Boolean status=true;
		if(thoigian==null) {
			if(trinhdo==null&&monday==null&&diadiem==null) {
				dsLop=lopphrepo.findByStatus(status, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem==null) {
				dsLop=lopphrepo.findByTrinhdoAndStatus(trinhdo, status, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem==null) {
				dsLop=lopphrepo.findByMondayAndStatus(monday, status, pageable);
			}else if(trinhdo==null&&monday==null&&diadiem!=null) {
				dsLop=lopphrepo.findByDiadiemAndStatus(diadiem, status, pageable);
			}else if(trinhdo!=null&&monday!=null&&diadiem==null) {
				dsLop=lopphrepo.findByTrinhdoAndMondayAndStatus(trinhdo, monday, status, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem!=null) {
				dsLop=lopphrepo.findByMondayAndDiadiemAndStatus(monday, diadiem, status, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem!=null) {
				dsLop=lopphrepo.findByTrinhdoAndDiadiemAndStatus(trinhdo, diadiem, status, pageable);
			}else {
				dsLop=lopphrepo.findByTrinhdoAndMondayAndDiadiemAndStatus(trinhdo, monday, diadiem, status, pageable);
			}
		}else {
			if(trinhdo==null&&monday==null&&diadiem==null) {
				dsLop=lopphrepo.find1(status, thoigian, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem==null) {
				dsLop=lopphrepo.find2(trinhdo, status, thoigian, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem==null) {
				dsLop=lopphrepo.find3(monday, status, thoigian, pageable);
			}else if(trinhdo==null&&monday==null&&diadiem!=null) {
				dsLop=lopphrepo.find4(diadiem, status, thoigian, pageable);
			}else if(trinhdo!=null&&monday!=null&&diadiem==null) {
				dsLop=lopphrepo.find5(trinhdo, monday, status, thoigian, pageable);
			}else if(trinhdo==null&&monday!=null&&diadiem!=null) {
				dsLop=lopphrepo.find6(monday, diadiem, status, thoigian, pageable);
			}else if(trinhdo!=null&&monday==null&&diadiem!=null) {
				dsLop=lopphrepo.find7(trinhdo, diadiem, status, thoigian, pageable);
			}else {
				dsLop=lopphrepo.find8(trinhdo, monday, diadiem, status, thoigian, pageable);
			}
		}
		return dsLop;
	}


}
