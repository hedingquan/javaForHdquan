package com.hdquan.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.BookDao;
import com.hdquan.pojo.Book;
import com.hdquan.pojo.User;
import com.hdquan.util.ClearTableData;
import com.hdquan.util.InTableAddButton;
import com.hdquan.util.TableEdit;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class DeleteAndChange {

	protected Shell shell;
	private Table table;
	private TableColumn tblclmnIsbn;
	private TableColumn tblclmnIsbn_1;
	private TableColumn tableColumn_1;
	private TableColumn tableColumn_2;
	private TableColumn tableColumn_3;
	private Button button;
	private static Button[] inTableAddButton2;

	private int Id;
	private Button button_2;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DeleteAndChange window = new DeleteAndChange();
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
		shell.setSize(633, 482);
		shell.setText("SWT Application");
		
		Group group = new Group(shell, SWT.NONE);
		group.setBounds(0, 0, 618, 446);
		group.setText("我的书库管理");
		
		table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION |SWT.MULTI |SWT.CHECK);
		table.setBounds(10, 23, 598, 379);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBackgroundImage(SWTResourceManager.getImage("images//0.jpg"));
		
		tblclmnIsbn = new TableColumn(table, SWT.NONE);
		tblclmnIsbn.setWidth(100);
		tblclmnIsbn.setText("\u9009\u62E9");
		
		tblclmnIsbn_1 = new TableColumn(table, SWT.NONE);
		tblclmnIsbn_1.setWidth(100);
		tblclmnIsbn_1.setText("ISBN");
		
		tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u4E66\u540D");
		
		tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u4F5C\u8005");
		
		tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u4E66\u7C7B\u522B");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u64CD\u4F5C");
		
		button = new Button(group, SWT.NONE);
		button.setBounds(480, 419, 80, 27);
		button.setText("删除");
		
		Button button_1 = new Button(group, SWT.NONE);
		button_1.setBounds(35, 419, 80, 27);
		button_1.setText("刷新");
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(170, 409, 247, 35);
		lblNewLabel.setText("权的图书馆");
		
		button_2 = new Button(group, SWT.NONE);
		button_2.setBounds(514, 0, 94, 20);
		button_2.setText("\u8FD4\u56DE");
		
		

		String[] values=new String[4];
	
		int size=0;
		try {
			 
			
			
		
		
				button_1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event)
				{
					ClearTableData.clearTableData(table);
					try {
						List<Book> bookList = BookDao.bookList();
						String results1[][]=new String[bookList.size()][5];
						for(int i = 0; i < bookList.size(); i++) {
								Book book2 = (Book)bookList.get(i);	
								results1[i][0] = book2.getISBN();
								results1[i][1] = book2.getBookName();	
								results1[i][2] = book2.getAuthor();		
								results1[i][3] = book2.getCategory();
								results1[i][4]=book2.getId();
							org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tblclmnNewColumn_6.setText(new String[]{results1[i][4],results1[i][0],results1[i][1],results1[i][2],results1[i][3]});
							
						
//							if()
//							for(int k=0;k<=3;k++)
//							{	Text text=new Text(table, Id);
								TableEdit.tableEdit(table);
//								System.out.println(text.getText());
//							}

								inTableAddButton2 = InTableAddButton.inTableAddButton1(table,i,bookList.size(),tblclmnNewColumn_6,shell,5,"修改",Id,values);
								
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	
		button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event)
				{	
					
					 int ii=table.getItemCount();
						for(int i=0;i<ii;i++)
							if(table.getItem(i).getChecked()==true)
							{
					try {
						Book book0=new Book();
						book0.setId(table.getItem(i).getText(0));
						BookDao.delBook(book0);
					} catch (SQLException e) {
						e.printStackTrace();
					}
							}
				}
		});
		
		button_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event)
			{
				shell.dispose();
				book book=new book();
				book.open();
				
			}
		});
	}
}
	
