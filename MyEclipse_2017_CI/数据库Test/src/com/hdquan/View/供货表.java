package com.hdquan.View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.Supermarket_Management;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class 供货表 {

	protected Shell shell;
	private Text text;
	private Table table;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			供货表 window = new 供货表();
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
		shell.setSize(339, 376);
		shell.setText("供货单");
		
		text = new Text(shell, SWT.BORDER);
		text.setText("                                \u4F9B\u8D27\u5355");
		text.setBounds(0, 0, 328, 40);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 46, 328, 271);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		

		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(149, 317, 179, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(0, 315, 143, 27);
		btnNewButton.setText("\u4F9B\u8D27\u5355\u6700\u65B0\u751F\u6210\u65E5\u671F");
		
		List<com.hdquan.pojo.供货表> selInfo;
		try {
			selInfo = Supermarket_Management.SelInfo04();
			String results[][]=new String[selInfo.size()][9];
			for(int i = 0; i < selInfo.size(); i++) {	
				com.hdquan.pojo.供货表  Info = selInfo.get(i);	
					results[i][0] = Info.get供货单编号();
					results[i][1] = Info.get商品编号();	
					results[i][2] = Info.get商品名称();		
					results[i][3] = Info.get供货量();
					results[i][4] = Info.get供货单生成日期();
					TableColumn tableColumn = new TableColumn(table, SWT.NONE);
					tableColumn.setWidth(400);
		org.eclipse.swt.widgets.TableItem tableColumn1 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tableColumn1.setText("供货单编号");
		org.eclipse.swt.widgets.TableItem tblclmnNewColumn_0 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tblclmnNewColumn_0.setText(new String[]{results[i][0]});
		
		org.eclipse.swt.widgets.TableItem tableItem_1 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tableItem_1.setText("商品编号");
		org.eclipse.swt.widgets.TableItem tblclmnNewColumn_1 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tblclmnNewColumn_1.setText(new String[]{results[i][1]});
	
		org.eclipse.swt.widgets.TableItem tableItem_2 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tableItem_2.setText("商品名称");
		org.eclipse.swt.widgets.TableItem tblclmnNewColumn_2 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tblclmnNewColumn_2.setText(new String[]{results[i][2]});
		
		org.eclipse.swt.widgets.TableItem tableItem_3 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tableItem_3.setText("供货量");
		org.eclipse.swt.widgets.TableItem tblclmnNewColumn_3 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tblclmnNewColumn_3.setText(new String[]{results[i][3]});
		text_1.setText(results[i][4]);
		
		org.eclipse.swt.widgets.TableItem tableColumn5 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tableColumn5.setText("供货单生成日期");
		org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		tblclmnNewColumn_6.setText(new String[]{results[i][4]});
	
		org.eclipse.swt.widgets.TableItem tblclmnNewColumn_4 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		org.eclipse.swt.widgets.TableItem tblclmnNewColumn_5 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
		
		
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
