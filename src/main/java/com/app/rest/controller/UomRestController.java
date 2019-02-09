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

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	
	@Autowired
	private IUomService service;
	
	//1.Converting to XML/JSON Format All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response=null;
		List<Uom> uom=service.getAllUoms();
		if(uom!=null) {
			response=new ResponseEntity<List<Uom>>(uom, HttpStatus.OK);
		}else {
			response=new ResponseEntity<String>("No Data Available",HttpStatus.OK);
		}
		return response;
	}
	
	//2.Converting to XMl/JSON format One Record
	@GetMapping("/get/{id}")
	public ResponseEntity<Uom> getOne(@PathVariable Integer id){
		Uom uom=service.getUomById(id);
		ResponseEntity<Uom> response=new ResponseEntity<Uom>(uom,HttpStatus.OK);
		return response;
	}
	//3.Delete One Record From DB
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteOne(@PathVariable Integer id){
			ResponseEntity<String> response=null;
			try {
			service.deleteUom(id);
			response=new ResponseEntity<String>("UOM '"+id+"' deleted",HttpStatus.OK);
			}catch (Exception e) {
				response=new ResponseEntity<String>("UOM '"+id+"' not found",HttpStatus.BAD_REQUEST);
			}
			return response;
		}
		//4.save data using rest
		@PostMapping("/save")
		public ResponseEntity<String> saveData(@RequestBody Uom uom){
			int uid=service.saveUom(uom);
			String body="saved successfully with id:"+uid;
			return new ResponseEntity<>(body,HttpStatus.OK);
		}
		//5.updating data using rest
		@PutMapping("/update")
		public ResponseEntity<String> updateData(@RequestBody Uom uom){
			try {
			service.updateUom(uom);
			String body="updated successfully";
			return new ResponseEntity<>(body,HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>("data not found",HttpStatus.BAD_REQUEST);
			}
		}
			

	
	
	

}
