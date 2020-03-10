package com.hdquan.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.hdquan.dao.UserDao;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Register {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Register window = new Register();
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
		shell.setBackgroundImage(SWTResourceManager.getImage("images//3.jpg"));
		
		shell.setSize(450, 300);
		shell.setText("注册");
		
		text = new Text(shell, SWT.BORDER);
		text.setText("用户名");
		text.setBounds(88, 30, 232, 31);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setText("密码");
		text_1.setBounds(88, 93, 232, 31);
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioButton.setBounds(88, 155, 242, 17);
		btnRadioButton.setText("我已阅读并同意相关服务条款和隐私政策");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(90, 195, 215, 31);
		btnNewButton.setText("立即注册");
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e){
				String username = text.getText();
				String password = text_1.getText();
				UserDao userDao = new UserDao();
				if(text.getText()!=""|text_1.getText()!="")
				{
					userDao.AddUser(username, password);
					shell.dispose();
					new book();
					MessageDialog.openInformation(shell,"登录信息","欢迎"+text.getText()+"进入系统！");
				}
				else{}
			}
			});
	}
}
