package com.qbl.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qbl.dao.AdminDao;
import com.qbl.model.Admin;
import com.qbl.model.UserType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditPassword_Frame extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;

	/**
	 * Create the frame.
	 */
	public EditPassword_Frame() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);// 可关闭的
		setIconifiable(true);// 可最小化

		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");

		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);

		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");

		JLabel lblNewLabel = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");

		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);

		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);

		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 确认提交
				try {
					submitEdit(ae);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 重置界面
				resetValue(ae);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(65)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
								.addComponent(label_1).addComponent(label))
						.addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(newPasswordTextField).addComponent(confirmPasswordTextField)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(button).addGap(80).addComponent(button_1)))
				.addContainerGap(105, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(60)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(oldPasswordTextField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(button_1).addComponent(button))
				.addGap(26)));
		contentPane.setLayout(gl_contentPane);
	}

	protected void submitEdit(ActionEvent ae) throws SQLException {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String confirmPassword = confirmPasswordTextField.getText().toString();
		if ("".equals(oldPassword) || oldPassword == null) {
			JOptionPane.showMessageDialog(this, "请填写旧密码");
			return;
		}
		if ("".equals(newPassword) || newPassword == null) {
			JOptionPane.showMessageDialog(this, "请填写新密码");
			return;
		}
		if ("".equals(confirmPassword) || confirmPassword == null) {
			JOptionPane.showMessageDialog(this, "请填写确认新密码");
			return;
		}
		if (!newPassword.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新填写");
			return;
		}
		if ("系统管理员".equals(Main_Frame.userType.getName())) {
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin) Main_Frame.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			return;
		}

	}

	protected void resetValue(ActionEvent ae) {
		// 重置修改密码界面
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
