package com.qbl.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qbl.model.UserType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPassword_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;
	private UserType userType;
	private Object userObject;

	/**
	 * Create the frame.
	 */
	public EditPassword_Frame(UserType userType, Object userObject) {
		this.userType = userType;
		this.userObject = userObject;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

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
				
			}
		});

		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
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

	protected void resetValue(ActionEvent ae) {
		// 重置修改密码界面
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
