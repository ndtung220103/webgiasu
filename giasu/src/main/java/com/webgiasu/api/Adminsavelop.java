package com.webgiasu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webgiasu.service.impl.ThemXoaLopAdmin;


@RestController
public class Adminsavelop {
	
	@Autowired 
	private ThemXoaLopAdmin save;

	
	@PostMapping("/luu-lop-sv")
	public String luulopsv(@RequestParam(value="id") Long id_lop) {
		return save.savelopsv(id_lop);
	}
	
	@PostMapping("luu-lop-ph")
	public String luulopph(@RequestParam(value="id") Long id_lop) {
		return save.savelopph(id_lop);
	}
	
	
}
