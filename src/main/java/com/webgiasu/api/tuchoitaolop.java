package com.webgiasu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webgiasu.dto.NoticeDTO;
import com.webgiasu.service.impl.ThemXoaLopAdmin;

@RestController
public class tuchoitaolop {
	
	@Autowired
	private ThemXoaLopAdmin themXoaLopAdmin;

	@PostMapping("/tb-tu-choi-tao-lop-sv")
	public NoticeDTO tuchoitaolopsv(@RequestParam(name="id_lop") Long id_lop) {
		return themXoaLopAdmin.xoalopsv_bangtam(id_lop);
	}
	
	@PostMapping("/tb-tu-choi-tao-lop-ph")
	public NoticeDTO tuchoitaolopph(@RequestParam(name="id_lop") Long id_lop) {
		return themXoaLopAdmin.xoalopph_bangtam(id_lop);
	}
}
