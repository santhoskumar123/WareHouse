package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	@RequestMapping("/all")
	public String showDocuments(ModelMap map) {
		//show all uploaded docs
				List<Object[]> list=service.getDocsIdAndNames();
				map.addAttribute("list",list);

		return "Documents";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadDoc(@RequestParam("fileOb") CommonsMultipartFile file,ModelMap map) {
		if(file!=null) { 
			//convert CMF data to Model class obj  
			Document  doc=new Document();    
			//doc.setFileId(fileId); auto generated  
			doc.setFileName(file.getOriginalFilename());   
			doc.setFileData(file.getBytes());   
			int id=service.saveDocument(doc); 
			map.addAttribute("message", "Saved with Id:"+id);   
		}
		//show all uploaded docs
				List<Object[]> list=service.getDocsIdAndNames();
				map.addAttribute("list",list);

			return "Documents";
		}
	@RequestMapping("/download")
	public void downloadDoc(@RequestParam Integer docId,HttpServletResponse resp) {
		Document ob=service.getDocumentById(docId);
		//add header
		resp.addHeader("Content-Disposition","attachment;fileName="+ob.getFileName());
		//addBody
		try {
			FileCopyUtils.copy(ob.getFileData(),resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
