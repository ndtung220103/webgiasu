package com.webgiasu.service;

import com.webgiasu.dto.NoticeDTO;

public interface Ithem_xoa_lopAdmin {
	String savelopsv(Long id_lop);
	String savelopph(Long id_lop);
	String xoalopsv(Long id_lop);
	String xoalopph(Long id_lop);
	public NoticeDTO xoalopsv_bangtam(Long id_lop);
	public NoticeDTO xoalopph_bangtam(Long id_lop);
}
