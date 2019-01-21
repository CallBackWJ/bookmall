package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CategoryVo;

public class BookDaoTest {
	public static void test() {
		// TODO Auto-generated method stub
	
		insertTest("용의자x의 헌신",15000,1);
		insertTest("돈되는 부동산",17000,2);
		insertTest("자바의 정석",25000,3);
		getListTest();
	}
	
	
	public static void insertTest(String name,long price, long category)
	{
		BookVo bookVo=new BookVo();
		CategoryVo c=new CategoryVo();
		c.setNo(category);
		bookVo.setName(name);
		bookVo.setPrice(price);
		bookVo.setCategory(c);
		
		new BookDao().insert(bookVo);
	}
	
	public static void getListTest()
	{
		List<BookVo> list=new BookDao().getList();
		
		System.out.println("=================BookDaoTest================");
		for(BookVo b:list)
		{
			System.out.println(b.toString());
			
		}
		
	}
}
