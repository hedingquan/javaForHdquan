package com.hdquan.util;

import java.awt.event.KeyAdapter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TableEdit {
	public static void tableEdit(Table table)
	{
//		final TableEditor editor = new TableEditor(table);
//		Text newEditor = new Text(table, SWT.NONE);
//		// The editor must have the same size as the cell and must
//		// not be any smaller than 50 pixels.
//		editor.horizontalAlignment = SWT.LEFT;
//		editor.grabHorizontal = true;
//		editor.minimumWidth = 50;
//		table.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				// Clean up any previous editor control
//				Control oldEditor = editor.getEditor();
//				if (oldEditor != null)
//					oldEditor.dispose();
// 
//				// Identify the selected row
//				final TableItem item = (TableItem) e.item;
//				if (item == null)
//					return;
// 
//				int index = table.getSelectionIndex();
//				
//					
//					newEditor.setText(item.getText(i));
//					
//					newEditor.addModifyListener(new ModifyListener() {
//						public void modifyText(ModifyEvent me) {
//							Text text = (Text) editor.getEditor();
//							editor.getItem().setText(i,
//									text.getText());
//							values.setText(text.getText());
////							System.out.println(values.getText());
//						}
//					});
//					
//					
//					newEditor.selectAll();
//					newEditor.setFocus();
//					editor.setEditor(newEditor, item, i);
//					
//				}
//		});
		
		
		
		
		
		
		table.addListener(SWT.MeasureItem, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				event.width=98;
				event.height=(int )Math.floor(event.gc.getFontMetrics().getHeight()*1.5);
			}
		});
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseDown(MouseEvent e) {
			TableEditor editor=new TableEditor(table);
			Control old=editor.getEditor();
			if(old!=null)
				old.dispose();
			Point pt=new Point(e.x,e.y);
			final TableItem item=table.getItem(pt);
			if(null==item)
			{
				return;
			}
			int column=-1;
			for(int i=0,n=table.getColumnCount();i<n;i++)
			{
				Rectangle rect=item.getBounds(i);
				if(rect.contains(pt))
				{
					column=i;
					break;
				}
			}
			if(column==0)
			{return;}
			
			final Text text=new Text(table,SWT.NONE);
			text.setForeground(item.getForeground());
			text.setText(item.getText(column));
			text.selectAll();
			text.setSize(100, table.getItemHeight());
			text.setFocus();
			editor.setEditor(text, item, column);
			editor.minimumWidth=90;
			editor.minimumHeight=20;
			final int col=column;
			text.addModifyListener(new ModifyListener() {
				
				@Override
				public void modifyText(ModifyEvent arg0) {
					// TODO Auto-generated method stub
					item.setText(col, text.getText());
					
				}
			});
			text.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent arg0) {
					// TODO Auto-generated method stub
					text.setForeground(item.getForeground());
				}
				
				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			super.mouseDown(e);
		}
		
		});
		}
}
