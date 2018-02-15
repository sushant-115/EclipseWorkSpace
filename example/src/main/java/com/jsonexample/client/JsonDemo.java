package com.jsonexample.client;

import com.jsonexample.domain.Student;
import com.jsonexample.util.JsonUtil;

public class JsonDemo {
	public JsonDemo(){
		Student student= new Student();
		student.setMobile("99998888");
		student.setStudentId(123);
		student.setStudentName("Sushant");
		String jsonStudent=JsonUtil.convertJavaToJson(student);
		System.out.println(jsonStudent);
		Student std1=JsonUtil.convertJsonToJava(jsonStudent, Student.class);
		System.out.println(std1.getMobile()+""+std1.getStudentName()+""+std1.getStudentId());
				
		
	}

}
