package com.jsonexample.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.jsonexample.domain.Student;

@Path("student")
public class StudentResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("searchStudent")
public Student getStudent(@QueryParam("sid")Integer studentId){
	if(studentId!=null&&studentId==101){
		Student student=new Student();
		student.setMobile("99998888");
		student.setStudentId(101);
		student.setStudentName("Sushant");
		return student;
	}else{
		return null;
	}
}

}
