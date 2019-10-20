package com.qbl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.qbl.dao.StuClassDao;
import com.qbl.model.StuClass;
import com.qbl.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddStuClass_Frame extends JInternalFrame {
	private JTextField stuClassNameTextField;
	private JTextField stuClassInfoTextField;

	/**
	 * Create the frame.
	 */
	public AddStuClass_Frame() {
		setTitle("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		setClosable(true);// 可关闭的
		setIconifiable(true);// 可最小化

		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");

		JLabel label_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");

		stuClassNameTextField = new JTextField();
		stuClassNameTextField.setColumns(10);

		stuClassInfoTextField = new JTextField();
		stuClassInfoTextField.setColumns(10);

		JButton confirmButton = new JButton("\u63D0\u4EA4");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					submitStuClass(ae);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValues(ae);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(71)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(confirmButton)
														.addPreferredGap(ComponentPlacement.RELATED, 84,
																Short.MAX_VALUE)
														.addComponent(resetButton))
										.addGroup(groupLayout.createSequentialGroup().addComponent(label_1).addGap(18)
												.addComponent(stuClassInfoTextField))
										.addGroup(groupLayout.createSequentialGroup().addComponent(label).addGap(18)
												.addComponent(stuClassNameTextField, GroupLayout.PREFERRED_SIZE, 156,
														GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(129, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(49)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(stuClassNameTextField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						stuClassInfoTextField, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(confirmButton)
						.addComponent(resetButton))
				.addContainerGap(34, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	protected void submitStuClass(ActionEvent ae) throws SQLException {
		// TODO Auto-generated method stub
		StuClass stuClass = new StuClass();
//		if ("".equals(stuClassNameTextField) || stuClassNameTextField == null) {
		if (StringUtil.isEmpty(stuClassNameTextField.getText())) {// 2019-10-18获取具体内容后，再判断是否为空
			JOptionPane.showMessageDialog(this, "班级姓名不能为空！");
			return;
		}
		stuClass.setName(stuClassNameTextField.getText());
		stuClass.setInfo(stuClassInfoTextField.getText());
		StuClassDao stuClassDao = new StuClassDao();
		if (stuClassDao.addStuClass(stuClass)) {
			JOptionPane.showMessageDialog(this, "提交成功！");
			stuClassNameTextField.setText("");
			stuClassInfoTextField.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "提交失败！");
		}
		stuClassDao.closeDao();// 关闭数据库连接
	}

	protected void resetValues(ActionEvent ae) {
		// TODO Auto-generated method stub
		stuClassNameTextField.setText("");
		stuClassInfoTextField.setText("");
	}
}
