package gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import net.sourceforge.jeval.EvaluationException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringEscapeUtils;

import com.stevesoft.pat.Regex;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import logic.CheckTxtRegex;
import logic.CheckTxtRegexMethods;

public class GUI_Hauptanwendung extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	final JTree tree;
	JLabel lab2;
	TreeMap <String, String>values = new TreeMap<String,String>();
	private JTextField textField_7;
	private JTextField textField_8;
	String [][]results;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Hauptanwendung frame = new GUI_Hauptanwendung();
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
	public GUI_Hauptanwendung() {

		//loadConfiguration("leer.properties");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 850);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLoad = new JButton("Load Configuration...");
		btnLoad.setBounds(297, 98, 208, 23);
		btnLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Chooser frame = new Chooser();
				//System.out.println(frame.fileName);
				returnthis().loadConfiguration(frame.fileName);
				
			}

		});

		contentPane.add(btnLoad);

		JButton btnNewButton = new JButton("Load Default Configurations");
		btnNewButton.setBounds(57, 98, 208, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 File f = new File("");
			        String p = f.getAbsolutePath();
			        //System.out.println(p);
			        p = p.substring(0, p.lastIndexOf(System.getProperty("file.separator")));
			        //System.out.println(p);
			     String teiler = System.getProperty("file.separator");
			    //System.out.println(""+GUI_Hauptanwendung.class.getResource(""));
			    String hilf = ""+GUI_Hauptanwendung.class.getResource("default.properties");
				returnthis().loadConfiguration(hilf);
			}

		});

		contentPane.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 144, 964, 8);
		contentPane.add(separator);

		tree = new JTree();
		tree.setBounds(20, 195, 329, 391);
		final DefaultMutableTreeNode node_1;
		DefaultMutableTreeNode node_2;
		final DefaultMutableTreeNode node_3;
		DefaultMutableTreeNode node_4;
		DefaultMutableTreeNode node_5;
		final DefaultMutableTreeNode node_6;
		final DefaultMutableTreeNode node_7;
		DefaultMutableTreeNode node_8;
		DefaultMutableTreeNode node_9;
		DefaultMutableTreeNode node_10;
		DefaultMutableTreeNode node_11;
		DefaultMutableTreeNode node_12;
		DefaultMutableTreeNode node_13;
		DefaultMutableTreeNode node_14;
		DefaultMutableTreeNode node_15;
		DefaultMutableTreeNode node_16;
		final DefaultMutableTreeNode node_17;
		final DefaultMutableTreeNode node_18;
		DefaultMutableTreeNode node_19;
		DefaultMutableTreeNode node_20;
		DefaultMutableTreeNode node_21;
		DefaultMutableTreeNode node_22;
		DefaultMutableTreeNode node_23;
		DefaultMutableTreeNode node_24;

		DefaultMutableTreeNode test = new DefaultMutableTreeNode("Tests");
		node_1 = new DefaultMutableTreeNode("2.1 OS metadata");
		node_2 = new DefaultMutableTreeNode("2.1.a Kernel version");

		node_3 = new DefaultMutableTreeNode("2.2 Check resource information");
		node_4 = new DefaultMutableTreeNode("2.2.a Get CPU information");
		node_5 = new DefaultMutableTreeNode("2.2.b Get memory information");
		node_6 = new DefaultMutableTreeNode("2.2.c Get disk information");

		node_7 = new DefaultMutableTreeNode("2.3 Connectivity");
		node_8 = new DefaultMutableTreeNode("2.3.a Network interfaces");
		node_9 = new DefaultMutableTreeNode("2.3.b IP address");
		node_10 = new DefaultMutableTreeNode("2.3.c Firewall rules");
		node_11 = new DefaultMutableTreeNode("2.3.d Routing");
		node_12 = new DefaultMutableTreeNode(
				"2.3.e ICMP connectivity (private IP)");
		node_13 = new DefaultMutableTreeNode(
				"2.3.f ICMP connectivity (public IP)");
		node_14 = new DefaultMutableTreeNode(
				"2.3.g DNS reverse lookup (private IP)");
		node_15 = new DefaultMutableTreeNode(
				"2.3.h DNS reverse lookup (public IP)");
		node_16 = new DefaultMutableTreeNode(
				"2.3.i Remote Shell process running");
		node_17 = new DefaultMutableTreeNode(
				"2.3.j Remote Shell Port available");

		node_18 = new DefaultMutableTreeNode(
				"2.4 Check file system and user management");
		node_19 = new DefaultMutableTreeNode("2.4.a Add dummy user");
		node_20 = new DefaultMutableTreeNode("2.4.b Write into a test file");
		node_21 = new DefaultMutableTreeNode("2.4.c Read from a test file");
		node_22 = new DefaultMutableTreeNode(
				"2.4.d Delete the test file");
		node_23 = new DefaultMutableTreeNode("2.4.e Check if the user management is working_correctly");
		node_24 = new DefaultMutableTreeNode("2.4.f Delete a dummy user");

		node_1.add(node_2);
		test.add(node_1);

		node_3.add(node_4);
		node_3.add(node_5);
		node_3.add(node_6);
		test.add(node_3);

		node_7.add(node_8);
		node_7.add(node_9);
		node_7.add(node_10);
		node_7.add(node_11);
		node_7.add(node_12);
		node_7.add(node_13);
		node_7.add(node_14);
		node_7.add(node_15);
		node_7.add(node_16);
		node_7.add(node_17);
		test.add(node_7);

		node_18.add(node_19);
		node_18.add(node_20);
		node_18.add(node_21);
		node_18.add(node_22);
		node_18.add(node_23);
		node_18.add(node_24);
		test.add(node_18);

		DefaultTreeModel treemodel = new DefaultTreeModel(test);
		tree.setModel(treemodel);

		tree.addTreeExpansionListener(new TreeExpansionListener() {

			@Override
			public void treeCollapsed(TreeExpansionEvent arg0) {
				TreePath path = arg0.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();

				
			}

			@Override
			public void treeExpanded(TreeExpansionEvent arg0) {

				TreePath path = arg0.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();

				if (node.equals(node_1)) {

					TreeNode[] path1 = node_3.getPath();
					TreePath treePath1 = new TreePath(path1);
					tree.collapsePath(treePath1);

					TreeNode[] path2 = node_7.getPath();
					TreePath treePath2 = new TreePath(path2);
					tree.collapsePath(treePath2);

					TreeNode[] path3 = node_18.getPath();
					TreePath treePath3 = new TreePath(path3);
					tree.collapsePath(treePath3);

					// repaint();

				}
				if (node.equals(node_3)) {

					TreeNode[] path1 = node_1.getPath();
					TreePath treePath1 = new TreePath(path1);
					tree.collapsePath(treePath1);

					TreeNode[] path2 = node_7.getPath();
					TreePath treePath2 = new TreePath(path2);
					tree.collapsePath(treePath2);

					TreeNode[] path3 = node_18.getPath();
					TreePath treePath3 = new TreePath(path3);
					tree.collapsePath(treePath3);
					repaint();

				}
				if (node.equals(node_7)) {

					TreeNode[] path1 = node_3.getPath();
					TreePath treePath1 = new TreePath(path1);
					tree.collapsePath(treePath1);

					TreeNode[] path2 = node_1.getPath();
					TreePath treePath2 = new TreePath(path2);
					tree.collapsePath(treePath2);

					TreeNode[] path3 = node_18.getPath();
					TreePath treePath3 = new TreePath(path3);
					tree.collapsePath(treePath3);
					repaint();

				}
				if (node.equals(node_18)) {

					TreeNode[] path1 = node_3.getPath();
					TreePath treePath1 = new TreePath(path1);
					tree.collapsePath(treePath1);

					TreeNode[] path2 = node_7.getPath();
					TreePath treePath2 = new TreePath(path2);
					tree.collapsePath(treePath2);

					TreeNode[] path3 = node_1.getPath();
					TreePath treePath3 = new TreePath(path3);
					tree.collapsePath(treePath3);
					repaint();

				}

			}
		});
		contentPane.add(tree);

		JPanel panel = new JPanel();
		panel.setBounds(371, 212, 613, 221);
		contentPane.add(panel);
		panel.setLayout(null);

		final JLabel lab1 = new JLabel("2.1 OS metadata");
		lab1.setBounds(10, 11, 546, 14);
		panel.add(lab1);

		lab2 = new JLabel("2.1.a Kernel Version");
		lab2.setBounds(32, 43, 524, 14);
		panel.add(lab2);

		JLabel lab3 = new JLabel("Regular Expression");
		lab3.setBounds(10, 101, 136, 14);
		panel.add(lab3);

		JLabel lab4 = new JLabel("Succes");
		lab4.setBounds(10, 140, 114, 14);
		panel.add(lab4);

		JLabel lab5 = new JLabel("Warning");
		lab5.setBounds(10, 184, 114, 14);
		panel.add(lab5);

		textField_3 = new JTextField();
		textField_3.setBounds(156, 98, 435, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(156, 137, 435, 20);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(156, 181, 435, 20);
		panel.add(textField_5);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(32, 605, 952, 12);
		contentPane.add(separator_2);
		
		JButton btnNewButton_1 = new JButton("Execute Using momentary configs");
		btnNewButton_1.setBounds(352, 733, 250, 42);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String node_name1 = lab2.getText();
					node_name1 = node_name1.replaceAll(" ", "_");
					String str1 = textField_3.getText();
					String str2 = textField_4.getText();
					String str3 = textField_5.getText();
	//				str1 = StringEscapeUtils.unescapeJava(str1);
	//				str2 = StringEscapeUtils.unescapeJava(str2);
	//				str3 = StringEscapeUtils.unescapeJava(str3);
					
					values.put(node_name1 + "_regex",
							str1);
					values.put(node_name1 + "_succ",
							str2);
					values.put(node_name1 + "_warn",
							str3);					
					
					File f = new File("meta.properties");
					f.createNewFile();
										
					PropertiesConfiguration meta = new PropertiesConfiguration(f);
					Set keys = values.keySet();
					Iterator zaehl = keys.iterator();
					while(zaehl.hasNext()){
						String h = (String) zaehl.next();
						meta.setProperty(h, values.get(h));
					}
					meta.save();
					
					CheckTxtRegex checker = new CheckTxtRegex();
					String[] uebergabe = new String[]{textField_7.getText(), textField_8.getText(), f.getAbsolutePath()};
					results = checker.giveResults(uebergabe[0], uebergabe[1],uebergabe[2]); 
					f.delete();
					
					final JDialog meinJDialog = new JDialog();
			        meinJDialog.setTitle("Results");
			        meinJDialog.setSize(600,800);
			        meinJDialog.setModal(true);
			        meinJDialog.getContentPane().setLayout(null);
			        boolean warning =false;
			        boolean failure=false;
			        int k = 0;
			        for(int i =0; i<results.length; i++){
			        	 JLabel jl = new JLabel(results[i][0]);
					     jl.setBounds(20,(i+1)*25,500,15);
					     meinJDialog.getContentPane().add(jl);
					     if(results[i][1]!=null){
					    	 JLabel l = new JLabel(results[i][1]);
						     l.setBounds(530,(i+1)*25,100,15);
						     if(results[i][1]==CheckTxtRegexMethods.WARNING){
						    	 l.setForeground(Color.ORANGE); 
							     meinJDialog.getContentPane().add(l);
							     warning=true;
						     }
						     if(results[i][1]==CheckTxtRegexMethods.OK){
						    	 l.setForeground(Color.GREEN); 
						    	 meinJDialog.getContentPane().add(l);
						     }
						     if(results[i][1]==CheckTxtRegexMethods.FAIL){
						    	 l.setForeground(Color.RED);
						    	 meinJDialog.getContentPane().add(l);
						    	 failure = true;
						     }
						     k=i+1;
					     }
			        }
					     JLabel j = new JLabel("Overall Result");
					     j.setBounds(20,(k+2)*25,500,15);
					     j.setFocusable(true);
					     meinJDialog.getContentPane().add(j); 
					     JLabel j1=new JLabel("");
					     if(!warning&&!failure){
					    	 j1 = new JLabel("Okay");
					    	 j1.setForeground(Color.GREEN);
						     
					     }
					     else if(warning||failure){
					    	 if(failure){
					    		 j1 = new JLabel("Failure");
						    	 j1.setForeground(Color.RED);
					    	 }
					    	 else if(warning){
					    		 j1 = new JLabel("Warning");
						    	 j1.setForeground(Color.ORANGE);
					    	 }
					    	 else{
					    		 
					    	 }
					    }
					     else{
					    	 					     }
					     j1.setBounds(530,(k+2)*25,100,20);
					     meinJDialog.getContentPane().add(j1); 
					  
					     
			        
			        
			        JButton jb = new JButton("Close Results");
			        jb.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							meinJDialog.dispose();
							
						}
			        	
			        });
			        jb.setBounds(100, 700, 150, 30);
			        meinJDialog.getContentPane().add(jb);
				    				    
				    JButton txt_button = new JButton("Save As Text File...");
				    txt_button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							JFileChooser chooser = new JFileChooser();
							String path="";
							int returnVal = chooser.showSaveDialog(returnthis());
			
							if (returnVal == JFileChooser.APPROVE_OPTION) {
			
								path = chooser.getSelectedFile().getAbsolutePath();
								//System.out.println(path);
							}
							 if (returnVal == JFileChooser.CANCEL_OPTION) {
							        path="";
							      }
							
							 
						File f = new File(path);
						FileWriter fw;
						try {
							f.createNewFile();
							fw = new FileWriter(f,true);
							BufferedWriter bw = new BufferedWriter(fw);
							for (int i=0; i<results.length;i++){
								if(results[i][1]!=null){
									bw.write(results[i][0]+ ": "+ results[i][1]);
									//System.out.println(results[i][0]+ ": "+ results[i][1]);
									bw.newLine();
									bw.flush();
									
								}
								else{
									bw.write(results[i][0]);
									//System.out.println(results[i][0]);
									bw.newLine();
									bw.flush(); 
								}
								
								
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						}
					});
			        txt_button.setBounds(300, 700,150,30);
			        meinJDialog.getContentPane().add(txt_button);


			       
			    
			        meinJDialog.setVisible(true);

					
					
					
				} catch (ConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EvaluationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
		});
		
		JLabel label_2 = new JLabel("Execution Area");
		label_2.setBounds(20, 650, 160, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Directory of Source Host System Report\n");
		label_3.setBounds(178, 650, 257, 14);
		contentPane.add(label_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(487, 647, 291, 20);
		contentPane.add(textField_7);
		
		JLabel label_4 = new JLabel("Directory of Target System Report\n");
		label_4.setBounds(178, 682, 269, 14);
		contentPane.add(label_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(487, 679, 291, 20);
		contentPane.add(textField_8);
		
		JButton button = new JButton("Browse...");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Chooser frame = new Chooser();
				textField_7.setText(frame.fileName);

			}
		});

		button.setBounds(823, 644, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Browse...");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Chooser frame = new Chooser();
				textField_8.setText(frame.fileName);

			}
		});

		button_1.setBounds(823, 676, 89, 23);
		contentPane.add(button_1);
		
				JButton btnSaveConfiguration = new JButton("Export Configuration As\u2026");
				btnSaveConfiguration.setBounds(669, 98, 223, 23);
				contentPane.add(btnSaveConfiguration);
				
				JSeparator separator_3 = new JSeparator();
				separator_3.setOrientation(SwingConstants.VERTICAL);
				separator_3.setBounds(517, 42, 17, 90);
				contentPane.add(separator_3);
				
				JLabel lblExportCurrentConfiguration = new JLabel("Export Current Configuration");
				lblExportCurrentConfiguration.setBounds(546, 39, 280, 18);
				contentPane.add(lblExportCurrentConfiguration);
				
				JLabel lblLoadDefaultConiguration = new JLabel("Load Default Coniguration or Load a Configuration of your Choice");
				lblLoadDefaultConiguration.setBounds(20, 40, 473, 16);
				contentPane.add(lblLoadDefaultConiguration);
				
						btnSaveConfiguration.addActionListener(new ActionListener() {
				
							@Override
							public void actionPerformed(ActionEvent arg0) {
								JFileChooser chooser = new JFileChooser();
								String path="";
								int returnVal = chooser.showSaveDialog(returnthis());
				
								if (returnVal == JFileChooser.APPROVE_OPTION) {
				
									path = chooser.getSelectedFile().getAbsolutePath();
									//System.out.println(path);
								}
								 if (returnVal == JFileChooser.CANCEL_OPTION) {
								        path="";
								      }
								
								String node_name1 = lab2.getText();
								node_name1 = node_name1.replaceAll(" ", "_");
								String str1 = textField_3.getText();
								String str2 = textField_4.getText();
								String str3 = textField_5.getText();
				//				str1 = StringEscapeUtils.unescapeJava(str1);
				//				str2 = StringEscapeUtils.unescapeJava(str2);
				//				str3 = StringEscapeUtils.unescapeJava(str3);
								
								values.put(node_name1 + "_regex",
										str1);
								values.put(node_name1 + "_succ",
										str2);
								values.put(node_name1 + "_warn",
										str3);
								
								
								try {
									File file = new File(path);
									//System.out.print(pfad);
									file.createNewFile();
									
									PropertiesConfiguration con = new PropertiesConfiguration(
											file.getCanonicalPath());
									//con.setDelimiterParsingDisabled(true);
									con.setDelimiter('¤');
									
									Set<String> set = values.keySet();
									Iterator<String> iter = set.iterator();
									for (int i=0;iter.hasNext();i++){
										String help = iter.next();
										con.setProperty(help, values.get(help));
									}
									
									
									//String[] allTests = metaConfig.getStringArray("allTests");
				
							
									
									con.save();
									
								} catch (IOException ioexc) {
									System.out.println("IO ->Fehler beim Speichern!");
								} catch (ConfigurationException confexc) {
									System.out.println("configexc ->Fehler beim Speichern!");
									confexc.printStackTrace();
								}
				
							}
				
						});

		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {

				// Überschriften richtig setzen
				TreePath path = e.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();
				String node_name = node.toString();
				node_name = node_name.replaceAll(" ", "_");
				if (node.getParent() != null) {
					lab1.setText(node.getParent().toString());
					lab2.setText(node.toString());
				}

				// aktuelle Daten auslesen und speichern
				try{
				TreePath path1 = e.getOldLeadSelectionPath();
				DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) path1
						.getLastPathComponent();
				String node_name1 = node1.toString();
				node_name1 = node_name1.replaceAll(" ", "_");

				values.put(node_name1 + "_regex",
						textField_3.getText());
				values.put(node_name1 + "_succ",
						textField_4.getText());
				values.put(node_name1 + "_warn",
						textField_5.getText());
				}
				catch(NullPointerException nexc){
					//System.out.println("keinVorgänger");
				}
				// neue Daten auf Screen setzen
				textField_3.setText(values.get(node_name+"_regex"));
				textField_4.setText(values.get(node_name+"_succ"));
				textField_5.setText(values.get(node_name+"_warn"));
			}

		});

	}

	public GUI_Hauptanwendung returnthis() {
		return this;
	}

	private void updateGUI() {
		try {
			TreePath path = tree.getSelectionPath();
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			String node_name = node.toString();
			node_name = node_name.replaceAll(" ", "_");
			
			Set set = values.keySet();
			Iterator iter = set.iterator();
			String [] allTests = new String[set.size()];
			for (int i=0;iter.hasNext();i++){
				allTests[i] = (String) iter.next();
			}
			
			
			ArrayList<String> al = new ArrayList<String>();
			for (int i=0; i<allTests.length;i++){
				String s = allTests[i];
				if(s.endsWith("_succ")){
					s=s.replace("_succ", "");
				}
				if(s.endsWith("_warn")){
					s=s.replace("_warn", "");
				}
				if(s.endsWith("_regex")){
					s=s.replace("_regex", "");
				}
				al.add(s);
			}
			java.util.Collections.sort(al);
			String[] tests = new String[al.size()];
			Iterator iti = al.iterator();
			for(int i=0; iti.hasNext();i++){
				tests[i] = (String) iti.next();						
			}
			
			

			

			for (int i = 0; i < tests.length; i++) {
				if (tests[i].equals(node_name)) {
					
				//System.out.println(values.get(allTests[i]+ "_regex"));
					textField_3.setText(values.get(tests[i]
							+ "_regex"));
					textField_4.setText(values.get(tests[i]
							+ "_succ"));
					textField_5.setText(values.get(tests[i]
							+ "_warn"));
				}
			}
		} catch (Exception exc) {
			//System.out.println("Fehler in Update GUI");
		}

	}

	public void loadConfiguration(String pfad) {
			values = new TreeMap<String,String>();
		try{
			//System.out.println(pfad);
			
			PropertiesConfiguration config = new PropertiesConfiguration(
					pfad);
			
			//config.setDelimiterParsingDisabled(true);
			
			config.load();
			config.setDelimiter('¤');
			config.configurationChanged();
			config = new PropertiesConfiguration(
					pfad);
			config.load();
			Iterator ita = config.getKeys();
			
			
			for(int i =0; ita.hasNext();i++){
				String st1;
				String st2;
				st1 = (String) ita.next();
				st2 = config.getString(st1);
				//System.out.println(st1);
				//System.out.println(st2);
				
				if(!(st1 == null)){
					values.put(st1, st2);
				}
				else{
					values.put(st1, "");	
				}
				
			}
			//System.out.println("Geladen");
			updateGUI();
		}
		catch(ConfigurationException configexc){
			System.out.println("ConfigurationException ----> loadConfiguration()");
			configexc.printStackTrace();
			
		}
		 
		
	}
}
