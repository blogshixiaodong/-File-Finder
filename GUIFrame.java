package com.File_Finder;

import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;



public class GUIFrame extends JFrame implements ActionListener {
	private String Title;
	private Point point;
	private Rectangle rectangle;
	private boolean isShow = true;
	private boolean isResize = true;
	/**
	 * ���캯��
	 * @param Title ���ڱ���
	 * @param point �������Ͻ�����
	 * @param rectangle ���ڿ��
	 * @param isShow �Ƿ���ʾ
	 * @param isResize �Ƿ�ɵ������ڴ�С
	 */
	public GUIFrame(String Title, Point point, Rectangle rectangle, boolean isShow, boolean isResize) {
		this.Title = Title;
		this.point = point;
		this.rectangle = rectangle;
		this.isShow = isShow;
		this.isResize = isResize;
		initialization();
	}
	
	private void initialization() {
		//���ñ���
		setTitle(Title);
		//����λ���Լ����
		setBounds(point.x, point.y, rectangle.width, rectangle.height);
		//���ÿɼ���
		setVisible(isShow);
		//���ÿɵ�����
		setResizable(isResize);	
		//���ùرղ���
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	

}
