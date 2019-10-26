package com.qbl.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.TexturePaint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qbl.model.UserType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;

public class Main_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;

	/**
	 * Create the frame.
	 */
	public Main_Frame(UserType userType, Object userObject) {
		Main_Frame.userType = userType;
		Main_Frame.userObject = userObject;

		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 622);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 修改密码
				EditPassword_Frame editPassword_Frame = new EditPassword_Frame();
				editPassword_Frame.setVisible(true);
				desktopPane.add(editPassword_Frame);
			}
		});
		menuItem.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 退出系统
				if (JOptionPane.showConfirmDialog(Main_Frame.this, "确认退出吗?") == JOptionPane.OK_OPTION) {
					System.exit(0);// 结束当前正在运行的java虚拟机；0表示正常退出；非0表示异常退出，常用于catch中；
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u9000\u51FA.png")));
		menu.add(menuItem_1);

		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		menuBar.add(menu_1);

		JMenuItem menuItem_2 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 学生添加
				AddStudent_Frame addStudent_Frame = new AddStudent_Frame();
				addStudent_Frame.setVisible(true);
				desktopPane.add(addStudent_Frame);
			}
		});
		menuItem_2.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_1.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u4FE1\u606F");
		menuItem_3.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		menu_1.add(menuItem_3);

		JMenu mnNewMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 班级添加
				AddStuClass_Frame addStuClass_Frame = new AddStuClass_Frame();
				addStuClass_Frame.setVisible(true);
				desktopPane.add(addStuClass_Frame);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u6DFB\u52A0.png")));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem menuItem_4 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 班级管理
				StuClassManager_Frame stuClassManager_Frame = new StuClassManager_Frame();
				stuClassManager_Frame.setVisible(true);
				desktopPane.add(stuClassManager_Frame);
			}
		});
		menuItem_4.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		mnNewMenu.add(menuItem_4);

		JMenu menu_2 = new JMenu("\u5E2E\u52A9");
		menu_2.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u5E2E\u52A9.png")));
		menuBar.add(menu_2);

		JMenuItem menuItem_5 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 关于我们
				try {
					Desktop.getDesktop().browse(new URI("https://www.baidu.com/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		menuItem_5.setIcon(new ImageIcon(Main_Frame.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menu_2.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 128, 128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);// 居中
	}
}
