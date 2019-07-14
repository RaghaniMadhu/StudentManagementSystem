import javax.swing.*;//for components
import java.awt.*;//for layout container
import java.awt.event.*;//for actionPerformed n all
import java.sql.*;//for connecting to oracle database

class UpdateFrame extends JFrame
{
	Container c;
	JLabel lblRno,lblName;
	JTextField txtRNo,txtName;
	JButton btnSave,btnBack;
	JPanel p1,p2;
	
	UpdateFrame()
	{
		c = getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		
		p1 = new JPanel();
		lblRno = new JLabel("Roll No:");
		lblName = new JLabel("Name:");
		txtRNo = new JTextField(4);
		txtName = new JTextField(10);
		p1.add(lblRno);
		p1.add(txtRNo);
		p1.add(lblName);
		p1.add(txtName);
		c.add(p1);
		
		p2 = new JPanel();
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");		
		p2.add(btnSave);
		p2.add(btnBack);
		c.add(p2);

		
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				DbHandler db = new DbHandler();
				db.updateStudent(Integer.parseInt(txtRNo.getText()),txtName.getText());
			}
		});
	


		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				MainFrame m = new MainFrame();
				dispose();
			}
		});


		setTitle("Update Student");
		setSize(350,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}