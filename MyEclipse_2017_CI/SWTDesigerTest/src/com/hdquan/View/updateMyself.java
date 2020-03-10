package com.hdquan.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hdquan.dao.UserDao;
import com.hdquan.pojo.User;

import org.eclipse.swt.widgets.Composite;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class updateMyself {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	UserDao userDao;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			updateMyself window = new updateMyself();
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
		shell.setText("SWT Application");
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setText("\u65B0\u4FE1\u606F\u586B\u5199");
		group_1.setBounds(0, 120, 434, 102);
		
		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setBounds(10, 21, 61, 17);
		label_4.setText("\u59D3\u540D");
		
		Label label_5 = new Label(group_1, SWT.NONE);
		label_5.setText("\u7528\u6237\u7535\u8BDD");
		label_5.setBounds(10, 46, 61, 17);
		
		Label label_6 = new Label(group_1, SWT.NONE);
		label_6.setText("\u5BC6\u7801");
		label_6.setBounds(10, 75, 61, 17);
		
		text = new Text(group_1, SWT.BORDER);
		text.setBounds(121, 21, 140, 17);
		
		text_1 = new Text(group_1, SWT.BORDER);
		text_1.setBounds(121, 46, 140, 17);
		
		text_2 = new Text(group_1, SWT.BORDER);
		text_2.setBounds(121, 75, 140, 17);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(31, 228, 80, 27);
		btnNewButton.setText("\u63D0\u4EA4");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(288, 228, 80, 27);
		btnNewButton_1.setText("\u91CD\u586B");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("\u539F\u5148\u4FE1\u606F");
		group.setBounds(0, 10, 320, 102);
		
		Label label = new Label(group, SWT.NONE);
		label.setBounds(10, 20, 61, 17);
		label.setText("\u59D3\u540D");
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(113, 20, 61, 17);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setBounds(10, 43, 61, 17);
		label_1.setText("\u6027\u522B");
		
		Button btnRadioButton = new Button(group, SWT.RADIO);
		
		btnRadioButton.setBounds(90, 43, 97, 17);
		btnRadioButton.setText("\u7537");
		Button btnRadioButton_1 = new Button(group, SWT.RADIO);
		btnRadioButton_1.setBounds(208, 43, 97, 17);
		btnRadioButton_1.setText("\u5973");
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setBounds(10, 66, 61, 17);
		label_2.setText("\u7528\u6237\u7535\u8BDD");
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(113, 66, 61, 17);
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setBounds(10, 89, 61, 17);
		label_3.setText("\u5BC6\u7801");
		Label lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setBounds(113, 89, 61, 17);
		
		try {
			UserDao userDao=new UserDao();
			lblNewLabel_2.setText(User.getPassword());
			lblNewLabel.setText(User.getUserName());
		
			

		
			try {
				List<User> userList=userDao.query();
				String results[][]=new String[userList.size()][5];
				lblNewLabel.setText(User.getUserName());
				lblNewLabel_1.setText(User.getSex());
				lblNewLabel_2.setText(User.getUserPhone());
				Button button = new Button(shell, SWT.NONE);
				button.setBounds(354, 0, 80, 27);
				button.setText("\u8FD4\u56DE");
				button.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(final SelectionEvent e){
						shell.dispose();
						book book=new book();
						book.open();
					}
				});
				
				
				for(int i = 0; i < userList.size(); i++)  {
						User user1 = (User)userList.get(i);	
					results[i][0] = user1.getUserName();
					results[i][1] = user1.getSex();	
					results[i][2] = user1.getPassword();	
	
					if(user1.getSex().equals("男"))
						btnRadioButton.setSelection(true);
						else
							btnRadioButton_1.setSelection(true);
					lblNewLabel_1.setText(user1.getUserPhone());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!text_1.getText().equals("")&&!text.getText().equals("")&&!text_2.getText().equals(""))
			userDao.updateUser(text_1.getText(), text.getText(), text_2.getText());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e){
			
				try {
					userDao.updateUser(text_1.getText(), text.getText(), text_2.getText());
					if(!text_1.getText().equals("")&&!text_2.getText().equals("")&&!text.getText().equals(""))
					{shell.dispose();
					book book=new book();
					book.open();
					}
					else
					{JOptionPane.showMessageDialog(null,"用户名或密码不能为空","错误",JOptionPane.PLAIN_MESSAGE);}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e){
					text.setText("");
					text_1.setText("");
					text_2.setText("");
			
			}
		});
	}
}
