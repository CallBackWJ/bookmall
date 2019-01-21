package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.MemberDao;
import com.douzon.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void test() {
		// TODO Auto-generated method stub
		
		insertTest("최원진","010-2772-1491","1jin94@naver.com","1234");
		insertTest("심재근","010-1234-5678","jeg@naver.com","5678");
		
		
		
		getListTest();
	}
	
	
	public static void insertTest(String name,String phone, String email, String password)
	{
		MemberVo memberVo=new MemberVo();
		memberVo.setName(name);
		memberVo.setPhone(phone);
		memberVo.setEmail(email);
		memberVo.setPassword(password);
		
		new MemberDao().insert(memberVo);
	}
	
	public static void getListTest()
	{
		List<MemberVo> list=new MemberDao().getList();
		System.out.println("=================MemberDaoTest================");
		for(MemberVo b:list)
		{
			System.out.println(b.toString());
			
		}
	}
}
