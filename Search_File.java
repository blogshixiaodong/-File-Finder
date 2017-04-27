package com.File_Finder;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
public class Search_File {	
	
	private static Collection<File> collection = new ArrayList<File>();
	private File[] fileList = null;
	private DefaultTableModel dt = null;
	public static File[] listDirectory(File dir, String fileName) throws IllegalArgumentException {
	
		if(!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼��" + dir + "������.");
		}
		if(!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "����Ŀ¼");
		}
		/*
		String[] filename = dir.list();
		for (String string : filename) {
			System.out.println(dir + string);
		}*/
		File[] files = dir.listFiles();
		if(files != null && files.length > 0) {
			for (File file : files) {
				if(file.isDirectory()) {
					listDirectory(file, fileName);
					
				} else {
					if(file.getName().contains(fileName)) {
						collection.add(file);
					}	
				}
			}
		}
		return collection.toArray(new File[0]);
	}
	
	public Search_File() {
		GUIFrame guiFrame = new GUIFrame("GUI", new Point(100, 100), new Rectangle(930, 550), true, false);
		JPanel panel = new JPanel();
		JLabel fileNameLabel = new JLabel("�ļ�����");
		JLabel filePathLabel = new JLabel("�ļ�·����");
		JTextField fileNameText = new JTextField("");
		JTextField filePathText = new JTextField("");
		JButton search = new JButton("����");
		//JList jList = new JList();
		JTable table = new JTable();
		
		Vector<String> title = new Vector<String>();
		title.add("����");
		title.add("·��");
		title.add("�޸�ʱ��");
		
		
		
		//�������Ұ�ť
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String fileName = fileNameText.getText();
				String filePath = filePathText.getText();
				
				
				
				try {
					if(fileName!= null && filePath != null) {
						fileList = Search_File.listDirectory(new File(filePath), fileName);
						/**
						 * ���
						 */
						for (File f : fileList) {
							String[] strings =  {f.getName(), f.getAbsolutePath(), new Date(f.lastModified()).toString()   };
							dt.addRow(strings);
						}
						//sdf.format(f.lastModified())
					
					}
					
						
				} catch (IllegalArgumentException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "�ļ������ڻ����");
				}
			}
		});
		
		//ȡ��Ĭ��������
		panel.setLayout(null);
		//panel.setBackground(new Color(150, 150, 150));
		
		//���ÿؼ�λ��
		fileNameLabel.setBounds(20, 20, 75, 20);
		fileNameText.setBounds(100, 20, 250, 20);
		
		filePathLabel.setBounds(400, 20, 75, 20);
		filePathText.setBounds(480, 20, 250, 20);
		
		search.setBounds(800, 20, 100, 20);
		//�б���ʾ
//		//ֻ��ѡ�е���
//		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		//��ӵ����������
//		JScrollPane jScrollPane = new JScrollPane(jList);
//		jScrollPane.setBounds(20, 75, 330, 150);
		//�����ʾ
		dt = new DefaultTableModel(title, 0);
		table.setModel(dt);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(20, 75, 880, 400);
		
		
		panel.add(fileNameLabel);
		panel.add(filePathLabel);
		panel.add(fileNameText);
		panel.add(filePathText);
		panel.add(search);
		panel.add(jScrollPane);
		
		guiFrame.add(panel);
	
		guiFrame.validate();
	}
	
	
	
}
