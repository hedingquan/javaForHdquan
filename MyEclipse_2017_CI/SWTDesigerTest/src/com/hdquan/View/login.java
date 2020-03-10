package com.hdquan.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Text;
import com.hdquan.dao.UserDao;
import com.hdquan.pojo.User;
import com.hdquan.util.ValidCode;

import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class login {
	
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			login window = new login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		
		shell.setBackgroundImage(SWTResourceManager.getImage("images//2.jpg"));
		shell.setText("登录页面");
		
		
		
		Label label = new Label(shell, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setBounds(22, 34, 61, 17);
		label.setText("用户名");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setAlignment(SWT.CENTER);
		label_1.setBounds(22, 99, 61, 17);
		label_1.setText("密码");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(89, 31, 221, 23);
		
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(89, 96, 221, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(39, 191, 80, 27);
		button.setText("登录");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(206, 191, 80, 27);
		button_1.setText("重置");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setBounds(337, 31, 87, 20);
		button_2.setText("创建用户");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(89, 138, 107, 23);
		    
		    
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setBounds(337, 138, 80, 23);
		button_3.setText("看不清");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(0, 255, 204));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(237, 138, 73, 23);
		String validCode2 = ValidCode.validCode();
		lblNewLabel.setText(validCode2);
		

		
		button.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(final SelectionEvent e)
		{	
			 String success="-1";
			 String error="-2";
				String username = text.getText();
				String password = text_1.getText();
				UserDao userDao = new UserDao();
//				System.out.println(user.toString());
				if(text_2.getText()!="")
		{
			if(text.getText()!=""||text_1.getText()!="")
			{	
				if(text_2.getText().equals(lblNewLabel.getText()))
				{
			try {		  
				User.setUserName(username);
				User.setPassword(password);
				User.getAllInfo(username, username);
//				System.out.println(User.userName+"/"+User.password+"/"+User.ID+"/"+User.userPhone);
//					System.out.println(User.getUserName()+""+User.getPassword());
				    List<User> userList = userDao.query();
			        for (User user1 : userList){
			      String results[][]=new String[userList.size()][2];
					for(int i = 0; i < userList.size(); i++) {		
							results[i][0] = user1.getUserName();
							results[i][1] = user1.getPassword();
//								System.out.println(results[i][0]+""+results[i][1]);
			        	if (results[i][0].equals(username) && results[i][1].equals(password))
			        	{
			        		
			        		MessageDialog.openInformation(shell,"登录信息","欢迎"+text.getText()+"进入系统！");
			        		shell.dispose();
			        		book book1 = new book();
			    			book1.open();
			        				success="1";
			        	}
					}
			        }
					if(success.equals("-1"))
				{JOptionPane.showMessageDialog(null,"用户名或密码错误","错误",JOptionPane.PLAIN_MESSAGE);
				error="2";
				}      			
			}catch(Exception ex) {
					ex.printStackTrace();
				} 
			}
			}
			if(success.equals("-1")&&error.equals("-2"))
				{JOptionPane.showMessageDialog(null,"用户名或密码不能为空","错误",JOptionPane.PLAIN_MESSAGE);
				}
		}
				else if(text_2.getText().equals("")) JOptionPane.showMessageDialog(null,"验证码不能为空","错误",JOptionPane.PLAIN_MESSAGE);
		}
		});
		
		
		
		button_1.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(final SelectionEvent e){
			text.setText("");
			text_1.setText("");
		}
		});
		
		button_2.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(final SelectionEvent e){
			System.out.println("aaaa");
			//shell.setVisible(true);
			//new Register();
			shell.dispose();
			Register register = new Register();
			register.open();
		}
		});
		
		button_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e)
			{		
				String validCode2 = ValidCode.validCode();
				lblNewLabel.setText(validCode2);
			}
		});
	}
}
