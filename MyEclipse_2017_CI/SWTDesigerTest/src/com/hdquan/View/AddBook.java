package com.hdquan.View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.hdquan.dao.BookDao;
import com.hdquan.dao.UserDao;
import com.hdquan.pojo.Book;
import com.hdquan.pojo.User;

import org.eclipse.swt.widgets.Button;

public class AddBook {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	User user=new User();
	UserDao userDao = new UserDao();
	Book book1=new Book();
	BookDao bookDao=new BookDao();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddBook window = new AddBook();
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
		shell.setSize(512, 355);
		shell.setText("添加书籍");
		shell.setLayout(new FormLayout());
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("\u65B0\u4E66\u5165\u5E93");
		group.setBackgroundImage(SWTResourceManager.getImage("images//u=2743001657,206578219&fm=26&gp=0.jpg"));
		
		
		FormData fd_group = new FormData();
		fd_group.top = new FormAttachment(0);
		fd_group.bottom = new FormAttachment(100, -10);
		fd_group.right = new FormAttachment(100, -10);
		fd_group.left = new FormAttachment(0, 112);
		group.setLayoutData(fd_group);
		
		Label lblIsb = new Label(group, SWT.NONE);
		lblIsb.setBounds(69, 28, 61, 17);
		lblIsb.setText("ISBN");
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(148, 28, 98, 23);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("书名");
		label_1.setBounds(69, 67, 61, 17);
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(148, 67, 98, 23);
		
		Label label = new Label(group, SWT.NONE);
		label.setText("作者");
		label.setBounds(69, 109, 61, 17);
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setBounds(148, 109, 98, 23);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setText("书类别");
		label_2.setBounds(69, 157, 61, 17);
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setBounds(148, 151, 98, 23);
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setText("用户信息");
		FormData fd_group_1 = new FormData();
		fd_group_1.bottom = new FormAttachment(group, 0, SWT.BOTTOM);
		fd_group_1.top = new FormAttachment(0);
		fd_group_1.right = new FormAttachment(group, -6);
		
		Button btnNewButton = new Button(group, SWT.NONE);
		btnNewButton.setBounds(50, 233, 80, 27);
		btnNewButton.setText("添加书籍");
		
		Button button = new Button(group, SWT.NONE);
		button.setBounds(209, 233, 80, 27);
		button.setText("重置");
		
		Button button_1 = new Button(group, SWT.NONE);
		button_1.setBounds(294, 0, 80, 27);
		button_1.setText("\u8FD4\u56DE");
		fd_group_1.left = new FormAttachment(0, 4);
		group_1.setLayoutData(fd_group_1);
		
		Group group_2 = new Group(group_1, SWT.NONE);
		group_2.setText("用户姓名");
		group_2.setBounds(0, 31, 70, 84);
		
		
		Label lblNewLabel = new Label(group_2, SWT.NONE);
		lblNewLabel.setBounds(10, 41, 61, 17);
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("用户性别");
		group_3.setBounds(0, 134, 70, 84);
		
		
		Label lblNewLabel_1 = new Label(group_3, SWT.NONE);
		lblNewLabel_1.setBounds(10, 37, 61, 17);
		
		Group group_4 = new Group(group_1, SWT.NONE);
		group_4.setText("用户电话");
		group_4.setBounds(0, 236, 70, 84);
		
		Label lblNewLabel_2 = new Label(group_4, SWT.NONE);
		lblNewLabel_2.setBounds(10, 34, 61, 17);
		
        try {
			List<User> userList=userDao.query();
			String results[][]=new String[userList.size()][5];
			lblNewLabel.setText(User.getUserName());
			lblNewLabel_1.setText(User.getSex());
		lblNewLabel_2.setText(User.getUserPhone());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        btnNewButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(final SelectionEvent e){
			book1.setISBN(text.getText());
			book1.setBookName(text_1.getText());
			book1.setAuthor(text_2.getText());
			book1.setCategory(text_3.getText());
			try {
				bookDao.addBook(book1);
				shell.dispose();
				book book=new book();
    			book.open();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(book1.toString());
		}
		});
        
        
        button.addSelectionListener(new SelectionAdapter() {
    		public void widgetSelected(final SelectionEvent e){
    			text.setText("");
    			text_1.setText("");
    			text_2.setText("");
    			text_3.setText("");
    		}
    		});
        
        button_1.addSelectionListener(new SelectionAdapter() {
    		public void widgetSelected(final SelectionEvent e){
    			shell.setVisible(false);
    			book book=new book();
    			book.open();
    		}
		});
    		}
}
