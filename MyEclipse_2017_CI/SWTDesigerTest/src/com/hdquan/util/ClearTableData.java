package com.hdquan.util;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class ClearTableData {
	public static void clearTableData(Table table)
	{
	TableItem tableItems[] = table.getItems();//�õ����е�tableItem
    for(int i = 0; i<tableItems.length; i++)
    {
        tableItems[i].dispose();//�ͷ�
    }
	}
}
