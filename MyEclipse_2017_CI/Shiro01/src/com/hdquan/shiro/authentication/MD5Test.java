package com.hdquan.shiro.authentication;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {
	public static void main(String args[])
	{
		//ԭʼ����
		String source="1";
		//��
		String salt="hdquan";
		//ɢ�д���
		int hashIterations=1;
//		���췽����:
//		��һ�����������ģ�ԭʼ����
//		�ڶ����������Σ�ͨ��ʹ�������
//		������������ɢ�еĴ���������ɢ�����Σ��൱��md5��MD5��''��)
		Md5Hash md5Hash=new Md5Hash(source, salt, hashIterations);
		String password_md5 = md5Hash.toString();
			System.out.println(password_md5);
			
			//��һ��������ɢ���㷨
		SimpleHash simpleHash=new SimpleHash("md5", source, salt, hashIterations);
		System.out.println(simpleHash.toString());
	}
}
