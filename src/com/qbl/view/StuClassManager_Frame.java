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

public class StuClassManager_Frame extends JInternalFrame {
	private JTextField searchClassNameTextField;
	private JTable stuClassListTable;
	private JTextField editStuClassNameTextField;
	private JTextArea editStuClassInfoTextArea;

	/**
	 * Create the frame.
	 */
	public StuClassManager_Frame() {
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 557, 454);
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

		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");

		JLabel label_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");

		editStuClassNameTextField = new JTextField();
		editStuClassNameTextField.setColumns(10);

		editStuClassInfoTextArea = new JTextArea();

		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});

		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitDeleteAct(ae);
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
								.addGroup(
										groupLayout.createSequentialGroup().addContainerGap().addComponent(
												scrollPane, GroupLayout.PREFERRED_SIZE, 510,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(48)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel).addComponent(label_1))
										.addGap(39)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(editStuClassNameTextField, GroupLayout.PREFERRED_SIZE,
														133, GroupLayout.PREFERRED_SIZE)
												.addComponent(editStuClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 133,
														GroupLayout.PREFERRED_SIZE))
										.addGap(63)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(96)))
						.addContainerGap(21, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton).addComponent(resetButton))
				.addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(editStuClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(editStuClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(submitDeleteButton)))
				.addContainerGap(82, Short.MAX_VALUE)));

		stuClassListTable = new JTable();
		stuClassListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectTableRow(me);
			}
		});
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

	protected void submitDeleteAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int index = stuClassListTable.getSelectedRow();
		if (index == -1) {// 未选中时，为-1
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！！！");
			return;
		}
		if (JOptionPane.showConfirmDialog(this, "确认要删除吗？") == JOptionPane.OK_OPTION) {
			DefaultTableModel dft = (DefaultTableModel) stuClassListTable.getModel();
			int id = Integer.parseInt(dft.getValueAt(stuClassListTable.getSelectedRow(), 0).toString());
			StuClassDao<StuClass> stuClassDao = new StuClassDao<StuClass>();
			if (stuClassDao.delete(id)) {
				JOptionPane.showMessageDialog(this, "删除成功！");
			} else {
				JOptionPane.showMessageDialog(this, "删除失败！");
			}
			stuClassDao.closeDao();
			setTable(new StuClass());
		} else {
			return;
		}
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int index = stuClassListTable.getSelectedRow();
		if (index == -1) {// 未选中时，为-1
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！！！");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) stuClassListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(stuClassListTable.getSelectedRow(), 0).toString());
		String stuClassName = dft.getValueAt(stuClassListTable.getSelectedRow(), 1).toString();
		String stuClassInfo = dft.getValueAt(stuClassListTable.getSelectedRow(), 2).toString();
		String editStuClassName = editStuClassNameTextField.getText();
		String editStuClassInfo = editStuClassInfoTextArea.getText();
		if (stuClassName.equals(editStuClassName) && stuClassInfo.equals(editStuClassInfo)) {
			JOptionPane.showMessageDialog(this, "还未进行任何修改");
			return;
		}
		if(StringUtil.isEmpty(editStuClassName)) {
			JOptionPane.showMessageDialog(this, "班级姓名不可为空");
			return;
		}
		if (JOptionPane.showConfirmDialog(this, "确认要更改吗？") == JOptionPane.OK_OPTION) {
			StuClass stuClass = new StuClass();
			stuClass.setId(id);
			stuClass.setName(editStuClassName);
			stuClass.setInfo(editStuClassInfo);
			StuClassDao<StuClass> stuClassDao = new StuClassDao<StuClass>();
			if (stuClassDao.update(stuClass)) {
				JOptionPane.showMessageDialog(this, "更新成功！");
				editStuClassNameTextField.setText("");
				editStuClassInfoTextArea.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "更新失败！");
			}
			stuClassDao.closeDao();
			setTable(new StuClass());
		} else {
			return;
		}
	}

	protected void selectTableRow(MouseEvent me) {
		// 获取界面模型
		DefaultTableModel dft = (DefaultTableModel) stuClassListTable.getModel();
		// 获取选中行数据
		editStuClassNameTextField.setText(dft.getValueAt(stuClassListTable.getSelectedRow(), 1).toString());
		editStuClassInfoTextArea.setText(dft.getValueAt(stuClassListTable.getSelectedRow(), 2).toString());
	}

	private void setTable(StuClass stuClass) {// 更新表格数据
		// 获取界面模型
		DefaultTableModel dft = (DefaultTableModel) stuClassListTable.getModel();
		dft.setRowCount(0);

		StuClassDao<StuClass> stuClassDao = new StuClassDao<StuClass>();
		try {
			List<StuClass> classList = stuClassDao.getStuClassList(stuClass);
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
		stuClassDao.closeDao();
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		searchClassNameTextField.setText("");
	}
}
