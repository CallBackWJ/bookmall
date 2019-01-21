package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CategoryDao;
import com.douzon.bookmall.vo.CategoryVo;



public class CategoryDaoTest {
	public static void test() {
		// TODO Auto-generated method stub
		
		insertTest("소설");
		insertTest("경제");
		insertTest("컴퓨터");
		
		
		getListTest();
	}
	
	
	public static void insertTest(String classification)
	{
		CategoryVo categoryVo=new CategoryVo();
		categoryVo.setClassification(classification);
		
		new CategoryDao().insert(categoryVo);
	}
	
	public static void getListTest()
	{
		List<CategoryVo> list=new CategoryDao().getList();
		System.out.println("=================CategoryDaoTest================");
		for(CategoryVo b:list)
		{
			System.out.println(b.toString());
			
		}
	}

}
