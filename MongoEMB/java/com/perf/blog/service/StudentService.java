package com.perf.blog.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.perf.blog.constant.Constant;
import com.perf.blog.model.StudentDetails;


@Repository
public class StudentService {

	@Autowired
	private MongoTemplate template;
	
	
	public String save(StudentDetails studentDetails){
		String status = null;
		try {
			if(studentDetails != null){
				template.insert(studentDetails);
				status = Constant.RESPONSE_SUCCESS;
			}
		} catch (Exception e) {
			
		}
		return status;
	}
	
	public List<StudentDetails> listStudent() {
		return template.findAll(StudentDetails.class, Constant.STUDENT_COLLECTION_NAME);
	}
	
	
	public String findById(StudentDetails studentDetails){
		String status = null;
		try {
			template.insert(studentDetails);
		} catch (Exception e) {
		}
		return status;
	}
	
	public String findByName(StudentDetails studentDetails){
		String status = null;
		try {
			template.insert(studentDetails);
		} catch (Exception e) {
		}
		return status;
	}
	
	public void delete(StudentDetails studentDetails){
		try {
			template.remove(studentDetails);
		} catch (Exception e) {
			System.out.println("Error occured while deleting");
		}
	}
	
	public String upsert(StudentDetails studentDetails){
		String status = null;
		try {
			template.insert(studentDetails);
		} catch (Exception e) {
		}
		return status;
	}
	
	public List<StudentDetails> getList(String studentId) {
		Iterator<StudentDetails> itr = this.listStudent().iterator();
		while(itr.hasNext()){
			StudentDetails details = itr.next();
			if(details.getId().equals(Long.valueOf(studentId))){
				this.delete(details);
			}
		}
		return this.listStudent();
	}
	
	public boolean checkCollectionExist(){
		if(!template.collectionExists(StudentDetails.class)){
			template.createCollection(StudentDetails.class);
		}
		return true;
	}
}
