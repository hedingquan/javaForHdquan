package com.hdquan.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

public class AddButton{
	public static  void Add01(Table table)
	{
	org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
	tblclmnNewColumn_6.setText("交易流水号");
	}
	public  void Add02(Table table)
	{
	org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
	tblclmnNewColumn_6.setText("商品编号");
	}
	public  void Add03(Table table)
	{
	org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
	tblclmnNewColumn_6.setText("退货金额");
	}
	public  void Add04(Table table)
	{
	org.eclipse.swt.widgets.TableItem tblclmnNewColumn_6 = new org.eclipse.swt.widgets.TableItem(table, SWT.NONE);
	tblclmnNewColumn_6.setText("退货数量");
	}
}
