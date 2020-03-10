package com.hdquan.View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import com.hdquan.dao.Supermarket_Management;

public class 退货界面 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			退货界面 window = new 退货界面();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(42, 10, 80, 27);
		button.setText("\u4EA4\u6613\u6D41\u6C34\u53F7");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(186, 10, 111, 27);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(42, 55, 80, 27);
		btnNewButton.setText("\u5546\u54C1\u7F16\u53F7");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(186, 59, 111, 23);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(42, 105, 80, 27);
		btnNewButton_1.setText("\u9000\u8D27\u6570\u91CF");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(186, 105, 111, 27);
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(42, 162, 80, 27);
		btnNewButton_2.setText("\u9000\u8D27\u91D1\u989D");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(186, 166, 111, 23);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(265, 224, 80, 27);
		button_1.setText("\u9000\u8D27");
		
		 button_1.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(final SelectionEvent e)
				{	
					 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					 try {
						Supermarket_Management.AddBack(text.getText(), text_1.getText(),text_3.getText() , text_2.getText(), df.format(new Date()));

					 } catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//			shell.dispose();
			退货信息表 退货信息表=new 退货信息表();
			退货信息表.open();
				}
		 });
	}
}
