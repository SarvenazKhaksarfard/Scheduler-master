/*import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Schedule_Operation extends JFrame {
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uiMain2 frame = new uiMain2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *//*
	public Schedule_Operation() {
		getContentPane().setBackground(new Color(176, 196, 222));
		setTitle("Spectrum Scheduling");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 604);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Schedule");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(210, 180, 140));
		btnNewButton.setBounds(26, 6, 174, 68);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View submitted bundles");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(212, 6, 174, 68);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View requests");
		btnNewButton_2.setBackground(new Color(119, 136, 153));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(398, 6, 174, 68);
		getContentPane().add(btnNewButton_2);
		
		Object columnNames[] = { "Nurse ID", "Assigned Bundle", "Cost (CAD)"};
		Object rowData[][] = { { "N1", "{P1, P3}", "56"}, {"B1", "P2", "80"}};
		JTable table = new JTable(rowData, columnNames);
		table.setGridColor(new Color(0, 0, 139));
		table.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		table.setRowMargin(5);
		table.setRowHeight(20);
		table.setBackground(new Color(255, 250, 240));
		
		table.setBounds(26, 117, 547, 327);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(26, 119, 546, 340);
	    //frame.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Overview");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 471, 199, 28);
		getContentPane().add(lblNewLabel);
		
		Object columnNames2[] = { "Number of received requests", "Number of assigned requests", "Total cost (CAD)"};
		Object rowData2[][] = { { "3", "3", "136"}};
		JTable table_1 = new JTable(rowData2, columnNames2);
		table_1.setShowHorizontalLines(false);
		table_1.setFillsViewportHeight(true);
		table_1.setGridColor(new Color(0, 0, 139));
		table_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		table_1.setRowMargin(5);
		table_1.setRowHeight(20);
		table_1.setBackground(new Color(255, 250, 240));
		
		table_1.setBounds(26, 491,  546, 340);
		JScrollPane scrollPane2 = new JScrollPane(table_1);
		scrollPane2.setBackground(new Color(255, 255, 255));
		scrollPane2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane2.setBounds(26, 506, 546, 44);
	    //frame.add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(scrollPane2);
		
		
		JLabel lblNurseSchedule = new JLabel("Nurse Schedule");
		lblNurseSchedule.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNurseSchedule.setBounds(26, 86, 199, 28);
		getContentPane().add(lblNurseSchedule);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenuItem mntmSchedule_1 = new JMenuItem("Schedule");
		mntmSchedule_1.setPreferredSize(new Dimension(-220, 19));
		menuBar.add(mntmSchedule_1);
		
		JMenu mnOperation = new JMenu("Insert");
		menuBar.add(mnOperation);
		
		JMenuItem mntmSchedule = new JMenuItem("Patient request");
		mnOperation.add(mntmSchedule);
		
		JMenuItem mntmInsert = new JMenuItem("Nurse bundle");
		mnOperation.add(mntmInsert);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menuBar.add(mntmHelp);
	}
}*/
