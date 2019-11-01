package com.qbl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.qbl.dao.StuClassDao;
import com.qbl.model.StuClass;
import com.qbl.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class StudentManager_Frame extends JInternalFrame {
	private JTextField searchStudentNameTextField;
	private JTable stuClassListTable;
	private JTextField editStudentNameTextField;
	private JTextField editStudentPasswordTextField;

	/**
	 * Create the frame.
	 */
	public StudentManager_Frame() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 716, 454);
		setClosable(true);// 可关闭的
		setIconifiable(true);// 可最小化

		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");

		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setColumns(10);

		JButton searchButton = new JButton("\u67E5\u8BE2");

		JScrollPane scrollPane = new JScrollPane();

		JButton resetButton = new JButton("\u91CD\u7F6E");

		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");

		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setColumns(10);

		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");

		JButton submitDeleteButton = new JButton("\u5220\u9664");

		JLabel label_2 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");

		JComboBox stuClassInfoComboBox = new JComboBox();

		JLabel label_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");

		JComboBox editStuClassInfoComboBox = new JComboBox();

		JLabel label_3 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");

		JRadioButton editStudentSexManRadioButton = new JRadioButton("\u7537");

		JRadioButton editStudentSexWomanRadioButton = new JRadioButton("\u5973");

		JLabel label_4 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");

		editStudentPasswordTextField = new JTextField();
		editStudentPasswordTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(46).addComponent(label)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 131,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(label_2).addGap(18).addComponent(stuClassInfoComboBox,
												GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(48).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup().addComponent(label_1).addGap(18)
												.addComponent(editStuClassInfoComboBox, 0, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
												.addGap(18).addComponent(editStudentNameTextField,
														GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
										.addGap(34)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_3)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(editStudentSexManRadioButton)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(editStudentSexWomanRadioButton))
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_4)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(editStudentPasswordTextField,
																GroupLayout.PREFERRED_SIZE, 126,
																GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout
										.createSequentialGroup().addGap(33).addComponent(searchButton).addGap(18)
										.addComponent(resetButton))
								.addGroup(groupLayout.createSequentialGroup().addGap(23).addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(submitDeleteButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(submitEditButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												100, Short.MAX_VALUE))))
						.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(22)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(110, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(
						28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
						.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(stuClassInfoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton).addComponent(resetButton))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3).addComponent(editStudentSexManRadioButton)
						.addComponent(editStudentSexWomanRadioButton).addComponent(submitEditButton))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
						.addComponent(editStuClassInfoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editStudentPasswordTextField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitDeleteButton))
				.addContainerGap(88, Short.MAX_VALUE)));

		stuClassListTable = new JTable();

		stuClassListTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6240\u5C5E\u73ED\u7EA7",
						"\u5B66\u751F\u6027\u522B", "\u767B\u5F55\u5BC6\u7801" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(stuClassListTable);
		getContentPane().setLayout(groupLayout);

	}
}
