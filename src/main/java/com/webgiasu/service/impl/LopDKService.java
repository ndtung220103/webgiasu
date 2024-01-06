package com.webgiasu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webgiasu.dto.LopDKDTO;
import com.webgiasu.entity.LopDKPHEntity;
import com.webgiasu.entity.LopDKSVEntity;
import com.webgiasu.entity.UserEntity;
import com.webgiasu.repository.LopDKPHRepo;
import com.webgiasu.repository.LopDKSVRepo;
import com.webgiasu.repository.UserRepo;
import com.webgiasu.service.ILopDKService;


@Service
public class LopDKService implements ILopDKService {
	
	@Autowired
	private LopDKPHRepo phrepo;
	
	@Autowired
	private  UserRepo urepo;
	
	@Autowired
	private LopDKSVRepo svrepo;

	@Override
	public LopDKDTO saveph(LopDKDTO ttlop) {  // trả về tt lóp nhưng chứa ID
		LopDKPHEntity phDkEntity =new LopDKPHEntity();
		phDkEntity.setHinhthuc(ttlop.getHinhthuc());;
		phDkEntity.setMonday(ttlop.getMonday());
		phDkEntity.setMucluong(ttlop.getMucluong());
		phDkEntity.setDiadiem(ttlop.getDiadiem());
		phDkEntity.setThoigian(ttlop.getThoigian());
		phDkEntity.setTrinhdo(ttlop.getTrinhdo());
		phDkEntity.setTtkhac(ttlop.getTtkhac());
		phDkEntity.setStatus(ttlop.getStatus());
		
		//lưu đối tượng người tạo
		
	    UserEntity nguoitao=urepo.findOne(ttlop.getId_Nguoitao());
		phDkEntity.setPHDK(nguoitao);
        //luu vào DB
		phDkEntity=phrepo.save(phDkEntity);
		ttlop.setId(phDkEntity.getId());
		ttlop.setCreateDate(phDkEntity.getCreateDate());
		return ttlop;
	}

	@Override
	public LopDKDTO savesv(LopDKDTO ttlop) {
		LopDKSVEntity svDkEntity =new LopDKSVEntity();
		svDkEntity.setHinhthuc(ttlop.getHinhthuc());;
		svDkEntity.setMonday(ttlop.getMonday());
		svDkEntity.setMucluong(ttlop.getMucluong());
		svDkEntity.setDiadiem(ttlop.getDiadiem());
		svDkEntity.setThoigian(ttlop.getThoigian());
		svDkEntity.setTrinhdo(ttlop.getTrinhdo());
		svDkEntity.setTtkhac(ttlop.getTtkhac());
		svDkEntity.setStatus(ttlop.getStatus());
		
		
	    UserEntity nguoitao=urepo.findOne(ttlop.getId_Nguoitao());
		svDkEntity.setSVDK(nguoitao);
    
		svDkEntity=svrepo.save(svDkEntity);
		ttlop.setId(svDkEntity.getId());
		ttlop.setCreateDate(svDkEntity.getCreateDate());
		return ttlop;
	}

}
