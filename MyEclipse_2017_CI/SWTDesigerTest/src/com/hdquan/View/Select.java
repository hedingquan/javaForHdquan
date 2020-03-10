package com.hdquan.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.hdquan.dao.BookDao;
import com.hdquan.pojo.Book;
import com.hdquan.util.ClearTableData;
import com.hdquan.util.InTableAddButton;

import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

public class Select {

	protected Shell shell;
	private Table table;
	BookDao bookDao=new BookDao();
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	Book book=new Book();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Select window = new Select();
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
		shell.setSize(1111, 609);
		shell.setText("SWT Application");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("\u56FE\u4E66\u501F\u9605\u67E5\u8BE2");
		group.setBounds(0, 0, 1095, 570);
		
		table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION |SWT.CHECK);
		table.setBounds(0, 21, 1095, 501);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("ISBN");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("书籍名称");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("作者");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("书籍类别");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("上传者电话");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("上传者名称");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("借阅者名称");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("\u501F\u9605\u8005\u7535\u8BDD");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("操作1");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("\u64CD\u4F5C2");
		
		Group group_1 = new Group(group, SWT.NONE);
		group_1.setText("\u67E5\u8BE2\u6761\u4EF6");
		group_1.setBounds(0, 528, 1101, 51);
		group_1.setBackgroundImage(SWTResourceManager.getImage("images//3.jpg"));
		
		
		Label lblNewLabel = new Label(group_1, SWT.NONE);
		lblNewLabel.setBounds(10, 18, 41, 17);
		lblNewLabel.setText("\u4E66\u540D\uFF1A");
		
		text = new Text(group_1, SWT.BORDER);
		text.setBounds(54, 18, 73, 23);
		
		Label label = new Label(group_1, SWT.NONE);
		label.setText("作者：");
		label.setBounds(264, 18, 41, 17);
		
		text_1 = new Text(group_1, SWT.BORDER);
		text_1.setBounds(311, 18, 73, 23);
		
		Label label_1 = new Label(group_1, SWT.NONE);
		label_1.setText("书籍类别：");
		label_1.setBounds(492, 18, 57, 17);
		
		text_2 = new Text(group_1, SWT.BORDER);
		text_2.setBounds(555, 18, 73, 23);
		
		Label label_2 = new Label(group_1, SWT.NONE);
		label_2.setText("上传者名称：");
		label_2.setBounds(718, 21, 66, 17);
		
		Button btnNewButton = new Button(group_1, SWT.NONE);
		btnNewButton.setLocation(958, 13);
		btnNewButton.setSize(80, 27);
		btnNewButton.setText("查询");
		
				
				
				btnNewButton.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(final SelectionEvent e){
						try {
							ClearTableData.clearTableData(table);
							book.setBookName(text.getText());
							book.setAuthor(text_1.getText());
							book.setCategory(text_2.getText());
							book.setUploaderName(text_3.getText());
				
						ResultSet bookList = bookDao.bookList(book);
						List<Book> bookList1 = new ArrayList<Book>();
						while (bookList.next()){	           
							Book book1 = new Book();	     
							book1.setISBN(bookList.getString(1));
							book1.setBookName(bookList.getString(2));
							book1.setAuthor(bookList.getString(3));
							book1.setCategory(bookList.getString(4));
							book1.setUploaderPhone(bookList.getString(5));
							book1.setUploaderName(bookList.getString(6));
							book1.setBorrowerName(bookList.getString(7));
							book1.setBorrowerPhone(bookList.getString(8));
							book1.setId(bookList.getString(9));
							bookList1.add(book1);	 
		//					for(int i=1;i<=7;i++)
		//					System.out.println(bookList.getString(i));
												}

				
						
						String results[][]=new String[bookList1.size()][9];
						for(int i = 0; i < bookList1.size(); i++) {	
								Book book1 = (Book)bookList1.get(i);	
								results[i][0] = book1.getISBN();
								results[i][1] = book1.getBookName();	
								results[i][2] = book1.getAuthor();		
								results[i][3] = book1.getCategory();
								results[i][4] = book1.getUploaderPhone();
								results[i][5] = book1.getUploaderName();
								results[i][6] = book1.getBorrowerPhone();
								results[i][7] = book1.getBorrowerName();
								results[i][8] = book1.getId();
								System.out.println(results[i][5]);
							
							org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tblclmnNewColumn_6.setText(new String[]{results[i][8],results[i][0],results[i][1],results[i][2],results[i][3],results[i][4],results[i][5],results[i][7],results[i][6]});
							InTableAddButton.inTableAddButton(table,i,bookList1.size(),tblclmnNewColumn_6,shell,9,"借阅");
							InTableAddButton.inTableAddButton1(table,i,bookList1.size(),tblclmnNewColumn_6,shell,10,"收藏");
						}
						int ww=table.getItemCount();
						for(int bb=0;bb<ww;bb++)
							if(table.getItem(bb).getChecked()==true)
							{
					try {
						bookDao.updateBook2(table.getItem(bb).getText(0));
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
								}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
						 
					}
					});
		
		text_3 = new Text(group_1, SWT.BORDER);
		text_3.setBounds(790, 18, 73, 23);
		
		Button btnNewButton_1 = new Button(group, SWT.NONE);
		btnNewButton_1.setBounds(826, 0, 88, 20);
		btnNewButton_1.setText("\u8FD4\u56DE");
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e){
				
				shell.dispose();
				book book=new book();
				book.open();
			}
		});
	}
}
