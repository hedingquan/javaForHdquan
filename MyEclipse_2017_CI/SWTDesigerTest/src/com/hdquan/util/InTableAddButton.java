package com.hdquan.util;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.BookDao;
import com.hdquan.pojo.Book;

public class InTableAddButton {
	public static  void inTableAddButton(Table table,int i,int size,TableItem tblclmnNewColumn_6,Shell shell,int location,String Context){
	BookDao bookDao=new BookDao();
	TableEditor[] colorEditors = new TableEditor[size];
	Button[] colorButtons = new Button[size];
	colorEditors[i] = new TableEditor(table);
	colorButtons[i] = new Button(table, SWT.PUSH);
	colorButtons[i].setText(Context);
//	colorButtons[i].computeSize(SWT.DEFAULT, table.getItemHeight());
	colorEditors[i].grabHorizontal = true;
//	colorEditors[i].minimumHeight = colorButtons[i].getSize().y;
//	colorEditors[i].minimumWidth = colorButtons[i].getSize().x;
	 colorEditors[i].setEditor(colorButtons[i], tblclmnNewColumn_6, location);
	 colorButtons[i].addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent event) {
	        	try {
	        		int ww=table.getItemCount();
					for(int bb=0;bb<ww;bb++)
						if(table.getItem(bb).getChecked()==true)
						{
					bookDao.addBorrowerBook(table.getItem(bb).getText(2));
					bookDao.updateBook(table.getItem(bb).getText(2));
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
	          }
	      }); 
	}
		public static  void inTableAddButton1(Table table,int i,int size,TableItem tblclmnNewColumn_6,Shell shell,int location,String Context)
		{
			TableEditor[] colorEditors = new TableEditor[size];
		Button[] CheckButtonArray = new Button[size];
		colorEditors[i] = new TableEditor(table);
			CheckButtonArray[i] = new Button(table, SWT.CHECK);
			CheckButtonArray[i].setText(Context);
			colorEditors[i].setEditor(CheckButtonArray[i], tblclmnNewColumn_6, location);
			colorEditors[i].grabHorizontal = true;
			CheckButtonArray[i].addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
					Button check_button = (Button)e.getSource();
					if (check_button.getSelection()) {
						System.out.println("ÊÕ²Ø³É¹¦£¡");
					}
				}
			});
		}
	public  static Button[] inTableAddButton1(Table table,int i,int size,TableItem tblclmnNewColumn_6,Shell shell,int location,String Context,int Id,String[] values){
		BookDao bookDao=new BookDao();
		TableEditor[] colorEditors = new TableEditor[size];
		Button[] colorButtons = new Button[size];
		colorEditors[i] = new TableEditor(table);
		colorButtons[i] = new Button(table, SWT.PUSH);
		colorButtons[i].setText(Context);
		colorEditors[i].grabHorizontal = true;	

		
		colorEditors[i].setEditor(colorButtons[i], tblclmnNewColumn_6, location);	
		colorButtons[i].addSelectionListener(new SelectionAdapter() {
			 public void widgetSelected(SelectionEvent event) 
			{	
				int ii=table.getItemCount();
				for(int i=0;i<ii;i++)
					if(table.getItem(i).getChecked()==true)
					{
//						System.out.println(table.getItem(i).getText(1));
//						System.out.println(table.getItem(i).getText(2));
//						System.out.println(table.getItem(i).getText(3));
//						System.out.println(table.getItem(i).getText(4));
					}

				 try {
					 Book book1=null;
				List<Book> query;
					query = BookDao.query();
				int size=query.size();
				String results[][]=new String[query.size()][9];
				for(int j = 0; j < query.size(); j++)  {
					 book1 = (Book)query.get(j);
				results[j][0] = book1.getISBN();
				results[j][1] = book1.getBookName();	
				results[j][2] = book1.getAuthor();	
				results[j][3] = book1.getCategory();
				results[j][4] = book1.getUploaderName();
				results[j][5] = book1.getUploaderPhone();
				results[j][6] = book1.getBorrowerName();
				results[j][7] = book1.getBorrowerPhone();
				results[j][8] = book1.getId();
//				 System.out.println(book1.getId());
				}
				int jj=table.getItemCount();
//				System.out.println(jj);
				for(int i=0;i<jj;i++)
							if(table.getItem(i).getChecked()==true)
							{	
								if(table.getItem(i).getText(0).equals(results[i][8]))
								{
									System.out.println(table.getItem(i).getText(0));
								book1.setISBN(table.getItem(i).getText(1));
								book1.setBookName(table.getItem(i).getText(2));
								book1.setAuthor(table.getItem(i).getText(3));
								book1.setCategory(table.getItem(i).getText(4));
								book1.setId(table.getItem(i).getText(0));
								System.out.println(book1.toString());
								BookDao.changeBook(book1);
								}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
		
		return colorButtons;
	}
		public  static TableEditor[] inTableAddButton2(Table table,int i,int size,TableItem tblclmnNewColumn_6,Shell shell,int location,String Context){
			BookDao bookDao=new BookDao();
			TableEditor[] colorEditors = new TableEditor[size];
			Button[] colorButtons = new Button[size];
			colorEditors[i] = new TableEditor(table);
			colorButtons[i] = new Button(table, SWT.PUSH);
			colorButtons[i].setText(Context);
			colorEditors[i].grabHorizontal = true;	
//			colorEditors[i].setEditor(colorButtons[i], tblclmnNewColumn_6, location);
				return colorEditors;
		
	}
			    }