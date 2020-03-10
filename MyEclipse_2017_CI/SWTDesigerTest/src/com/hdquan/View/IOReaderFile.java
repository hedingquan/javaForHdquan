package com.hdquan.View;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.hdquan.util.Readfile;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import java.awt.Frame;
import org.eclipse.swt.awt.SWT_AWT;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class IOReaderFile {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtNewText=null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IOReaderFile window = new IOReaderFile();
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
		shell.setSize(798, 426);
		shell.setText("SWT Application");

		Readfile Readfile=new Readfile();
		try {
			

			Button button = new Button(shell, SWT.NONE);
			button.setBounds(702, 0, 80, 27);
			button.setText("\u8FD4\u56DE");
			
			txtNewText = formToolkit.createText(shell, "New Text", SWT.WRAP|SWT.V_SCROLL);
			txtNewText.setBounds(0, 0, 697, 387);
			Readfile.readfile(txtNewText);
			
			
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(final SelectionEvent e){
					
					shell.dispose();
					book book=new book();
					book.open();
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
