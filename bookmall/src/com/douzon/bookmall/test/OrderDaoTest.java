package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.MemberVo;
import com.douzon.bookmall.vo.OrderVo;

public class OrderDaoTest {
	
	private static long TestMember=1;

	public static void test() {
		// TODO Auto-generated method stub
		
		insertTest(48000,"수영구 구영로 777",TestMember);
		
		
		getListTest(TestMember);
	}
	
	
	public static void insertTest(long money,String address,long member)
	{
		OrderVo orderVo=new OrderVo();
		MemberVo m=new MemberVo();
		m.setNo(member);
		orderVo.setMoney(money);
		orderVo.setAddress(address);
		orderVo.setMember(m);
		
		new OrderDao().insert(orderVo);
	}
	public static void getListTest(long no)
	{
		List<OrderVo> list=new OrderDao().getList(no);
		System.out.println("=================OrderDaoTest================");
		for(OrderVo b:list)
		{
			System.out.println(b.toString());
			
		}
	}
	
}
