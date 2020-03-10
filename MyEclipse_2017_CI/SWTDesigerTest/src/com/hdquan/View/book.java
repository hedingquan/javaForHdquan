package com.hdquan.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.sql.SQLException;
import java.util.List;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.hdquan.dao.BookDao;
import com.hdquan.pojo.Book;
import com.hdquan.util.ClearTableData;

import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class book {

	protected Shell shell;
	private Table table;
	private Book book = new Book();	

	private BookDao borrowerDao=new BookDao();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			book window = new book();
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
		shell.setBackgroundImage(SWTResourceManager.getImage("images//4.jpg"));
		shell.setSize(608, 444);
		shell.setText("SWT Application");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("\u56FE\u4E66\u501F\u9605");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_1.setText("借走书籍");
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_1.setText("图书信息管理");
		
		Menu menu_2 = new Menu(mntmNewSubmenu_1);
		mntmNewSubmenu_1.setMenu(menu_2);
		
		MenuItem mntmNewItem = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem.setText("上传书籍");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.CASCADE);
		menuItem_1.setText("我的书库管理");
		
		Menu menu_3 = new Menu(menuItem_1);
		menuItem_1.setMenu(menu_3);
		
		MenuItem menuItem_3 = new MenuItem(menu_3, SWT.NONE);
		menuItem_3.setText("\u4FEE\u6539\u4E66\u7C4D");
		
		MenuItem menuItem_2 = new MenuItem(menu_3, SWT.NONE);
		menuItem_2.setText("\u5220\u9664\u4E66\u7C4D");
		
		MenuItem menuItem_4 = new MenuItem(menu_3, SWT.NONE);
		menuItem_4.setText("\u6536\u85CF\u4E66\u7C4D");
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("查找书籍");
		
		MenuItem mntmNewSubmenu_2 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_2.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		Menu menu_4 = new Menu(mntmNewSubmenu_2);
		mntmNewSubmenu_2.setMenu(menu_4);
		
		MenuItem mntmNewItem_2 = new MenuItem(menu_4, SWT.NONE);
		mntmNewItem_2.setText("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		
		MenuItem menuItem_5 = new MenuItem(menu, SWT.NONE);
		menuItem_5.setText("\u4F7F\u7528\u8BF4\u660E");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION |SWT.CHECK);
		table.setBounds(0, 10, 604, 320);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBackgroundImage(SWTResourceManager.getImage("images//4.jpg"));
		
		
		org.eclipse.swt.widgets.TableColumn tblclmnNewColumn = new org.eclipse.swt.widgets.TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		
		
		org.eclipse.swt.widgets.TableColumn tblclmnNewColumn_1 = new org.eclipse.swt.widgets.TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		
		org.eclipse.swt.widgets.TableColumn tblclmnNewColumn_2 = new org.eclipse.swt.widgets.TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		
		org.eclipse.swt.widgets.TableColumn tblclmnNewColumn_3 = new org.eclipse.swt.widgets.TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		
		org.eclipse.swt.widgets.TableColumn tblclmnNewColumn_4 = new org.eclipse.swt.widgets.TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(45, 348, 80, 27);
		button.setText("\u9000\u51FA\u7CFB\u7EDF");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(439, 348, 80, 27);
		btnNewButton.setText("\u5F52\u8FD8\u4E66\u7C4D");
//			
//		tblclmnNewColumn.setText("ISBN");
//		tblclmnNewColumn_1.setText("书名");
//		tblclmnNewColumn_2.setText("书种类");
//		tblclmnNewColumn_3.setText("借书人名字");
//		tblclmnNewColumn_4.setText("借书人电话");
		
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(final SelectionEvent e){
			
			tblclmnNewColumn.setText("ID");
			tblclmnNewColumn_1.setText("图书名称");
			tblclmnNewColumn_2.setText("借书人名字");
			tblclmnNewColumn_3.setText("借书人电话");
			
			String[] columnNames = {"ID", "图书名称", "借书人姓名", "借书人电话"};
			ClearTableData.clearTableData(table);
			
				try {
					List<Book> list = BookDao.borrowQuery();
					String[][] results = new String[list.size()][columnNames.length];  
//				System.out.println(list.size());
					for(int i = 0; i < list.size(); i++) {
					for(int j=0;j<columnNames.length;j++){		
						Book book = (Book)list.get(i);	
						results[i][0] = book.getId();
						results[i][1] = book.getBookName();	
						results[i][2] = book.getBorrowerName();		
						results[i][3] = book.getBorrowerPhone();
//						System.out.println(results[i][j]);
							//org.eclipse.swt.widgets.TableColumn tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableColumn(table, SWT.NONE);
							//tblclmnNewColumn_2.setWidth(100);	
					}
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_6.setText(new String[]{results[i][0],results[i][1],results[i][2],results[i][3]});
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
		}
		});
		
		
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
					AddBook addBook=new AddBook();
					shell.setVisible(false);
					addBook.open();
					}
		});
		
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e)
			{
				DeleteAndChange deleteAndChange=new DeleteAndChange();
				shell.setVisible(false);
				deleteAndChange.open();
			}
			
		});
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e)
			{
				DeleteAndChange deleteAndChange=new DeleteAndChange();
				shell.setVisible(false);
				deleteAndChange.open();
			}
			
		});
		
		menuItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e)
			{
				Select select=new Select();
				shell.setVisible(false);
				select.open();
			}
		});
		
		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateMyself updatemyself=new updateMyself();
				shell.setVisible(false);
				updatemyself.open();
					}
		});
		
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
				login login=new login();
				login.open();
			}
		});
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int ii=table.getItemCount();
				for(int i=0;i<ii;i++)
					if(table.getItem(i).getChecked()==true)
					{
						Book book=new Book();
						book.setId(table.getItem(i).getText(0));
						BookDao bookDao=new BookDao();
						try {
							bookDao.returnBook(book);
							try {
								bookDao.updateBook1();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			}
		});
		
		menuItem_5.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				IOReaderFile IOReaderfile=new IOReaderFile();
				IOReaderfile.open();
				
			}
		});
		menuItem_4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				Select select=new Select();
				select.open();
			}
	});
			}
	}
