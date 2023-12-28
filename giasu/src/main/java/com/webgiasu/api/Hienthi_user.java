package com.webgiasu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webgiasu.converter.LoptoLopDTO;
import com.webgiasu.dto.LopDTO;
import com.webgiasu.dto.NoticeDTO;
import com.webgiasu.entity.LopPHEntity;
import com.webgiasu.entity.LopSVEntity;
import com.webgiasu.pageOutput.pageLop;
import com.webgiasu.repository.LopPHRepo;
import com.webgiasu.repository.LopSVRepo;
import com.webgiasu.service.impl.ShowListService;

@RestController
public class Hienthi_user {
	@Autowired
	private ShowListService show;
	@Autowired 
	private LopSVRepo LopSVRepo;
	@Autowired 
	private LopPHRepo LopPHRepo;
	@Autowired 
	private LoptoLopDTO LoptoLopDTO;
	@Autowired
	private LoptoLopDTO convert;
	@GetMapping("/tt-chi-tiet-lop-sv")
	public LopDTO ttlopsv(@RequestParam(name="id_lop") Long id_lop) {
			LopSVEntity lopSVEntity=LopSVRepo.findOne(id_lop);
			if(lopSVEntity!=null) {
			return LoptoLopDTO.toDTO(lopSVEntity);
			}else {
				return null;
			}
	}
	
	
	@GetMapping("/tt-chi-tiet-lop-ph")
	public LopDTO ttlopph(@RequestParam(name="id_lop") Long id_lop)
	{
		LopPHEntity lopPHEntity=LopPHRepo.findOne(id_lop);
		if(lopPHEntity!=null)
		return LoptoLopDTO.toDTO(lopPHEntity);
		else return null;
	}
	
	@GetMapping("/danh-sach-tb")
	public List<NoticeDTO> dstb(@RequestParam(name="id_user") Long id_user) {
		return show.dstb(id_user);
	}
	

	@GetMapping("/danh-sach-lop-sv")
	public pageLop<LopDTO> dslopsv(@RequestParam(name="page") int page,
									@RequestParam(name="lop",required=false) String trinhdo,
									@RequestParam(name="monday",required=false) String monday,
									@RequestParam(name="diadiem",required=false) String diadiem,
									@RequestParam(name="thoigian",required=false) String thoigian){
		pageLop<LopDTO> result=new pageLop<>();
		result.setPage(page);
		Page<LopSVEntity> outpage=show.dslopsv(page, trinhdo, monday, diadiem, thoigian);
		result.setTotalPage(outpage.getTotalPages());
		List<LopDTO> dsdto=new ArrayList<>();             
		for(LopSVEntity x:outpage) {
			LopDTO tem= new LopDTO();
			tem=convert.toDTO(x);
			dsdto.add(tem);
		}
		result.setDs(dsdto);
		return result;
	}
	
	@GetMapping("/danh-sach-lop-ph")
	public pageLop<LopDTO> dslopph(@RequestParam(name="page") int page,
									@RequestParam(name="lop",required=false) String trinhdo,
									@RequestParam(name="monday",required=false) String monday,
									@RequestParam(name="diadiem",required=false) String diadiem,
									@RequestParam(name="thoigian",required=false) String thoigian){
		pageLop<LopDTO> result=new pageLop<>();
		result.setPage(page);
		Page<LopPHEntity> outpage=show.dslopph(page, trinhdo, monday, diadiem, thoigian);
		result.setTotalPage(outpage.getTotalPages());
		List<LopDTO> dsdto=new ArrayList<>();             
		for(LopPHEntity x:outpage) {
			LopDTO tem= new LopDTO();
			tem=convert.toDTO(x);
			dsdto.add(tem);
		}
		result.setDs(dsdto);
		return result;
	}
}
