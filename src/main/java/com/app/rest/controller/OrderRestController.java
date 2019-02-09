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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/order")
public class OrderRestController {
	
	@Autowired
	private IOrderMethodService service;
	
	//1.Converting to XML/JSON format All Records
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response=null;
		List<OrderMethod> order=service.getAllOrderMethods();
		if(order!=null&&!order.isEmpty()) {
		response=new ResponseEntity<List<OrderMethod>>(order,HttpStatus.OK);	
		}
		else {
			response=new ResponseEntity<String>("No Data Available",HttpStatus.OK);
		}
		
		return response;
	}
	
	//2.Converting XML/JSON One Record
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> response=null;
		OrderMethod order=service.getOrderMethodById(id);
		if(order!=null) {
			response=new ResponseEntity<OrderMethod>(order,HttpStatus.OK);
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
	        	service.deleteOrdermethod(id);
	        	response=new ResponseEntity<String>("Order '"+id+"' deleted",HttpStatus.OK);
	        	}catch (Exception e) {
	        		response=new ResponseEntity<String>("Order '"+id+"' not found",HttpStatus.BAD_REQUEST);
				}
				return response;
			}
	        //4.save record
	        @PostMapping("/save")
	        public ResponseEntity<String> saveData(@RequestBody OrderMethod orderMethod){
	        	int oid=service.saveOrderMethod(orderMethod);
	        	String body="orderMethod '"+oid+"' saved successfully";
	        	return new ResponseEntity<String>(body,HttpStatus.OK);
	        	
	        }
	        @PutMapping("/update")
	        public ResponseEntity<String> updateData(@RequestBody OrderMethod orderMethod){
	        	//ResponseEntity<String> re=null;
	        	try {
	        		service.updateOrderMethod(orderMethod);
	        		return new ResponseEntity<String>("updated successfully",HttpStatus.OK);
	        	}catch(Exception e) {
	        		return new ResponseEntity<String>("data not found",HttpStatus.BAD_REQUEST);
	        	}
	        	
	        }

}
