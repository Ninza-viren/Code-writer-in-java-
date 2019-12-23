import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*; 
class MyNotepad extends JFrame implements ActionListener
{
	JFrame frame;
	JTextArea text;
	MyNotepad()
	{
		frame=new JFrame("CodeEditor");
		//set the Look and fell of the editor
		
		try { 
			// Set metl look and feel 
			UIManager.setLookAndFeel("javax.swing.plaf.cyan.MetalLookAndFeel"); 

			// Set theme to ocean 
			MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
		} 
		
		catch(Exception e)
		{
			
		}
		
		text=new JTextArea();
		
		// JMenuBar 
		
		JMenuBar mbar=new JMenuBar();
		
		// Create the Menu
		
		JMenu menu1=new JMenu("File");
		
		//Create JMenuItem
		
		JMenuItem item1=new JMenuItem("New");
		JMenuItem item2=new JMenuItem("Open");
		JMenuItem item3=new JMenuItem("Save");
		JMenuItem item4=new JMenuItem("Print");
		
		//Add Action Listener
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		
		// Add items at menu
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		
		// Crete second Menu Edit
		
		JMenu menu2=new JMenu("Edit");
		
		// Create MenuItems
		
		JMenuItem item5=new JMenuItem("Cut");
		JMenuItem item6=new JMenuItem("Copy");
		JMenuItem item7=new JMenuItem("Paste");
		
		//Add Action Listener
		
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		
		// Add items at menu
		menu2.add(item5);
		menu2.add(item6);
		menu2.add(item7);
		
		
		JMenuItem cl=new JMenuItem("Close");
		cl.addActionListener(this);
		
		
		mbar.add(menu1);
		mbar.add(menu2);
		mbar.add(cl);
		
		frame.setJMenuBar(mbar);
		frame.add(text);
		frame.setSize(600,600);
		text.setBackground(Color.decode("#323232"));
		text.setForeground(Color.decode("#F00A"));
		frame.show();
		text.setFont(new Font("Serif",Font.PLAIN,26));
		
		
		

		
	}
	
	// when user press the command
	
	public void actionPerformed(ActionEvent e)
	{
			String s=e.getActionCommand();
			if(s.equals("Cut"))
			{
				text.cut();
			}
			
			else if(s.equals("Copy"))
			{
				text.copy();
			}
			
			else if(s.equals("Paste"))
			{
				text.paste();
			}
			
			else if(s.equals("Save"))
			{
				// Create JFileChooser object
				
				JFileChooser ch=new JFileChooser("e:");
				
				//Invoke the showSaveDialog() funtion to show the dialog box
				
				int i=ch.showSaveDialog(null);
				
				if (i == JFileChooser.APPROVE_OPTION) 
				{
					try{
					// set the label path to the selected directory
					File f=	new File(ch.getSelectedFile().getAbsolutePath());
					
					// create FileWriter object
					
					FileWriter writer=new FileWriter(f,false);
					
					// creat BufferedWriter object
					
					BufferedWriter bw=new BufferedWriter(writer);
					
					bw.write(text.getText());
					bw.flush();
					bw.close();
					}
					
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(frame,e1.getMessage());
					}
					
					
				}
				
				// If user cancle the request
				
				else
				{
					JOptionPane.showMessageDialog(frame,"user cancel task");
					
				}
				
				
			}
			
			
			else if(s.equals("Print"))
			{
				// print the file
				try
				{
					text.print();
				}
				
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(frame,e2.getMessage());
					
				}
				
				
				
			}
			
			else if (s.equals("Open")) { 
			// Create an object of JFileChooser class 
			JFileChooser ch = new JFileChooser("f:"); 

			// Invoke the showsOpenDialog function to show the save dialog 
			int i = ch.showOpenDialog(null); 

			// If the user selects a file 
			if (i == JFileChooser.APPROVE_OPTION) { 
				// Set the label to the path of the selected directory 
				File fi = new File(ch.getSelectedFile().getAbsolutePath()); 

				try { 
					// String 
					String s1 = "", sl = ""; 

					// File reader 
					FileReader fr = new FileReader(fi); 

					// Buffered reader 
					BufferedReader br = new BufferedReader(fr); 

					// Initilize sl 
					sl = br.readLine(); 

					// Take the input from the file 
					while ((s1 = br.readLine()) != null) { 
						sl = sl + "\n" + s1; 
					} 

					// Set the text 
					text.setText(sl); 
				} 
				catch (Exception evt) { 
					JOptionPane.showMessageDialog(frame, evt.getMessage()); 
				} 
			} 
			// If the user cancelled the operation 
			else
				JOptionPane.showMessageDialog(frame, "the user cancelled the operation"); 
		}
			else if(s.equals("New"))
			{
				text.setText("");
			}
			
			else if(s.equals("Close"))
			{
				frame.setVisible(false);
				
			}
		
	}
	
	public static void main(String[] args)
	{
		MyNotepad m=new MyNotepad();
	}
}