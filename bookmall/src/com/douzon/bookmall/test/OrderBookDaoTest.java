package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.dao.OrderBookDao;
import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CartVo;
import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class OrderBookDaoTest {
	private static long testOrder=1;
	public static void test(){
		// TODO Auto-generated method stub
	
		
		cartToOrder(testOrder);
		getListTest(testOrder);
	}
	
	
	public static void insertTest(long order_no,long book_no,long count)
	{
		OrderBookVo orderBookVo=new OrderBookVo();
		OrderVo o=new OrderVo();
		o.setNo(order_no);
		BookVo b=new BookVo();
		b.setNo(book_no);
		
		orderBookVo.setCount(count);
		orderBookVo.setBook(b);
		orderBookVo.setOrder(o);
		
		new OrderBookDao().insert(orderBookVo);
	}
	public static void cartToOrder(long order_no)
	{
		List<CartVo> list=new CartDao().getList();
		for(CartVo c:list)
		{
			insertTest(order_no, c.getBook().getNo(), c.getCount());
		}
		
		
	}
	
	
	public static void getListTest(long no)
	{
		List<OrderBookVo> list=new OrderBookDao().getList(no);
		System.out.println("=================OrderBookDaoTest================");
		for(OrderBookVo b:list)
		{
			System.out.println(b.toString());
			
		}
	}
}
