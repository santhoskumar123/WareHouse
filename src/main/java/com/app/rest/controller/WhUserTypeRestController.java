package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whuser")
public class WhUserTypeRestController {
	
	@Autowired
	private IWhUserTypeService service;
	
	//1.Converting to XML/JSON format All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response=null;
		List<WhUserType> whuser=service.getAllWhUserTypes();
		if(whuser!=null&&!whuser.isEmpty()) {
			response=new ResponseEntity<List<WhUserType>>(whuser,HttpStatus.OK);
		}
		else {
			response=new ResponseEntity<String>("No Data Available",HttpStatus.OK);
		}
		
		return response;
		
	}
	
	//2.Convert to XML/JSON One Record
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> response=null;
		WhUserType whuser=service.getWhUserTypeById(id);
		if(whuser!=null) {
			response=new ResponseEntity<WhUserType>(whuser,HttpStatus.OK);
		}else {
			response=new ResponseEntity<String>("No Data Available",HttpStatus.OK);
		}
		return response;
	}
	
	//3.Delete One Record From DB
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable Integer id){
		ResponseEntity<String> response=null;
		try {
		service.deleteWhUserType(id);
		response=new ResponseEntity<String>("WhUserType '"+id+"' deleted",HttpStatus.OK);
		}catch (Exception e) {
			response=new ResponseEntity<String>("WhUserType '"+id+"'  not deleted",HttpStatus.BAD_REQUEST);
		}
		return response;
		
	}
	//4.update operation in rest
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody WhUserType wut){
		int wutId=service.saveWhUserType(wut);
		String body="whUserType ' " +wutId+ " 'saved successfully";
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	//4.update operation in rest
		@PutMapping("/update")
		public ResponseEntity<String> updateData(@RequestBody WhUserType wut){
			ResponseEntity< String> re=null;
			try {
			service.updateWhUserType(wut);
			String body="whUserType updated successfully";
			return new ResponseEntity<String>(body, HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<String>("data not found",HttpStatus.BAD_REQUEST);
			}
		}

}
