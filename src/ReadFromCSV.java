import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;
import com.opencsv.CSVReader;

public class ReadFromCSV {

	public static void main(String args[]) throws IOException
	{
		CSVReader reader = new CSVReader(new FileReader("JavaProject.csv"));
	
		String[] task;
	
		double totalFixedCost = 0;
		int totalActualHrs = 0;
		int i=0;
		while((task = reader.readNext()) != null)
		{
			i++;
		
			System.out.printf("%-20s %-12s %-12s %12s %15s",task[0],task[1],task[2],task[8],task[10]);
			System.out.println();
		
			if(i >1){
				totalActualHrs += Integer.parseInt(task[10]);
				double data = Double.parseDouble(task[8].replace("$", "").replace(",", ""));
				totalFixedCost += data;
			}
		}
		
		System.out.println();
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Total Fixed Cost = "+nf.format(totalFixedCost));
		System.out.println("Total Actual Hrs = "+totalActualHrs);
	}
}