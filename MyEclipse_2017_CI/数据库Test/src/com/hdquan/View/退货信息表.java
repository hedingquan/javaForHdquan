package com.hdquan.View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.Supermarket_Management;
import com.hdquan.util.AddButton;

import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;

public class 退货信息表 {

	protected Shell shell;
	private Table table;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			退货信息表 window = new 退货信息表();
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
		shell.setSize(302, 408);
		shell.setText("退货处理信息单");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 39, 287, 304);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		

		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(10, 347, 80, 27);
		btnNewButton.setText("\u9000\u8D27\u65E5\u671F");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(96, 349, 192, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setText("                      \u9000\u8D27\u4FE1\u606F\u5904\u7406\u5355");
		text_1.setBounds(0, 0, 287, 43);

		List<com.hdquan.pojo.退货信息表> selInfo;
		try {
			selInfo = Supermarket_Management.SelInfo03();
			String results[][]=new String[selInfo.size()][9];
			for(int i = 0; i < selInfo.size(); i++) {	
				com.hdquan.pojo.退货信息表  Info = selInfo.get(i);	
					results[i][0] = Info.get交易流水号();
					results[i][1] = Info.get商品编号();	
					results[i][2] = Info.get退货金额();		
					results[i][3] = Info.get退货数量();
					results[i][4] = Info.get退货日期();
					TableColumn tableColumn = new TableColumn(table, SWT.NONE);
					tableColumn.setWidth(300);
					tableColumn.setText("交易流水号");
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_0 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_0.setText(new String[]{results[i][0]});
					
					org.eclipse.swt.widgets.TableItem tableItem_1 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tableItem_1.setText("\u5546\u54C1\u7F16\u53F7");
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_1 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_1.setText(new String[]{results[i][1]});
				
					org.eclipse.swt.widgets.TableItem tableItem_2 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tableItem_2.setText("\u9000\u8D27\u91D1\u989D");
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_2 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_2.setText(new String[]{results[i][2]});
					
					org.eclipse.swt.widgets.TableItem tableItem_3 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tableItem_3.setText("\u9000\u8D27\u6570\u91CF");
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_3 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_3.setText(new String[]{results[i][3]});
					
					text.setText(results[i][4]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
