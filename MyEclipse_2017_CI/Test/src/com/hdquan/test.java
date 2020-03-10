package com.hdquan;

public class test {
	public static void main(String args[])
	{
		Register register=new Register();
		register.setId(2);
		register.setPassword("hedingquan123");
		register.setBirth("2019-5-5");
		HandleInsertDate handleInsertDate=new HandleInsertDate();
		handleInsertDate.writeRegisterModel(register);
		Login login=new Login();
		login.setId(1);
		login.setPassword("hedingquan123");
		HandleLogin handleLogin=new HandleLogin();
		login= handleLogin.queryVerify(login);
		if(login.isLoginSuccess()==true)
		{
			System.out.println("登录成功！！！");
		}
	}
}
