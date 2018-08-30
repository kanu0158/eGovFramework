package com.gms.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.web.domain.MemberDTO;
import com.gms.web.mapper.MemberMapper;
import com.gms.web.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper memberDAO;
	@Override
	public void add(MemberDTO p) {
		System.out.println("p.getssn : "+p.getSsn());
		System.out.println("p.getSsn().substring(0,2)"+ p.getSsn().substring(0,2));
		System.out.println("날짜 : "+new SimpleDateFormat("yyyy").format(new Date()));
		String age = String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())) -1899 - Integer.parseInt(p.getSsn().substring(0,2)));
		System.out.println("age : "+ age);
		String flag = p.getSsn().substring(7, 8);
		System.out.println("flag : " + flag);
		String gender = "";
		switch(flag){
		case "1":
		case "3":
		case "5":
		case "7":
			gender = "남자";
			break;
		case "2":
		case "4":
		case "6":
		case "8":
			gender = "여자";
			break;
		}
		p.setAge(age);
		p.setGender(gender);
		memberDAO.insert(p);
	}

	@Override
	public List<?> list(Map<?, ?> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> search(Map<?, ?> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO retrieve(MemberDTO p) {
		return memberDAO.selectOne(p);
	}

	@Override
	public int count(Map<?, ?> p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modify(MemberDTO p) {
		memberDAO.update(p);
	}

	@Override
	public void remove(MemberDTO p) {
		memberDAO.delete(p);
		
	}

	@Override
	public boolean login(MemberDTO p) {
		System.out.println("service login memberDTO :" +memberDAO.login(p));
		return (memberDAO.login(p)!=null);
	}

}
