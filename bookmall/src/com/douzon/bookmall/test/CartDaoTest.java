package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CartVo;
import com.douzon.bookmall.vo.MemberVo;

public class CartDaoTest {
	public static void test() {
		// TODO Auto-generated method stub
		
		insertTest(1,1,1);
		insertTest(2,2,2);

		
		getListTest();
		
	}
	
	
	public static void insertTest(long count,long member, long book)
	{
		CartVo cartVo=new CartVo();
		MemberVo m=new MemberVo();
		m.setNo(member);
		BookVo b=new BookVo();
		b.setNo(book);
		cartVo.setCount(count);
		cartVo.setMember(m);
		cartVo.setBook(b);

		new CartDao().insert(cartVo);
	}
	
	public static void getListTest()
	{
		List<CartVo> list=new CartDao().getList();
		System.out.println("=================CartDaoTest================");
		for(CartVo b:list)
		{
			System.out.println(b.toString());
			
		}
	}
}
