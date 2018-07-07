package com.hp.util;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.EmpEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.FsortEntity;
import com.hp.Entity.HallEntity;
import com.hp.Entity.SaleEntity;
import com.hp.serivce.impl.BroadSerivceImpl;
import com.hp.serivce.impl.EmpSerivceImpl;
import com.hp.serivce.impl.FimlSerivceImpl;
import com.hp.serivce.impl.FsortSerivceImpl;
import com.hp.serivce.impl.HallSerivceImpl;
import com.hp.serivce.impl.ProitSerivceImpl;
import com.hp.serivce.impl.SaleSerivceImpl;
import com.hp.serivce2.BroadSerivce;
import com.hp.serivce2.EmpSerivce;
import com.hp.serivce2.FimlSerivce;
import com.hp.serivce2.FsortSerivce;
import com.hp.serivce2.HallSerivce;
import com.hp.serivce2.ProitSerivce;
import com.hp.serivce2.SaleSerivce;

public class Text {

	public static void main(String[] args) {
		SaleSerivce sale=new SaleSerivceImpl();
		
		//只循环20次
		/*for(int i=1;i<=20;i++)
		{
			for(int a=1;a<=4;a++)
			{
				if(i==a)
				{
					System.out.println("该座位已被占用");
				}else if(i!=a)
				{
					System.out.println("该座位没有被占用");
				}
				
			}
			
			
		}*/
		
		
		int xid=3;
		BroadEntity br=new BroadEntity();
		br.setXid(xid);
		SaleEntity sa=new SaleEntity();
		sa.setBr(br);
		ArrayList<SaleEntity> list=sale.ReverseSelectionZuoWei(sa);
		for(SaleEntity a:list)
		{
			
			
			int x=a.getMZW();
			
			if(x==0)
			{
				System.out.println("123");
			}else{
				System.out.println("aa");
			}
			
		}
		
		
}
}
