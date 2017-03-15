import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class App
{
	JFrame myframe;
	TextArea text;

	public App()
	{
		text = new TextArea(30, 100);
		myframe = new JFrame("EMGPatients");
	}

	public void getFrame()
	{

		new Query();

		JMenuBar jmb = new JMenuBar();
		jmb.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JMenu jm = new JMenu("Options");

		JMenuItem add = new JMenuItem("ADD");
		JMenuItem delete = new JMenuItem("Delete");
		JMenuItem modify = new JMenuItem("Modify");
		JMenuItem search = new JMenuItem("Search by EEG#");
		JMenuItem search40 = new JMenuItem("Older than 40, Left Handed, ALpha");
		JMenuItem search30 = new JMenuItem("F, Older than 30, both Handed, Gamma");
		JMenuItem searchByMale = new JMenuItem("M , less than 40,Theta");
		JMenuItem DisplayAll = new JMenuItem("Display ALL");
		JMenuItem Quit = new JMenuItem("Quit");

		AddLister addRecord = new AddLister();
		DeleteLister deleteRecord = new DeleteLister();
		ModifyLister modifyRecord = new ModifyLister();
		SearchByEEGLister searchByEEG = new SearchByEEGLister();
		older40Lister older = new older40Lister();
		older30Lister older30 = new older30Lister();
		mailLess40Lister mail40 = new mailLess40Lister();
		DisplayAllLister displayALLRecords = new DisplayAllLister();
		QuitListener q = new QuitListener();

		add.addActionListener(addRecord);
		delete.addActionListener(deleteRecord);
		modify.addActionListener(modifyRecord);
		search.addActionListener(searchByEEG);
		search40.addActionListener(older);
		search30.addActionListener(older30);
		searchByMale.addActionListener(mail40);
		DisplayAll.addActionListener(displayALLRecords);
		Quit.addActionListener(q);

		jm.add(add);
		jm.addSeparator();
		jm.add(delete);
		jm.addSeparator();
		jm.add(modify);
		jm.addSeparator();
		jm.add(search);
		jm.addSeparator();
		jm.add(search40);
		jm.addSeparator();
		jm.add(search30);
		jm.addSeparator();
		jm.add(searchByMale);
		jm.addSeparator();
		jm.add(DisplayAll);
		jm.addSeparator();
		jm.add(Quit);

		jmb.add(jm);
		myframe.add(jmb, BorderLayout.NORTH);
		JPanel p1 = new JPanel();
		
		text.setEditable(false);
		
		
		p1.add(text);

		myframe.add(p1);
		myframe.setSize(800, 600);
		myframe.setVisible(true);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class AddLister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Query.add();
		}
	}

	class DeleteLister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Query.DeleteInfo();
		}
	}

	class ModifyLister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Query.Modify();
		}
	}

	class SearchByEEGLister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			text.append("\n" + "Here is the result" + "\n" + Query.search());
		}
	}

	class older40Lister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			text.append("\n" + "Here is the result" + "\n" + Query.Older40());
		}
	}

	class older30Lister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			text.append("\n" + "Here is the result" + "\n" + Query.Older30());
		}
	}

	class mailLess40Lister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			text.append("\n" + "Here is the result" + "\n" + Query.mailLess40());
		}
	}

	class DisplayAllLister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			text.append("\n" + "Here is the result" + "\n" + Query.SelectAll());

		}
	}

	class QuitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			Query.quit();
			
			myframe.dispose();
		}
	}

	public static void main(String[] args)
	{
		App a = new App();
		a.getFrame();
	}
}