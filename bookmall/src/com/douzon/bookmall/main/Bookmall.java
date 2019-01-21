package com.douzon.bookmall.main;

import com.douzon.bookmall.test.BookDaoTest;
import com.douzon.bookmall.test.CartDaoTest;
import com.douzon.bookmall.test.CategoryDaoTest;
import com.douzon.bookmall.test.MemberDaoTest;
import com.douzon.bookmall.test.OrderBookDaoTest;
import com.douzon.bookmall.test.OrderDaoTest;

public class Bookmall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDaoTest.test();
		CategoryDaoTest.test();
		BookDaoTest.test();
		CartDaoTest.test();
		OrderDaoTest.test();
		OrderBookDaoTest.test();
		
	}

}
