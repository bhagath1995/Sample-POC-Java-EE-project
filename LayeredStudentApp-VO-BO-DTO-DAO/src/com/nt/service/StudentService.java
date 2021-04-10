package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	
	public String generateResult(StudentDTO dto)throws Exception{
		int m1,m2,m3,total=0;
		float avg=0.0f;
		String result=null;
		StudentDAO dao=null;
		int count=0;
		StudentBO bo=null;
		//write b.logic to calculate total,avg,result
		m1=dto.getM1();
		m2=dto.getM2();
		m3=dto.getM3();
		total=m1+m2+m3;
		avg=total/3.0f;
		//generate results
		if(m1<35 || m2<35 || m3<35)
			result="fail"+"Total="+total;
		else
			result="pass"+"Total="+total;
		
		//prepare BO having persistable data
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use dAO classes
		dao=new StudentDAO();
		count=dao.insert(bo);
		//Generate result
		if(count==0)
			return bo.getSno()+"   registration Failed::: Result is "+result;
		else
			return bo.getSno()+"   registration Succedded::: Result is "+result;
	}//method
}//class
