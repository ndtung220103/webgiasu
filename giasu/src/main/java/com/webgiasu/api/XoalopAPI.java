package com.webgiasu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webgiasu.service.impl.ThemXoaLopAdmin;

@RestController
public class XoalopAPI {
	
	@Autowired
	private ThemXoaLopAdmin xoa;

	@DeleteMapping("/xoa-lop-sv")
	public String deleteLopsv(@RequestParam(name="id_lop") Long id_lop) {
		return xoa.xoalopsv(id_lop);
	}
	
	@DeleteMapping("/xoa-lop-ph")
	public String deleteLopph(@RequestParam(name="id_lop") Long id_lop) {
		return xoa.xoalopph(id_lop);
	}
	
}
