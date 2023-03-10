package com.lntsufin.pdp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import com.lntsufin.objectRepository.PdpPage;

public class Ob {
	public static void main(String[] args) {
		String str="12345";
		int n=Integer.parseInt(str);
		System.out.println(str.substring(2));
		
		System.out.println(n);
		System.out.println(String.valueOf(n));
		HashMap<String,Integer> map=new HashMap();
		map.put("tasleem",10);
		map.put("anjali",20);
		for(Entry m:map.entrySet())
		{
			System.out.println(m.getKey()+"------"+m.getValue());
		}
		System.out.println(map.get("anjali"));
		Set set=new LinkedHashSet();
		set.add(19);
		set.add("tasU");
		set.add(60);
		Iterator it=set.iterator();
		while(it.hasNext())
		{
		System.out.println(it.next());
		}
		
		
		
		
		int[] arr= {5,8,9,4,7,6,3,1,16,5,8,8,10};
		int max=arr[0];
		int sec=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				sec=max;
				max=arr[i];
			}
			
		}
		System.out.println(max);
		System.out.println(sec);
		for(int i=0;i<arr.length;i++) {
			int count=0;
			for(int j=0;j<arr.length;j++)
			{
				if(i==j) {
					continue;
				}
				if(arr[i]==arr[j])
				{
					count++;
				}
			}
			if(count==0)
				System.out.println(arr[i]+"::::::::");
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=99)
			{
				System.out.println("==="+arr[i]);
			}
		}
		
	}

	private static int valueOf(String str) {
		// TODO Auto-generated method stub
		return 0;
	}

}
