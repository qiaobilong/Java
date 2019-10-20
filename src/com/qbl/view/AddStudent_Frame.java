package com.qbl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddStudent_Frame extends JInternalFrame {
	private JTextField studentNameTextField;
	private JTextField studentPasswordTextField;
	private JTextField studentSexTextField;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public AddStudent_Frame() {
		setTitle("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		setBounds(100, 100, 449, 241);
		setClosable(true);// 可关闭的
		setIconifiable(true);// 可最小化
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		
		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(10);
		
		studentPasswordTextField = new JTextField();
		studentPasswordTextField.setColumns(10);
		
		studentSexTextField = new JTextField();
		studentSexTextField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblid = new JLabel("\u73ED\u7EA7ID\uFF1A");
		
		JButton button = new JButton("\u786E\u8BA4\u63D0\u4EA4");
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(label_2)
							.addComponent(label_1)
							.addComponent(label))
						.addComponent(lblid))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(studentPasswordTextField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentSexTextField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
					.addGap(82))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(studentPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(button)))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(studentSexTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
