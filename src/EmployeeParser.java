import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class EmployeeParser {

	public static void main(String[] args) {
		File employeeFile = new File("h:\\projects\\SMSNotificationList\\EmployeeInfoForImport.csv");
		
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(employeeFile))) {
			String line = null;
			while ((line = lnr.readLine()) != null) {
				//System.out.println("Line = '"+line+"'");
				String[] entries = line.split((","));
				//System.out.println("Entries.length = "+entries.length);
				if (entries.length == 3) {
					String name=entries[0];
					String[] empNames=name.split("\\|");
					//System.out.println("Name='"+name+"'");
					String lastName = empNames[0];
					String firstName= empNames[1];
					firstName = firstName.trim();
					//System.out.println("firstName = '"+firstName+"'");
					//System.out.println("lastName = '"+lastName+"'");
					
					String company=entries[1];
					String phone=entries[2];
					phone=phone.replace("(", "");
					phone=phone.replace(")", "");
					phone=phone.replace("-", "");
					phone=phone.replace(" ", "");
					
					String email=firstName+lastName.charAt(0)+"@health.solutions";
					System.out.print(firstName+";");
					System.out.print(lastName+";");
					System.out.print(company+";");
					System.out.print("1"+phone+";");
					System.out.println(email);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
