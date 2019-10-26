package com.qbl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent_Frame extends JInternalFrame {
	private JTextField studentNameTextField;
	private JPasswordField studentPasswordField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton studentSexManRadioButton;
	private JRadioButton studentSexWomanRadioButton;

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

		JLabel lblid = new JLabel("\u73ED\u7EA7ID\uFF1A");

		JButton button = new JButton("\u786E\u8BA4\u63D0\u4EA4");

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 重置
				studentNameTextField.setText("");
				studentPasswordField.setText("");
				sexButtonGroup.clearSelection();// 清除选择
				studentSexManRadioButton.setSelected(true);// 设置默认选项
			}
		});

		JComboBox stuClassIdComboBox = new JComboBox();

		studentPasswordField = new JPasswordField();

		studentSexManRadioButton = new JRadioButton("\u7537");
		studentSexManRadioButton.setSelected(true);

		studentSexWomanRadioButton = new JRadioButton("\u5973");

		// 建立一个button分组，一个分组里只能选一个
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(studentSexManRadioButton);
		sexButtonGroup.add(studentSexWomanRadioButton);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(47)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(label_2)
										.addComponent(label_1).addComponent(label))
								.addComponent(lblid))
						.addGap(35)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(studentPasswordField)
												.addComponent(stuClassIdComboBox, 0, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(studentNameTextField, GroupLayout.DEFAULT_SIZE, 146,
														Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addGap(16)
												.addComponent(studentSexManRadioButton).addGap(29)
												.addComponent(studentSexWomanRadioButton)))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addGap(82)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(36)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
								studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(studentPasswordField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(62).addComponent(button)))
				.addGap(19)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2).addComponent(button_1)
								.addComponent(studentSexWomanRadioButton).addComponent(studentSexManRadioButton))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid).addComponent(
						stuClassIdComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addContainerGap(40, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
}
