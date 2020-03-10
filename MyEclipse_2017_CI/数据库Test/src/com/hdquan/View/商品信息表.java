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


import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.Supermarket_Management;
import com.hdquan.util.TableEdit;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class 商品信息表 {

	protected Shell shell;
	private Table table;
	private TableColumn tblclmnNewColumn;
	private TableColumn tableColumn;
	private TableColumn tableColumn_1;
	private TableColumn tableColumn_2;
	private TableColumn tableColumn_3;
	private TableColumn tableColumn_4;
	private TableColumn tableColumn_5;
	private Text text;
	private MenuItem menuItem_1;
	private MenuItem menuItem_2;
	private MenuItem menuItem_3;
	private MenuItem menuItem_4;
	private Button button;
	private Button button_1;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			商品信息表 window = new 商品信息表();
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
		shell.setSize(729, 479);
		shell.setText("商品信息表");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.CHECK);
		table.setBounds(0, 31, 698, 380);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("\u5546\u54C1\u7F16\u53F7");
		
		tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u5546\u54C1\u540D\u79F0");
		
		tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u5546\u54C1\u6761\u5F62\u7801");
		
		tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u5546\u54C1\u7C7B\u522B");
		
		tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u5546\u54C1\u552E\u4EF7");
		
		tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("\u5E93\u5B58\u91CF");
		
		tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("\u544A\u8B66\u91CF");
		
		
		button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(602, 0, 80, 27);
		button_1.setText("\u6DFB\u52A0\u5546\u54C1");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("\u5546\u54C1\u4EA4\u6613\u60C5\u51B5");
		
		menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.setText("\u4F1A\u5458\u8868");
		
		menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.setText("\u8D2D\u4E70\u5546\u54C1");
		
		menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.setText("\u4F9B\u8D27\u5355");
		
		menuItem_4 = new MenuItem(menu, SWT.NONE);
		menuItem_4.setText("\u9000\u8D27\u5355");
		
		text = new Text(shell, SWT.BORDER);
		text.setText("\t\t\t\t\t\u5546\u54C1\u9500\u552E\u60C5\u51B5");
		text.setBounds(0, 0, 596, 36);
		TableEdit.tableEdit(table);
		String results1[]=new String[9];
		List<com.hdquan.pojo.商品信息表> selInfo;
		try {
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
					results1[0]=results[i][0];
					org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
					tblclmnNewColumn_6.setText(new String[]{results[i][0],results[i][1],results[i][2],results[i][3],results[i][4],results[i][5],results[i][6]});
			}
			org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
			tblclmnNewColumn_6.setText(new String[]{});
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		button_1.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(final SelectionEvent e)
		{	
			int ww=table.getItemCount();
			for(int bb=0;bb<ww;bb++)
				if(table.getItem(bb).getChecked()==true)
				{
//					System.out.println(results1[0]);
					results1[1]=table.getItem(bb).getText(1);
					results1[2]=table.getItem(bb).getText(2);
					results1[3]=table.getItem(bb).getText(3);
					results1[4]=table.getItem(bb).getText(4);
					results1[5]=table.getItem(bb).getText(5);
					results1[6]=table.getItem(bb).getText(6);
//					System.out.println(results1[0]+table.getItem(bb).getText(1)+table.getItem(bb).getText(2)+table.getItem(bb).getText(3));
				}
			try {
				Supermarket_Management.AddInfo(results1[0],results1[1],results1[2],results1[3],results1[4],results1[5],results1[6]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		});
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e)
			{	
				shell.dispose();
				会员表 会员表=new 会员表();
				会员表.open();
			}
		});
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e)
			{	
				购买商品 购买商品=new 购买商品();
				购买商品.open();
			}	
	});
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e)
			{	
				shell.dispose();
				供货表 供货表=new 供货表();
				供货表.open();
			}	
	});
		

	}
}