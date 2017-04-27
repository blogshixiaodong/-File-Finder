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
	 * 构造函数
	 * @param Title 窗口标题
	 * @param point 窗口左上角坐标
	 * @param rectangle 窗口宽高
	 * @param isShow 是否显示
	 * @param isResize 是否可调整窗口大小
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
		//设置标题
		setTitle(Title);
		//设置位置以及宽高
		setBounds(point.x, point.y, rectangle.width, rectangle.height);
		//设置可见性
		setVisible(isShow);
		//设置可调整性
		setResizable(isResize);	
		//设置关闭操作
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	

}
