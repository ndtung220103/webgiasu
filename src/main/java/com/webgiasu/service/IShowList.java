package com.webgiasu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.webgiasu.dto.NoticeDTO;
import com.webgiasu.entity.LopPHEntity;
import com.webgiasu.entity.LopSVEntity;


public interface IShowList {
	List<NoticeDTO> dstb(Long id_user);
	Page<LopPHEntity> dslopph(int page, String trinhdo, String monday, String diadiem, String thoigian);
	Page<LopSVEntity> dslopsv(int page, String trinhdo, String monday, String diadiem, String thoigian);
}
