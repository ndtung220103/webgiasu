package com.webgiasu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webgiasu.dto.LopDKDTO;
import com.webgiasu.service.impl.LopDKService;




@RestController
public class DklopAPI {
	
	
	@Autowired
	private  LopDKService lopdk;
	
	
	@PostMapping("/ph-tao-lop")
    public LopDKDTO lphdk(@RequestBody LopDKDTO ttlop) {
		//return ttlop;
           return lopdk.saveph(ttlop) ;
    }
	
	@PostMapping("/sv-tao-lop")
    public LopDKDTO lopsvdk(@RequestBody LopDKDTO ttlop) {
		//return ttlop;
           return lopdk.savesv(ttlop) ;
    }
	
}
