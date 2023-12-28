package com.webgiasu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webgiasu.dto.LopDKDTO;
import com.webgiasu.service.impl.LopDKService;




@RestController
public class DklopAPI {
	
	/* @RequestMapping("/spring/hello/{id}")
public String showHello(@PathVariable(value="id") String id,
                        @RequestParam(value="param1", required=true) String parameter1,
                        @RequestParam(value="param2", required=false) String parameter2) {
     // gia tri cua id duoc su dung o day
        System.out.println("ID : " + id);
        System.out.println("Param 1 : " + param1)
        System.out.println("Param 2 : " + param2);
        return "hello";
}
*/
	
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
