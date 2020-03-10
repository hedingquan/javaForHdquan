package com.hdquan.View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.Supermarket_Management;
import com.hdquan.util.ValidCode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class 购买商品 {

	protected Shell shell;
	private Text text;
	private Table table;
	private Button button_1;
	private Button btnNewButton;
	private Text text_1;
	private Text text_2;
	private Button button_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			购买商品 window = new 购买商品();
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
		shell.setSize(303, 390);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(86, 0, 183, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(0, -2, 80, 27);
		button.setText("\u5546\u54C1\u67E5\u8BE2");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 29, 282, 257);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(202, 307, 80, 27);
		button_1.setText("\u8D2D\u4E70");
		
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(0, 288, 90, 27);
		btnNewButton.setText("\u586B\u5199\u8D2D\u4E70\u6570\u91CF");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(106, 288, 90, 27);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(106, 320, 90, 27);
		
		button_2 = new Button(shell, SWT.NONE);
		button_2.setBounds(0, 321, 90, 27);
		button_2.setText("\u586B\u5199\u4F1A\u5458\u5361\u53F7");
			
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e)
			{	
			try {
				List<com.hdquan.pojo.商品信息表> selInfo;
				selInfo = Supermarket_Management.SelInfo();
				String results[][]=new String[selInfo.size()][9];
				for(int i = 0; i < selInfo.size(); i++) {	
					com.hdquan.pojo.商品信息表  Info = selInfo.get(i);	
						results[i][0] = Info.get商品编号();
						results[i][1] = Info.get商品名称();	
						results[i][2] = Info.get商品条形码();		
						results[i][3] = Info.get商品类别();
						results[i][4] = Info.get商品售价();
						results[i][5] = Info.get商品售价();
						results[i][6] = Info.get告警量();
						
					
						if(text.getText().equals(results[i][1]))
						{
							TableColumn tableColumn = new TableColumn(table, SWT.NONE);
							tableColumn.setText("商品名称");
							tableColumn.setWidth(300);
							org.eclipse.swt.widgets.TableItem tblclmnNewColumn_12 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tblclmnNewColumn_12.setText(new String[]{results[i][1]});
							org.eclipse.swt.widgets.TableItem tableItem_21 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tableItem_21.setText("商品条形码");
							org.eclipse.swt.widgets.TableItem tblclmnNewColumn_22 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tblclmnNewColumn_22.setText(new String[]{results[i][2]});
							org.eclipse.swt.widgets.TableItem tableItem_31 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tableItem_31.setText("商品类别");
							org.eclipse.swt.widgets.TableItem tblclmnNewColumn_32 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tblclmnNewColumn_32.setText(new String[]{results[i][3]});
							org.eclipse.swt.widgets.TableItem tableItem_41 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tableItem_41.setText("商品售价");
							org.eclipse.swt.widgets.TableItem tblclmnNewColumn_42 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tblclmnNewColumn_42.setText(new String[]{results[i][4]});
							org.eclipse.swt.widgets.TableItem tableItem_51 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tableItem_51.setText("库存量");
							org.eclipse.swt.widgets.TableItem tblclmnNewColumn_52 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
							tblclmnNewColumn_52.setText(new String[]{results[i][5]});
						}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			});
		
		button_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e)
			{	
				text_1.setVisible(true);
				try {
					List<com.hdquan.pojo.商品信息表> selInfo;
					selInfo = Supermarket_Management.SelInfo();
					String results[][]=new String[selInfo.size()][9];
					for(int i = 0; i < selInfo.size(); i++) {	
						com.hdquan.pojo.商品信息表  Info = selInfo.get(i);	
							results[i][0] = Info.get商品编号();
							results[i][1] = Info.get商品名称();	
							results[i][2] = Info.get商品条形码();		
							results[i][3] = Info.get商品类别();
							results[i][4] = Info.get商品售价();
							results[i][5] = Info.get库存量();
							results[i][6] = Info.get告警量();
							
						
							if(text.getText().equals(results[i][1]))
							{
								String liushui=ValidCode.validCode();
								if(text_2.getText().equals(""))
								Supermarket_Management.AddShop(liushui, results[i][0], results[i][1], text_1.getText(),"1",results[i][4],df.format(new Date()));
								else
									Supermarket_Management.AddShop(liushui, results[i][0], results[i][1], text_1.getText(),text_2.getText(),results[i][4],df.format(new Date()));
								shell.dispose();
								商品交易表 商品交易表=new 商品交易表();
								商品交易表.open();
							}
					
}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
