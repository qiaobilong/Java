package com.qbl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
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

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class StuClassManager_Frame extends JInternalFrame {
	private JTextField searchClassNameTextField;
	private JTable stuClassListTable;

	/**
	 * Create the frame.
	 */
	public StuClassManager_Frame() {
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 544, 446);
		setClosable(true);// 可关闭的
		setIconifiable(true);// 可最小化

		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");

		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);

		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				StuClass stuClass = new StuClass();
				stuClass.setName(searchClassNameTextField.getText().toString());
				setTable(stuClass);
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(46).addComponent(label)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 171,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(searchButton)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(resetButton))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton).addComponent(resetButton))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(20, Short.MAX_VALUE)));

		stuClassListTable = new JTable();
		stuClassListTable.setModel(new DefaultTableModel(new StuClass[][] {},
				new String[] { "\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		stuClassListTable.getColumnModel().getColumn(2).setPreferredWidth(184);
		scrollPane.setViewportView(stuClassListTable);
		getContentPane().setLayout(groupLayout);

		// 打开界面直接显示所有数据
		setTable(new StuClass());
	}

	private void setTable(StuClass stuClass) {
		// 获取界面模型
		DefaultTableModel dft = (DefaultTableModel) stuClassListTable.getModel();
		dft.setRowCount(0);

		StuClassDao<StuClass> stuClassDao = new StuClassDao<StuClass>();
		try {
			List<StuClass> classList = stuClassDao.getClassList(stuClass);
			for (StuClass sc : classList) {
				Vector v = new Vector();
				v.add(sc.getId());
				v.add(sc.getName());
				v.add(sc.getInfo());
				dft.addRow(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		searchClassNameTextField.setText("");
	}
}
