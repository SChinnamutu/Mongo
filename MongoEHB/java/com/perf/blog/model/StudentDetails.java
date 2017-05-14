package com.perf.blog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "studentDetail")
public class StudentDetails implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="pk")
		private int pk;
		
		@Column(name="id")
		private Long id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="age")
		private String age;
		
		@Column(name="address")
		private String address;


		

		public int getPk() {
			return pk;
		}

		public void setPk(int pk) {
			this.pk = pk;
		}

		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}


	    
	
	
}
