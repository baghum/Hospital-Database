import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.jdbc.StringUtils;

class Query
{
	

	static Connection connection = null;

	public Query()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/245final";
			String username = "root";
			String password = "mysql";

			System.out.println("Connecting database...");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");

		}
		catch (Exception e)
		{
			System.out.println("Didnt Connect");
		}
	}

	static String SelectAll()
	{
		String s = "";

		try
		{
			PreparedStatement statment = connection
					.prepareStatement("Select * from emgpatients");
			ResultSet result = statment.executeQuery();

			while (result.next())
			{
				s += (result.getString("EEGNo") + "\t" + result.getString("SubjectName")
						+ "\t\t" + result.getString("EEGDate") + "\t"
						+ result.getString("DOB") + "\t" + result.getString("age") + "\t"
						+ result.getString("Sex") + "\t" + result.getString("Handedness")
						+ "\t" + result.getString("LeveloFConsciousness") + "\t" + result
							.getString("waveType")) + "\n";

			}

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return s;

	}

	static void DeleteInfo()
	{
		String s = "";
		String deleteInfo;
		deleteInfo = JOptionPane
				.showInputDialog("Please enter the EEGNo of the person that you want ot delete ");

		try
		{
			PreparedStatement k = connection
					.prepareStatement("select EEGNo from emgpatients where eegno = "
							+ deleteInfo);
			ResultSet result = k.executeQuery();
			while (result.next())
			{
				s = result.getString("EEGNo");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		if(deleteInfo.equals(s))
		{
			try
			{
				PreparedStatement statment = connection
						.prepareStatement("delete from emgpatients where(EEGNo = "
								+ deleteInfo + ")");
				statment.execute();

				JOptionPane.showMessageDialog(null, "Process completed");

			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The record Doesn't exists");
		}
	}

	static void add()
	{
		String s = "";

		String EEGNo;

		EEGNo = JOptionPane.showInputDialog("Please enter EEGNo");
		while (true)
		{
			try
			{
				int a = Integer.parseInt(EEGNo);
				break;
			}

			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid EEGNo");
				EEGNo = JOptionPane.showInputDialog("Please enter EEGNo");
			}
		}
		try
		{
			PreparedStatement k = connection
					.prepareStatement("select EEGNo from emgpatients where eegno = "
							+ EEGNo);
			ResultSet result = k.executeQuery();
			while (result.next())
			{
				s = result.getString("EEGNo");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		if(s.equals(EEGNo))
		{
			JOptionPane.showMessageDialog(null, "The record already exists");
		}
		else
		{

			String Lastname = JOptionPane.showInputDialog("Please enter SubjectName");
			while(Lastname.equals("")){
				 Lastname = JOptionPane.showInputDialog("Please enter SubjectName");
			}
			String EEGDateYear = JOptionPane
					.showInputDialog("Please enter year of EEGDate");
			while (true)
			{
				try
				{
					int a = Integer.parseInt(EEGDateYear);
					if(a < 1900 || a > 2013)
						throw new NumberFormatException();
					break;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Year");
					EEGDateYear = JOptionPane
							.showInputDialog("Please enter year of EEGDate");
				}
			}
			String EEGDateMonth = JOptionPane
					.showInputDialog("Please enter month of EEGDate");
			while (true)
			{
				try
				{
					int a = Integer.parseInt(EEGDateMonth);

					if(a < 1 || a > 12)
						throw new NumberFormatException();
					break;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Month");
					EEGDateMonth = JOptionPane
							.showInputDialog("Please enter month of EEGDate");
				}
			}
			String EEGDateday = JOptionPane
					.showInputDialog("Please enter day of EEGDate");
			while (true)
			{
				try
				{
					int a = Integer.parseInt(EEGDateday);
					if(a < 1 || a > 31)
						throw new NumberFormatException();
					break;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Day");
					EEGDateday = JOptionPane
							.showInputDialog("Please enter day of EEGDate");
				}
			}

			String month = JOptionPane
					.showInputDialog("Please enter the month of the Birth in numbers Ex: 01");
			while (true)
			{
				try
				{
					int a = Integer.parseInt(month);
					if(a < 1 || a > 12)
						throw new NumberFormatException();
					break;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,
							"Please enter a valid Birth Month");
					month = JOptionPane
							.showInputDialog("Please enter the month of the Birth in numbers Ex: 01");
				}
			}

			String day = JOptionPane.showInputDialog("Please enter the day of the Birth");
			while (true)
			{
				try
				{
					int a = Integer.parseInt(day);
					if(a < 1 || a > 31)
						throw new NumberFormatException();
					break;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,
							"Please enter a valid Birth Day");
					day = JOptionPane
							.showInputDialog("Please enter the day of the Birth");
				}
			}

			String year = JOptionPane
					.showInputDialog("Please enter the year of the Birth");
			while (true)
			{
				try
				{
					int a = Integer.parseInt(year);
					if(a < 1900 || a > 2013)
						throw new NumberFormatException();
					break;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,
							"Please enter a valid Birth Year");
					year = JOptionPane
							.showInputDialog("Please enter the year of the Birth");
				}
			}
			String age = JOptionPane.showInputDialog("Please enter age");
			while (true)
			{
				try
				{
					int a = Integer.parseInt(age);
					break;
				}

				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null,
							"Please enter a valid age");
					age = JOptionPane.showInputDialog("Please enter age");
				}
			}

			String Sex = JOptionPane.showInputDialog("Please enter Sex");
			while (Sex.equals(""))
			{
				Sex = JOptionPane.showInputDialog("Please enter Sex");
			}
			String hand = JOptionPane.showInputDialog("Please enter handedness");
			while (hand.equals(""))
			{
				hand = JOptionPane.showInputDialog("Please enter handedness");
			}
			String level = JOptionPane
					.showInputDialog("Please eneter level of consciousness");
			while (level.equals(""))
			{
				level = JOptionPane
						.showInputDialog("Please eneter level of consciousness");
			}
			String wave = JOptionPane.showInputDialog("Please enter wave type");
			while (wave.equals(""))
			{
				wave = JOptionPane.showInputDialog("Please enter wave type");
			}

			try
			{
				PreparedStatement statment = connection
						.prepareStatement("Insert into emgpatients Values(" + EEGNo
								+ ", '" + Lastname + "', '" + EEGDateYear + "-" + EEGDateMonth + "-"
								+ EEGDateday + "', '" + year + "-" + month + "-" + day + "', "
								+ age + ", '" + Sex + "', '" + hand + "', '" + level
								+ "', '" + wave + "')");
				statment.execute();

				JOptionPane.showMessageDialog(null, "Process completed");

			}
			catch (SQLException e)
			{
				System.out.println(e);
			}
		}
	}

	static void Modify()
	{
		String s = "";
		String column;

		String EEG = JOptionPane.showInputDialog("Please enter the EEGNo ");
		while (true)
		{
			try
			{
				int a = Integer.parseInt(EEG);
				break;
			}

			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid EEGNo");
				EEG = JOptionPane.showInputDialog("Please enter EEGNo");
			}
		}
		try
		{
			PreparedStatement k = connection
					.prepareStatement("select EEGNo from emgpatients where eegno = "
							+ EEG);
			ResultSet result = k.executeQuery();
			while (result.next())
			{
				s = result.getString("EEGNo");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		if(EEG.equals(s))
		{

			column = JOptionPane
					.showInputDialog("Please choose one"
							+ "\n"
							+ "EEGNO, SubjectName, EEGDate, DOB, AGE, SEX, HandedNess, LevelOFConsciousness, WaveType");

			if(column.equals("DOB") || column.equals("Dob") || column.equals("dob"))
			{
				String year = JOptionPane.showInputDialog("Please enter the year of the Birth ");
				while (true)
				{
					try
					{
						int a = Integer.parseInt(year);
						if(a < 1900 || a > 2013)
							throw new NumberFormatException();
						break;
					}

					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null,
								"Please enter a valid Birth Year");
						year = JOptionPane
								.showInputDialog("Please enter the year of the Birth");
					}
				}
				String month = JOptionPane
						.showInputDialog("Please enter the month in numbers Ex: 01");
				while (true)
				{
					try
					{
						int a = Integer.parseInt(month);
						if(a < 1 || a > 12)
							throw new NumberFormatException();
						break;
					}

					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null,
								"Please enter a valid Birth Month");
						month = JOptionPane
								.showInputDialog("Please enter the month in numbers Ex: 01");
					}
				}

				String day = JOptionPane.showInputDialog("Please enter the day of the Birth");
				while (true)
				{
					try
					{
						int a = Integer.parseInt(day);
						if(a < 1 || a > 31)
							throw new NumberFormatException();
						break;
					}

					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null,
								"Please enter a valid Birth Day");
						day = JOptionPane
								.showInputDialog("Please enter the day of the Birth");
					}
				}

				int k = (2013 - Integer.parseInt(year));

				try
				{

					PreparedStatement statment = connection
							.prepareStatement("Update emgpatients set DOB = '" + year
									+ "-" + month + "-" + day + "', age = " + k
									+ " where EEGNo = " + EEG);
					statment.execute();
					JOptionPane.showMessageDialog(null, "Process completed");
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}

			else if(column.equals("age") || column.equals("Age") || column.equals("AGE"))
			{
				JOptionPane.showMessageDialog(null,
						"You can not change the age, please change the DOB");
				return;
			}

			else if(column.equals("EEGNo") || column.equals("eegno")
					|| column.equals("Eegno") || column.equals("EEGno")
					|| column.equals("EEgno") || column.equals("eegNo"))
			{
				String change = JOptionPane
						.showInputDialog("what do you want to chagne instead?");
				while (true)
				{
					try
					{
						int a = Integer.parseInt(change);
						break;
					}

					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid EEGNo");
						change = JOptionPane.showInputDialog("Please enter EEGNo");
					}
				}
				try
				{
					PreparedStatement statment = connection
							.prepareStatement("Update emgpatients set EEGNo = " + change
									+ " where EEGNo = " + EEG);
					statment.execute();
					JOptionPane.showMessageDialog(null, "Process completed");
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
			else if(column.equals("eegdate") || column.equals("EEGdate")
					|| column.equals("EEGDate") || column.equals("Eegdate"))
			{
				String EEGDateYear = JOptionPane
						.showInputDialog("Please enter year of EEGDate");
				while (true)
				{
					try
					{
						int a = Integer.parseInt(EEGDateYear);
						if(a < 1900 || a > 2013)
							throw new NumberFormatException();
						break;
					}

					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid Year");
						EEGDateYear = JOptionPane
								.showInputDialog("Please enter year of EEGDate");
					}
				}
				String EEGDateMonth = JOptionPane
						.showInputDialog("Please enter month of EEGDate");
				while (true)
				{
					try
					{
						int a = Integer.parseInt(EEGDateMonth);

						if(a < 1 || a > 12)
							throw new NumberFormatException();
						break;
					}

					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid Month");
						EEGDateMonth = JOptionPane
								.showInputDialog("Please enter month of EEGDate");
					}
				}
				String EEGDateday = JOptionPane
						.showInputDialog("Please enter day of EEGDate");
				while (true)
				{
					try
					{
						int a = Integer.parseInt(EEGDateday);
						if(a < 1 || a > 31)
							throw new NumberFormatException();
						break;
					}

					catch (NumberFormatException e)
					{
						JOptionPane.showMessageDialog(null, "Please enter a valid Day");
						EEGDateday = JOptionPane
								.showInputDialog("Please enter day of EEGDate");
					}
				}
				try
				{

					PreparedStatement statment = connection
							.prepareStatement("Update emgpatients set EEGDate = '" + EEGDateYear
									+ "-" + EEGDateMonth + "-" + EEGDateday + "' where EEGNo = " + EEG);
					;
					statment.execute();
					JOptionPane.showMessageDialog(null, "Process completed");
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}

			else
			{
				String changeTO = JOptionPane
						.showInputDialog("what do you want to chagne instead?");

				try
				{

					PreparedStatement statment = connection
							.prepareStatement("Update emgpatients set " + column + " = '"
									+ changeTO + "' where EEGNo = " + EEG);
					statment.execute();
					JOptionPane.showMessageDialog(null, "Process completed");
				}
				catch (SQLException e)
				{
					JOptionPane.showMessageDialog(null,
							"The entered enformation was not valid");
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The record Doesn't exists");
		}
	}

	static String search()
	{
		String s = "";
		String j = "";
		String getEEG = JOptionPane.showInputDialog("Please enter th EEG# ");
		while (true)
		{
			try
			{
				int a = Integer.parseInt(getEEG);
				break;
			}

			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Please enter a Valid EEGNo");
				getEEG = JOptionPane.showInputDialog("Please enter th EEG# ");
			}
		}

		try
		{
			PreparedStatement k = connection
					.prepareStatement("select EEGNo from emgpatients where eegno = "
							+ getEEG);
			ResultSet result = k.executeQuery();
			while (result.next())
			{
				j = result.getString("EEGNo");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		if(getEEG.equals(j))
		{
			try
			{
				PreparedStatement statment = connection
						.prepareStatement("select * from emgpatients where EEGNo = "
								+ getEEG);

				ResultSet result = statment.executeQuery();

				while (result.next())
				{

					s = (result.getString("EEGNo") + "\t"
							+ result.getString("SubjectName") + "\t\t"
							+ result.getString("EEGDate") + "\t"
							+ result.getString("DOB") + "\t" + result.getString("age")
							+ "\t" + result.getString("Sex") + "\t"
							+ result.getString("Handedness") + "\t"
							+ result.getString("LeveloFConsciousness") + "\t" + result
							.getString("waveType"));
				}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Record Doesn't exists");
		}
		return s;
	}

	static String Older40()
	{
		String s = "";
		try
		{
			PreparedStatement statment = connection
					.prepareStatement("Select * from emgpatients where age > 40 AND handedness = 'L' AND wavetype = 'alpha'");

			ResultSet result = statment.executeQuery();

			while (result.next())
			{
				s += (result.getString("EEGNo") + "\t" + result.getString("SubjectName")
						+ "\t\t" + result.getString("EEGDate") + "\t"
						+ result.getString("DOB") + "\t" + result.getString("age") + "\t"
						+ result.getString("Sex") + "\t" + result.getString("Handedness")
						+ "\t" + result.getString("LeveloFConsciousness")
						+ "\t"+result.getString("waveType") + "\n");

			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return s;
	}

	static String Older30()
	{
		String s = "";

		try
		{

			PreparedStatement statment = connection
					.prepareStatement("Select * from emgpatients where Sex = 'F' AND age > 30 AND handedness = 'Both' AND wavetype = 'Gamma'");

			ResultSet result = statment.executeQuery();

			while (result.next())
			{
				s += (result.getString("EEGNo") + "\t" + result.getString("SubjectName")
						+ "\t\t" + result.getString("EEGDate") + "\t"
						+ result.getString("DOB") + "\t" + result.getString("age") + "\t"
						+ result.getString("Sex") + "\t" + result.getString("Handedness")
						+ "\t" + result.getString("LeveloFConsciousness") + "\t"
						+ result.getString("waveType") + "\n");
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return s;
	}

	static String mailLess40()
	{
		String s = "";
		try
		{
			PreparedStatement statment = connection
					.prepareStatement("Select * from emgpatients where Sex = 'M' AND age < 40 AND wavetype = 'Theta'");

			ResultSet result = statment.executeQuery();

			while (result.next())
			{
				s += (result.getString("EEGNo") + "\t" + result.getString("SubjectName")
						+ "\t\t" + result.getString("EEGDate") + "\t"
						+ result.getString("DOB") + "\t" + result.getString("age") + "\t"
						+ result.getString("Sex") + "\t" + result.getString("Handedness")
						+ "\t" + result.getString("LeveloFConsciousness") + "\t"
						+ result.getString("waveType") + "\n");
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return s;
	}

	static void quit()
	{
		System.exit(0);
	}
}

public class sqlE
{
	public static void main(String[] args)
	{
		new Query();

	}
}