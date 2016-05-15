package test;

import java.util.Arrays;
import java.util.Random;

import zx.rpc.support.RPC;

public class MainClient {
	public static void main(String[] args) {
		Sort echo = RPC.getProxy(Sort.class, "localhost", 20382);
		
		Random r = new Random();
		int [] a =null;
		
		
		int num=100000;
		a=new int[num];
		for(int x=0;x<num;x++)
		{
			a[x]=r.nextInt(num);
		}
		
		
		long time = System.currentTimeMillis();
		
		a=echo.sort(a);
		//Arrays.sort(a);
		
		time = System.currentTimeMillis()-time;
		System.out.println("排序"+num+"个数共使用了"+time+"毫秒");
		
		
		
			
	}
}
