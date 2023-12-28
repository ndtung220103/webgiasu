package com.webgiasu.api;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webgiasu.converter.LopdktoLopDKDTO;
import com.webgiasu.converter.LoptoLopDTO;
import com.webgiasu.dto.LopDKDTO;
import com.webgiasu.dto.LopDTO;
import com.webgiasu.entity.LopDKPHEntity;
import com.webgiasu.entity.LopDKSVEntity;
import com.webgiasu.entity.LopPHEntity;
import com.webgiasu.entity.LopSVEntity;
import com.webgiasu.pageOutput.pageLop;
import com.webgiasu.repository.LopDKPHRepo;
import com.webgiasu.repository.LopDKSVRepo;
import com.webgiasu.repository.LopPHRepo;
import com.webgiasu.repository.LopSVRepo;

@RestController
public class hienthi_admin {

	@Autowired 
	private LopDKPHRepo LopDKPHRepo;
	@Autowired 
	private LopPHRepo LopPHRepo;
	@Autowired 
	private LopSVRepo LopSVRepo;
	@Autowired 
	private LopDKSVRepo LopDKSVRepo;
	@Autowired
	private LopdktoLopDKDTO convert;
	@Autowired
	private LoptoLopDTO convert2;
	
	@GetMapping("/ds-lop-dk-ph")
	public pageLop<LopDKDTO> dslopdkph(@RequestParam(name="page") int page){
		Pageable pageable=new PageRequest(page-1, 2);
		Page<LopDKPHEntity> pageout=LopDKPHRepo.findsort(pageable);
		pageLop<LopDKDTO> result=new pageLop<>();
		result.setPage(page);
		result.setTotalPage(pageout.getTotalPages());
		List<LopDKDTO> dsdto=new ArrayList<>();             
		for(LopDKPHEntity x:pageout) {
			LopDKDTO tem= new LopDKDTO();
			tem=convert.toDTO(x);
			dsdto.add(tem);
		}
		result.setDs(dsdto);
		return result;
	}
	
	@GetMapping("/ds-lop-dk-sv")
	public pageLop<LopDKDTO> dslopdksv(@RequestParam(name="page") int page){
		Pageable pageable=new PageRequest(page-1, 2);
		Page<LopDKSVEntity> pageout=LopDKSVRepo.findsort(pageable);
		pageLop<LopDKDTO> result=new pageLop<>();
		result.setPage(page);
		result.setTotalPage(pageout.getTotalPages());
		List<LopDKDTO> dsdto=new ArrayList<>();             
		for(LopDKSVEntity x:pageout) {
			LopDKDTO tem= new LopDKDTO();
			tem=convert.toDTO(x);
			dsdto.add(tem);
		}
		result.setDs(dsdto);
		return result;
	}
	
	@GetMapping("/admin/ds-lop-ph")
	public pageLop<LopDTO> dslopph(@RequestParam(name="page") int page){
		Pageable pageable=new PageRequest(page-1, 2);
		Page<LopPHEntity> pageout=LopPHRepo.findAll(pageable);
		pageLop<LopDTO> result=new pageLop<>();
		result.setPage(page);
		result.setTotalPage(pageout.getTotalPages());
		List<LopDTO> dsdto=new ArrayList<>();             
		for(LopPHEntity x:pageout) {
			LopDTO tem= new LopDTO();
			tem=convert2.toDTO(x);
			dsdto.add(tem);
		}
		result.setDs(dsdto);
		return result;
	}
	
	@GetMapping("/admin/ds-lop-sv")
	public pageLop<LopDTO> dslopsv(@RequestParam(name="page") int page){
		Pageable pageable=new PageRequest(page-1, 2);
		Page<LopSVEntity> pageout=LopSVRepo.findAll(pageable);
		pageLop<LopDTO> result=new pageLop<>();
		result.setPage(page);
		result.setTotalPage(pageout.getTotalPages());
		List<LopDTO> dsdto=new ArrayList<>();             
		for(LopSVEntity x:pageout) {
			LopDTO tem= new LopDTO();
			tem=convert2.toDTO(x);
			dsdto.add(tem);
		}
		result.setDs(dsdto);
		return result;
	}
}
