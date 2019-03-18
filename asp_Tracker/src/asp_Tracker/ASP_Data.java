package asp_Tracker;

import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;


public class ASP_Data {
	
	//Data structure top store asp
	private HashMap<String,int[]> asp = new HashMap<String,int[]>();
	//the file to load data from
	private File file = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
	private String lastReset;
	
	
	//constructor for data object
	public ASP_Data() {
		loadData();
		
	}
	
	//loads data from csv file into asp data structure
	private void loadData() {
		String path = file.getAbsolutePath() + "/Data/ASP.csv";
		BufferedReader br = null;
        String line = null;
        try {
        	 br = new BufferedReader(new FileReader(path));
        	 lastReset = br.readLine();
        	 while((line = br.readLine()) != null) {
        		 String[] aspS = line.split(",");
        		 int[] temp = new int[2];
        		 temp[0] = (Integer.parseInt(aspS[1]));
        		 temp[1] = (Integer.parseInt(aspS[2]));
        		 this.asp.put(aspS[0], temp);
        	 
        	 }
        	 
        	 
        }catch(FileNotFoundException e){
        	//creates directory and file if not found
        	new File(file.getAbsolutePath() + "/Data").mkdirs();
        	new File(file.getAbsolutePath() + "/Data/ASP.csv");
        	try {
    			BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath() + "/Data/ASP.csv"));
    			bw.write(getDate() +  "\n");
    			bw.write("Mac,"+"0"+","+"0"+"\n");
    			bw.write("PC,"+"0"+","+"0"+"\n");
    			bw.write("Tablets,"+"0"+","+"0"+"\n");
    			bw.write("Smartphones,"+"0"+","+"0"+"\n");
    			bw.write("Printers,"+"0"+","+"0"+"\n");
    			bw.write("MacW,0,0"+"\n");
    			bw.write("PCW,0,0"+"\n");
    			bw.write("TabletW,0,0"+"\n");
    			bw.write("SmartphoneW,0,0"+"\n");
    			bw.write("PrinterW,0,0"+"\n");
    			bw.close();
    			loadData();
    		}
    		catch(IOException x){
    			x.printStackTrace();
    		}
        	
        }catch(IOException e){
        	 e.printStackTrace();
        	
        }
        
        

	}
	//gets the data associated with item key
	public int[] get(String item){
		return this.asp.get(item);
		
	}
	
	//adds a sale and a specified number of attach to an item
	public void add(String item,int attach) {
		int[] temp = this.asp.get(item);
		temp[0] = temp[0] + 1;
		temp[1] = temp[1] + attach;
		this.asp.put(item, temp);
		save();

	}
	
	//adds a custom sale
	public void add(String item, int number, int attach) {
		int[] temp = this.asp.get(item);
		temp[0] = temp[0] + number;
		temp[1] = temp[1] + attach;
		this.asp.put(item, temp);
		save();
	}
	
	//calculates the asp based on the sales and attach of an item
	public Double calculate(String item) {
		int[] attach = this.asp.get(item);
		if(attach[0] == 0) {
			return 0.0;
		}else {
			Double aspC = (double) attach[1]/(double) attach[0];
			return roundTwoDecimals(aspC);
			
		}
		
		
	}
	//resets all items to zero
	public void reset() {
		lastReset = getDate();
		this.asp.get("Mac")[0] = 0;
		this.asp.get("Mac")[1] = 0;
		this.asp.get("PC")[0] = 0;
		this.asp.get("PC")[1] = 0;
		this.asp.get("Tablets")[0] = 0;
		this.asp.get("Tablets")[1] = 0;
		this.asp.get("Smartphones")[0] = 0;
		this.asp.get("Smartphones")[1] = 0;
		this.asp.get("Printers")[0] = 0;
		this.asp.get("Printers")[1] = 0;
		save();
		
	}
	
	public void resetW() {
		lastReset = getDate();
		this.asp.get("Mac")[0] = 0;
		this.asp.get("Mac")[1] = 0;
		this.asp.get("PC")[0] = 0;
		this.asp.get("PC")[1] = 0;
		this.asp.get("Tablets")[0] = 0;
		this.asp.get("Tablets")[1] = 0;
		this.asp.get("Smartphones")[0] = 0;
		this.asp.get("Smartphones")[1] = 0;
		this.asp.get("Printers")[0] = 0;
		this.asp.get("Printers")[1] = 0;
		
		this.asp.get("MacW")[0] = 0;
		this.asp.get("MacW")[1] = 0;
		this.asp.get("PCW")[0] = 0;
		this.asp.get("PCW")[1] = 0;
		this.asp.get("TabletW")[0] = 0;
		this.asp.get("TabletW")[1] = 0;
		this.asp.get("SmartphoneW")[0] = 0;
		this.asp.get("SmartphoneW")[1] = 0;
		this.asp.get("PrinterW")[0] = 0;
		this.asp.get("PrinterW")[1] = 0;
		save();
	}
	//class to round doubles
	public double roundTwoDecimals(Double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
    
    
	}
	
	//saves data to csv file
	private void save() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath() + "/Data/ASP.csv"));
			bw.write(lastReset + "\n");
			bw.write("Mac,"+this.asp.get("Mac")[0]+","+this.asp.get("Mac")[1]+"\n");
			bw.write("PC,"+this.asp.get("PC")[0]+","+this.asp.get("PC")[1]+"\n");
			bw.write("Tablets,"+this.asp.get("Tablets")[0]+","+this.asp.get("Tablets")[1]+"\n");
			bw.write("Smartphones,"+this.asp.get("Smartphones")[0]+","+this.asp.get("Smartphones")[1]+"\n");
			bw.write("Printers,"+this.asp.get("Printers")[0]+","+this.asp.get("Printers")[1]+"\n");
			
			bw.write("MacW,"+this.asp.get("MacW")[0]+","+this.asp.get("MacW")[1]+"\n");
			bw.write("PCW,"+this.asp.get("PCW")[0]+","+this.asp.get("PCW")[1]+"\n");
			bw.write("TabletW,"+this.asp.get("TabletW")[0]+","+this.asp.get("TabletW")[1]+"\n");
			bw.write("SmartphoneW,"+this.asp.get("SmartphoneW")[0]+","+this.asp.get("SmartphoneW")[1]+"\n");
			bw.write("PrinterW,"+this.asp.get("PrinterW")[0]+","+this.asp.get("PrinterW")[1]+"\n");
			
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public String getDate() {
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String tString = f.format(today);
		System.out.println(today);
		return tString;
	}
	
	public boolean checkReset() {
		boolean reset = false;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String today = getDate();
		try {
			Date now = f.parse(today);
			Date last = f.parse(lastReset);
			if(now.compareTo(last) > 0) {
				reset = true;
				
			};
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return reset;
	}

	
	
}
