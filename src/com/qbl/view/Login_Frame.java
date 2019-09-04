package com.qbl.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qbl.dao.AdminDao;
import com.qbl.model.Admin;
import com.qbl.model.UserType;
import com.qbl.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login_Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4928091793022297521L;
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Frame frame = new Login_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Frame() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u767B\u5F55\u9875\u9762");
		label.setIcon(new ImageIcon(Login_Frame.class.getResource("/images/logo.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");

		JLabel label_2 = new JLabel("\u5BC6  \u7801\uFF1A");

		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);

		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);

		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");

		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(
				new DefaultComboBoxModel(new UserType[] { UserType.ADMIN, UserType.TEACHER, UserType.STUDENT }));

		JButton loginButton = new JButton("\u767B  \u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					loginAction(ae);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(102).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(label_3, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(label_1).addComponent(label_2, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(55)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(userTypeComboBox, 0, 141, Short.MAX_VALUE)
												.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 141,
														Short.MAX_VALUE)
												.addComponent(userNameTextField, 141, 141, 141)))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(loginButton)
										.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
										.addComponent(resetButton).addGap(20))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(83).addComponent(label,
								GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
				.addGap(78)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(label).addGap(40)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(userNameTextField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING).addComponent(label_2).addComponent(passwordTextField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(13)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(loginButton).addComponent(resetButton))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAction(ActionEvent ae) throws SQLException {
		// TODO Auto-generated method stub
		String username = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType) userTypeComboBox.getSelectedItem();

		if (StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}

		if ("系统管理员".equals(selectedItem.getName())) {
			// 系统管理员
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userNameTextField.getText());
			adminTmp.setPassword(passwordTextField.getText());
			Admin admin = adminDao.login(adminTmp);
			if (admin == null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
		} else if ("教师".equals(selectedItem.getName())) {
			// 教师

		} else {
			// 学生

		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0); // 0为系统管理员
	}
}
