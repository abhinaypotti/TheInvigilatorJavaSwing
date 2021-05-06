import javax.swing.*;
import java.sql.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.*;
public class HomePage {
	static HashMap<String,ArrayList<String>> fac = new HashMap<String, ArrayList<String>>();
	static ArrayList<String> rooms = new ArrayList<>();
	static ArrayList<String> sch;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("The Invigilator App");
		JButton b = new JButton("Admin Login");
		JButton b1 = new JButton("Faculty Login");
		b.setBounds(190, 300, 100, 40);
		b1.setBounds(320, 300, 100, 40);
		f.add(b);
		f.add(b1);
		f.setSize(700, 700);
		f.setLayout(null);
		f.setVisible(true);
		ArrayList<String> x = new ArrayList<>();
		x.add("faculty");
		x.add("1234");
		fac.put("faculty", x);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame adminlogin = new JFrame("Admin Login");
				JMenuBar menu = new JMenuBar();
				JMenuItem home = new JMenuItem("Home");
				menu.add(home);
				
				f.setVisible(false);
				JLabel head = new JLabel("Admin Login");
				head.setBounds(230, 10, 120, 50);
				JLabel user = new JLabel("Username :");
				user.setBounds(130, 50, 100, 50);
				JTextField username = new JTextField();
				username.setBounds(240, 50, 200, 50);
				JLabel pass = new JLabel("Password :");
				pass.setBounds(130, 150, 100, 50);
				JPasswordField password = new JPasswordField();
				password.setBounds(240, 150, 200, 50);
				JButton login = new JButton("Login");
				login.setBounds(320, 200, 60, 50);
				JLabel success = new JLabel();
				success.setBounds(320,250,160,30);
				adminlogin.add(user);
				adminlogin.add(username);
				adminlogin.add(pass);
				adminlogin.add(password);
				adminlogin.add(head);
				adminlogin.add(login);
				adminlogin.setJMenuBar(menu);
				adminlogin.setSize(700, 700);
				adminlogin.setLayout(null);
				adminlogin.setVisible(true);
				adminlogin.add(success);
				home.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						adminlogin.setVisible(false);
						f.setVisible(true);
					}
					
				});
				
				login.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String uname = username.getText();
						String upass = password.getText();
						if(uname.equals("admin")&& upass.equals("1234")) {
							adminlogin.setVisible(false);
							JFrame adminhome = new JFrame("Admin Home");
							JMenuBar adminmenu = new JMenuBar();
							JMenuItem addfaculty = new JMenuItem("Add Faculty");
							JMenuItem addroom = new JMenuItem("Add Room");
							JMenuItem viewroom = new JMenuItem("View Rooms");
							JMenuItem allocate = new JMenuItem("Allocate");
							JMenuItem viewallocate = new JMenuItem("View Allocation");
							JMenuItem logout = new JMenuItem("Log out");
							JLabel wel = new JLabel("Welcome Admin");
							wel.setBounds(250, 150, 200, 100);
							addfaculty.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									 
									
									JTextField xField = new JTextField(10);
								      JTextField yField = new JTextField(10);
								      JPasswordField zField = new JPasswordField(10);

								      JPanel myPanel = new JPanel();
								      myPanel.add(new JLabel("Username:"));
								      myPanel.add(xField);
								      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
								      myPanel.add(new JLabel("Name:"));
								      myPanel.add(yField);
								      myPanel.add(Box.createHorizontalStrut(15));
								      myPanel.add(new JLabel("Password:"));
								      myPanel.add(zField);

								      int result = JOptionPane.showConfirmDialog(null, myPanel, 
								               "Please Enter Faculty Details", JOptionPane.OK_CANCEL_OPTION);
								      if (result == JOptionPane.OK_OPTION) {
								         String mail = xField.getText();
								         String name = yField.getText();
								         String fpass = zField.getText();
								         ArrayList<String> inp = new ArrayList<>();
								         inp.add(name);
								         inp.add(fpass);
								         if(!fac.containsKey(mail)) {
								        	 fac.put(mail,inp);
								         }else {
								        	 JOptionPane.showMessageDialog(f,"Faculty Already Exists","Alert",JOptionPane.WARNING_MESSAGE);
								         }
								         
								      }
									
									
								}
								
							});
							
							addroom.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									JTextField xField = new JTextField(10);
									JPanel myPanel = new JPanel();
								      myPanel.add(new JLabel("Room number:"));
								      myPanel.add(xField);
								      int result = JOptionPane.showConfirmDialog(null, myPanel, 
								               "Please Enter Faculty Details", JOptionPane.OK_CANCEL_OPTION);
								      if (result == JOptionPane.OK_OPTION) {
								    	  String room = xField.getText();
								    	  if(!rooms.contains(room)) {
								    		  rooms.add(room);
								    	  }else {
								    		  JOptionPane.showMessageDialog(f,"Room Already Exists","Alert",JOptionPane.WARNING_MESSAGE);
								    	  }
								    	  
								      }
								}
								
							});
							
							viewroom.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Object[] objects = rooms.toArray();
									String[] obj = new String[objects.length];
									for(int i=0;i<objects.length;i++) {
										obj[i] = String.valueOf(objects[i]);
									}
									JFrame frame = new JFrame("Rooms");  
							        JPanel panel = new JPanel(); 
							        DefaultListModel<String> l1 = new DefaultListModel<>();  
									for(int i=0;i<obj.length;i++) {
										l1.addElement(obj[i]);
									}JList<String> list = new JList<>(l1);  
							          list.setBounds(100,100, 75,75);
									panel.add(list);
							        frame.add(panel); 
							        frame.setSize(200, 300);  
							        frame.setLocationRelativeTo(null); 
							        frame.setVisible(true);
								}
								
							});
							
							allocate.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									JTextField xField = new JTextField(10);
								      JTextField yField = new JTextField(10);
								      

								      JPanel myPanel = new JPanel();
								      myPanel.add(new JLabel("No of faculty per room:"));
								      myPanel.add(xField);
								      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
								      myPanel.add(new JLabel("No of rooms:"));
								      myPanel.add(yField);

								      int result = JOptionPane.showConfirmDialog(null, myPanel, 
								               "Please Enter Faculty Details", JOptionPane.OK_CANCEL_OPTION);
								      if (result == JOptionPane.OK_OPTION) {
								         int facno = Integer.valueOf(xField.getText());
								         int roomno = Integer.valueOf(yField.getText());
								         if(roomno*facno > fac.size() || roomno > rooms.size() ) {
								        	 JOptionPane.showMessageDialog(f,"Not sufficient","Alert",JOptionPane.WARNING_MESSAGE);
								         }else {
								         
								         int i = 0;
								         int count  =1;
								         ArrayList<String> faculty = new ArrayList<>();
								         Set<String> ss = fac.keySet();
								         for(String p : ss) {
								        	 faculty.add(p);
								         }
								         sch = new ArrayList<>();
								         for(int j=0;j<roomno;j++) {
								        	 for(int k=i;k<i+facno;k++) {
								        		 String n = String.valueOf(count);
								        		 String r = rooms.get(j);
								        		 String f = faculty.get(k);
								        		 String toapp = n+". "+f+" "+r;
								        		 sch.add(toapp);
								        		 count++;
								        	 }
								        	 i = i + facno;
								         }
								         
								         }
								         
								      }
									
								}
								
							});
							
							logout.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									adminhome.setVisible(false);
									f.setVisible(true);
								}
								
								
							});
							
							viewallocate.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Object[] objects = sch.toArray();
									String[] obj = new String[objects.length];
									for(int i=0;i<objects.length;i++) {
										obj[i] = String.valueOf(objects[i]);
									}
									JFrame frame = new JFrame("Schedule");  
							        JPanel panel = new JPanel(); 
							        DefaultListModel<String> l1 = new DefaultListModel<>();  
									for(int i=0;i<obj.length;i++) {
										l1.addElement(obj[i]);
									}JList<String> list = new JList<>(l1);  
							          list.setBounds(100,100, 75,75);
									panel.add(list);
							        frame.add(panel); 
							        frame.setSize(300, 300);  
							        frame.setLocationRelativeTo(null); 
							        frame.setVisible(true);
								}
								
							});
							
							adminmenu.add(addfaculty);
							adminmenu.add(addroom);
							adminmenu.add(viewroom);
							adminmenu.add(allocate);
							adminmenu.add(viewallocate);
							adminmenu.add(logout);
							
							adminhome.add(adminmenu);
							adminhome.add(wel);
							adminhome.setJMenuBar(adminmenu);
							adminhome.setSize(700,700);
							adminhome.setLayout(null);
							adminhome.setVisible(true);
							
							
						}else {
							success.setText("Wrong Credentials");
						}
						
						
						
					}
					
				});
				
				
				
			}
			
		});
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame facultylogin = new JFrame("Faculty Login");
				f.setVisible(false);
				JMenuBar menu = new JMenuBar();
				JMenuItem home = new JMenuItem("Home");
				menu.add(home);
				JLabel head = new JLabel("Faculty Login");
				head.setBounds(230, 10, 120, 50);
				JLabel user = new JLabel("Username :");
				user.setBounds(130, 50, 100, 50);
				JTextField username = new JTextField();
				username.setBounds(240, 50, 200, 50);
				JLabel pass = new JLabel("Password :");
				pass.setBounds(130, 150, 100, 50);
				JPasswordField password = new JPasswordField();
				password.setBounds(240, 150, 200, 50);
				JButton login = new JButton("Login");
				login.setBounds(320, 200, 60, 50);
				JLabel success = new JLabel();
				success.setBounds(320,250,160,30);
				
				facultylogin.add(user);
				facultylogin.add(username);
				facultylogin.add(pass);
				facultylogin.add(password);
				facultylogin.add(head);
				facultylogin.add(login);
				facultylogin.add(success);
				facultylogin.setJMenuBar(menu);
				facultylogin.setSize(700, 700);
				facultylogin.setLayout(null);
				facultylogin.setVisible(true);
				home.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						facultylogin.setVisible(false);
						f.setVisible(true);
					}
					
				});
				
				login.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String uname = username.getText();
						String upass = password.getText();
						ArrayList<String> c = new ArrayList<>();
						try {
						c = fac.get(uname);
						
						if(upass.equals(c.get(1))) {
							facultylogin.setVisible(false);
							JFrame facultyhome = new JFrame("Faculty Home");
							JMenuBar facultymenu = new JMenuBar();
							JMenuItem viewprofile = new JMenuItem("View Profile");
							JMenuItem viewschedule = new JMenuItem("View Schedule");
							JMenuItem logout = new JMenuItem("Log out");
							viewprofile.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									ArrayList<String> details = fac.get(uname);
									Object[] objects = details.toArray();
									String[] obj = new String[objects.length];
									for(int i=0;i<objects.length;i++) {
										obj[i] = String.valueOf(objects[i]);
									}
									JFrame frame = new JFrame("Profile");  
							        JPanel panel = new JPanel(); 
							        DefaultListModel<String> l1 = new DefaultListModel<>();
							        l1.addElement("Username: "+uname);
									for(int i=0;i<obj.length;i++) {
										if(i==0) {
											l1.addElement("Name: "+obj[i]);
										}else {
											l1.addElement("Password: "+obj[i]);
										}
										
									}
									
									JList<String> list = new JList<>(l1);  
							          list.setBounds(100,100, 75,75);
									panel.add(list);
							        frame.add(panel); 
							        frame.setSize(300, 300);  
							        frame.setLocationRelativeTo(null); 
							        frame.setVisible(true);
									
								}
								
							});
							
							viewschedule.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									Object[] objects = sch.toArray();
									String[] obj = new String[objects.length];
									for(int i=0;i<objects.length;i++) {
										obj[i] = String.valueOf(objects[i]);
									}
									JFrame frame = new JFrame("Schedule");  
							        JPanel panel = new JPanel(); 
							        DefaultListModel<String> l1 = new DefaultListModel<>();  
									for(int i=0;i<obj.length;i++) {
										if(obj[i].contains(uname)) {
											l1.addElement(obj[i]);
										}
									}JList<String> list = new JList<>(l1);  
							          list.setBounds(100,100, 75,75);
									panel.add(list);
							        frame.add(panel); 
							        frame.setSize(300, 300);  
							        frame.setLocationRelativeTo(null); 
							        frame.setVisible(true);
								}
								
							});
						
							logout.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									facultyhome.setVisible(false);
									f.setVisible(true);
								}
								
							});
							facultymenu.add(viewprofile);
							facultymenu.add(viewschedule);
							facultymenu.add(logout);
							facultyhome.add(facultymenu);
							facultyhome.setJMenuBar(facultymenu);
							facultyhome.setSize(700,700);
							facultyhome.setLayout(null);
							facultyhome.setVisible(true);
							
							
						}else {
							success.setText("Wrong Credentials");
						}}
						catch(Exception ex){
							success.setText("Wrong Credentials");
						}
						
					}
					
				});
				
			}
			
		});
	}

}
