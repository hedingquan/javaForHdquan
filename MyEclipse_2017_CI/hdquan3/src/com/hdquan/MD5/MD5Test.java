package com.hdquan.MD5;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {
	public static void main(String args[])
	{
		String source="123";
		String salt="hdquan";
		int hashIterations=1;
		Md5Hash md5Hash=new Md5Hash(source, salt, hashIterations);
		String password_md5 = md5Hash.toString();
			System.out.println(password_md5);
		SimpleHash simpleHash=new SimpleHash("md5", source, salt, hashIterations);
		System.out.println(simpleHash.toString());
	}
}
