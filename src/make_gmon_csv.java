
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Label;

/**
 * This is the main class
 * Store GUI and running the program;
 * @author Maor_Bakshi and Max
 *
 */
public class make_gmon_csv {

	private JFrame frame;
	private JTextField algo1_path_txt;
	private JButton algo_1_go_Btn;
	private JTextField algo2_path_txt1;
	private JLabel algo1_label_suc;
	private JTextField algo1_mac_txt;
	private JTextField algo2_path_txt2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					make_gmon_csv window = new make_gmon_csv();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public make_gmon_csv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Also store the gui data and functionallity.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 951, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		algo1_path_txt = new JTextField();
		algo1_path_txt.setBounds(12, 159, 298, 22);
		frame.getContentPane().add(algo1_path_txt);
		algo1_path_txt.setColumns(10);
		
		algo1_mac_txt = new JTextField();
		algo1_mac_txt.setColumns(10);
		algo1_mac_txt.setBounds(124, 194, 186, 22);
		frame.getContentPane().add(algo1_mac_txt);
		
		Label algo1_result_label = new Label("Lan: 0 Lon: 0 Alt: 0");
		algo1_result_label.setAlignment(Label.CENTER);
		algo1_result_label.setFont(new Font("Aharoni", Font.PLAIN, 17));
		algo1_result_label.setBounds(22, 298, 397, 21);
		frame.getContentPane().add(algo1_result_label);
		
		JButton algo_1_select_Btn = new JButton("Select File");
		algo_1_select_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Select a csvs folder");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);
			    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			        algo1_path_txt.setText(chooser.getSelectedFile().toString()); 
			    } else {
			        
			    }
				
			}
		});
		algo_1_select_Btn.setBounds(322, 158, 97, 25);
		frame.getContentPane().add(algo_1_select_Btn);
		
		algo_1_go_Btn = new JButton("Go");
		algo_1_go_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file_path = algo1_path_txt.getText();
				String mac = algo1_mac_txt.getText();
				Algo1 algo1 = new Algo1(file_path,mac);
				WeightRecord record = algo1.getAlgoResult();
				algo1_result_label.setText(record.toString());
				
				algo1_label_suc.setVisible(true);
				
			}
		});
		algo_1_go_Btn.setBounds(185, 228, 97, 25);
		frame.getContentPane().add(algo_1_go_Btn);
		
		algo2_path_txt1 = new JTextField();
		algo2_path_txt1.setColumns(10);
		algo2_path_txt1.setBounds(496, 159, 298, 22);
		frame.getContentPane().add(algo2_path_txt1);
		
		JButton algo_2_select_Btn1 = new JButton("Select File");
		algo_2_select_Btn1.setBounds(806, 158, 97, 25);
		algo_2_select_Btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Select a csv file");
			    //FileNameExtensionFilter filter = new FileNameExtensionFilter("csv");
			    //chooser.setFileFilter(filter);
			    chooser.setAcceptAllFileFilterUsed(false);
			    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			    	String file_path = chooser.getSelectedFile().toString();
			    	algo2_path_txt1.setText(file_path); 
			    } else {
			        
			    }
				
			}
		});
		frame.getContentPane().add(algo_2_select_Btn1);
		
		JLabel lblSelectFolderWhich = new JLabel("Select with gps csv file");
		lblSelectFolderWhich.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectFolderWhich.setBounds(496, 124, 178, 22);
		frame.getContentPane().add(lblSelectFolderWhich);
		
		JLabel lblSelectCsvFile = new JLabel("Select csv file");
		lblSelectCsvFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectCsvFile.setBounds(12, 124, 422, 22);
		frame.getContentPane().add(lblSelectCsvFile);
		
		JLabel lblWelcomeToThe = new JLabel("Algorithm 1");
		lblWelcomeToThe.setForeground(new Color(0, 139, 139));
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeToThe.setBounds(150, 24, 109, 30);
		frame.getContentPane().add(lblWelcomeToThe);
		
		algo1_label_suc = new JLabel("Success");
		algo1_label_suc.setFont(new Font("Tahoma", Font.BOLD, 14));
		algo1_label_suc.setForeground(new Color(0, 128, 0));
		algo1_label_suc.setBounds(22, 194, 69, 21);
		algo1_label_suc.setVisible(false);
		frame.getContentPane().add(algo1_label_suc);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(415, 277, 48, -264);
		frame.getContentPane().add(separator);
		
		JLabel lblAlgorithm = new JLabel("Algorithm 2");
		lblAlgorithm.setForeground(new Color(0, 139, 139));
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlgorithm.setBounds(641, 24, 109, 30);
		frame.getContentPane().add(lblAlgorithm);
		

		
		JLabel lblEnterMac = new JLabel("Enter Mac");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterMac.setBounds(322, 193, 120, 22);
		frame.getContentPane().add(lblEnterMac);
		
		JLabel lblSelectWithoutGps = new JLabel("Select without gps csv file");
		lblSelectWithoutGps.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectWithoutGps.setBounds(496, 228, 212, 22);
		frame.getContentPane().add(lblSelectWithoutGps);
		
		algo2_path_txt2 = new JTextField();
		algo2_path_txt2.setColumns(10);
		algo2_path_txt2.setBounds(496, 272, 298, 22);
		frame.getContentPane().add(algo2_path_txt2);
		
		JLabel algo2_label_suc = new JLabel("Success");
		algo2_label_suc.setForeground(new Color(34, 139, 34));
		algo2_label_suc.setFont(new Font("Tahoma", Font.BOLD, 14));
		algo2_label_suc.setBounds(496, 318, 83, 25);
		frame.getContentPane().add(algo2_label_suc);
		algo2_label_suc.setVisible(false);
		
		JButton algo_2_select_Btn2 = new JButton("Select File");
		algo_2_select_Btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Select a csv file");
			    //FileNameExtensionFilter filter = new FileNameExtensionFilter("csv");
			    //chooser.setFileFilter(filter);
			    chooser.setAcceptAllFileFilterUsed(false);
			    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			    	String file_path = chooser.getSelectedFile().toString();
			    	algo2_path_txt2.setText(file_path); 
			    } else {
			        
			    }
			}
		});
		algo_2_select_Btn2.setBounds(806, 271, 97, 25);
		frame.getContentPane().add(algo_2_select_Btn2);
		
		JButton algo_2_go_Btn2 = new JButton("Go");
		algo_2_go_Btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data_file_path = algo2_path_txt1.getText();
				String input_file_path = algo2_path_txt2.getText();
				Algo2 algo2 = new Algo2(data_file_path,input_file_path);
				//CsvFile file = algo2.getCsvInputFile();
				CsvFile file = algo2.calculateNewGPSFile();
				Path p = Paths.get(input_file_path);
				String newFilePath = p.getParent().toString();
				file.writeToCsv(newFilePath + "\\NewData.csv");
				
				algo2_label_suc.setVisible(true);
			}
		});
		algo_2_go_Btn2.setBounds(641, 318, 97, 25);
		frame.getContentPane().add(algo_2_go_Btn2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(446, 24, 23, 431);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setToolTipText("");
		separator_2.setBounds(301, 298, -270, 15);
		frame.getContentPane().add(separator_2);
		

		

		
		
	}
}
