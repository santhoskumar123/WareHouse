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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {
	
	@Autowired
	private IShipmentTypeService service;
	
	
	//1.Converting to XML/JSON All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response=null;
		List<ShipmentType> ship=service.getAllShipmentTypes();
	if(ship!=null&&!ship.isEmpty()) {
		response=new ResponseEntity<List<ShipmentType>>(ship,HttpStatus.OK);	
	}
	else {
		response=new ResponseEntity<String>("No Data Available",HttpStatus.OK);
	}
		return response;
	}
	
	//2.Converting to XML/JSON One Record 
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> response=null;
		ShipmentType ship=service.getShipmantTypeById(id);
		if(ship!=null) {
			response=new ResponseEntity<ShipmentType>(ship,HttpStatus.OK);
		}else {
		response=new ResponseEntity<String>("No Data Available",HttpStatus.OK);	
		}
		return response;
	}
	
	//3.Delete One Record from DB
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable Integer id){
		ResponseEntity<String> response=null;
		try {
		service.deleteShipmentType(id);
		response=new ResponseEntity<String>("ShipmentType '"+id+"' deleted",HttpStatus.OK);
		}catch (Exception e) {
			response=new ResponseEntity<String>("ShipmentType '"+id+"' not deleted",HttpStatus.BAD_REQUEST);
		}
		return response;
		
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody ShipmentType shipmentType){
		int sid=service.saveShipmentType(shipmentType);
		String body="saved successfully with id:"+sid;
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody ShipmentType shipmentType){
		try {
		service.updateShipmentType(shipmentType);
		return new ResponseEntity<String>("updated successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("data not found ",HttpStatus.BAD_REQUEST);
		}
	}
 	
	
}
