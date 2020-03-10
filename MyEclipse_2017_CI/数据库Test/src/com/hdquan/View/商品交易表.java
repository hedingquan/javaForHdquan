package com.hdquan.View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.Supermarket_Management;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;

public class 商品交易表 {

	protected Shell shell;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			商品交易表 window = new 商品交易表();
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
		shell.setSize(641, 427);
		shell.setText("商品交易");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 33, 605, 345);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setText("\u5546\u54C1\u540D\u79F0");
		tblclmnNewColumn_1.setWidth(100);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u6570\u91CF");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u91D1\u989D");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u4F1A\u5458\u5361\u53F7");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("\u4EA4\u6613\u6D41\u6C34\u53F7");
		
		text = new Text(shell, SWT.BORDER);
		text.setText("                                                          \u5546\u54C1\u4EA4\u6613\u6D41\u6C34\u5355");
		text.setBounds(10, 0, 521, 27);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(535, 0, 80, 27);
		button.setText("\u9000\u8D27");

		List<com.hdquan.pojo.商品交易表> selInfo01;
		try {
			selInfo01 = Supermarket_Management.SelInfo01();
			String results[][]=new String[selInfo01.size()][5];
			for(int i = 0; i < selInfo01.size(); i++) {	
				com.hdquan.pojo.商品交易表  Info = selInfo01.get(i);	
					results[i][0] = Info.get商品名称();
					results[i][1] = Info.get交易数量();	
					results[i][2] = Info.get金额();		
					results[i][3] = Info.get会员卡号();
					results[i][4] = Info.get交易流水号();
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_6.setText(new String[]{"商品"+i,results[i][0],results[i][1],results[i][2],results[i][3],results[i][4]});
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e)
			{		
				退货界面 退货界面=new 退货界面();
				退货界面.open();
			}	
		});
}
}