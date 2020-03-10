package com.hdquan.View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.Supermarket_Management;

import org.eclipse.swt.widgets.TableColumn;

public class 会员表 {

	protected Shell shell;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			会员表 window = new 会员表();
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
		shell.setSize(509, 449);
		shell.setText("会员表");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 46, 501, 371);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u4F1A\u5458\u5361\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u4F1A\u5458\u59D3\u540D");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u4F1A\u5458\u5BC6\u7801");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u6CE8\u518C\u65E5\u671F");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("\u622A\u6B62\u65E5\u671F");
		
		text = new Text(shell, SWT.BORDER);
		text.setText("                                                        \u4F1A\u5458\u8868");
		text.setBounds(0, 17, 501, 33);

		List<com.hdquan.pojo.会员表> selInfo;
		try {
			selInfo = Supermarket_Management.SelInfo02();
			String results[][]=new String[selInfo.size()][9];
			for(int i = 0; i < selInfo.size(); i++) {	
				com.hdquan.pojo.会员表  Info = selInfo.get(i);	
					results[i][0] = Info.get会员卡号();
					results[i][1] = Info.get会员姓名();	
					results[i][2] = Info.get会员密码();		
					results[i][3] = Info.get注册日期();
					results[i][4] = Info.get截止日期();
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_6.setText(new String[]{results[i][0],results[i][1],results[i][2],results[i][3],results[i][4]});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
