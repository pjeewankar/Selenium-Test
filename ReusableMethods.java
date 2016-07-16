
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.WebElement;




public class ReusableMethods{
	//	static WebDriver driver;
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	
	/*Name of the Method: enterText
	 * Brief description: Enter text value to text boxes
	 * Arguments: obj--> WebElement object, textVal--> text to be entered, objName--> Object Name
	 * Created By: TechPirates
	 * Creation Date: June 29, 2016
	 * Last Modified: June 29, 2016
	 * */
	
	public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textVal);
			Update_Report("Pass","Enter text", textVal + " is entered in" + objName + " field") ;
		}
		else{
				Update_Report("Fail","Enter text", objName +" field is not displayed. Please check your application.") ;
			}
	}
	
	/*Name of the Method: clickElement
	 * Brief description: Click on a web element
	 * Arguments: obj--> WebElement object, objName--> Object Name
	 * Created By: TechPirates
	 * Creation Date: June 29, 2016
	 * Last Modified: June 29, 2016
	 * */
	
	public static void clickElement(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass","Click Element", objName + " is clicked") ;
		}
		else{
				Update_Report("Fail","Click Element", objName +" is not displayed. Please check your application.") ;
			}
	}
	
	/*Name of the Method: validateTextMessage
	 * Brief description: Validate text Message
	 * Arguments: obj--> WebElement object, expectedErrorMsg--> Expected Text Message
	 * Created By: TechPirates
	 * Creation Date: June 29, 2016
	 * Last Modified: June 29, 2016
	 * */
	
	public static void validateTextMessage(WebElement obj, String objName, String expectedErrorMsg) throws IOException{
		
		String actualErrorMsg = obj.getText().trim();
		if(obj.isDisplayed()){
			if(actualErrorMsg.equals(expectedErrorMsg)){
				Update_Report("Pass", "Validate Text Message", "Actual error message match with expected error message '" + actualErrorMsg + "'");
			}
			else
				Update_Report("Fail", "Validate Text Message", "Actual error message '" + actualErrorMsg + "' does not match with expected error message '" + expectedErrorMsg +"'");
		}
		else
			Update_Report("Fail","Click Element", objName +" is not displayed. Please check your application.") ;
	}
	
	/*Name of the Method: selectCheckBox
	 * Brief description: Select Check Box
	 * Arguments: obj--> WebElement object, objName--> Object Name
	 * Created By: TechPirates
	 * Creation Date: June 29, 2016
	 * Last Modified: June 29, 2016
	 * */
	
	public static void selectCheckBox(WebElement obj, String objName) throws IOException{
		
		if(obj.isDisplayed()){
			if(!obj.isSelected()){
				obj.click();
				Update_Report("Pass", "Select Text Box", objName + " is selected.");
			}
			else
				Update_Report("Pass", "Select Text Box", objName + " is already selected.");
		}
		else
			Update_Report("Fail","Select Text Box", objName +" is not displayed. Please check your application.") ;
	}
	
	/*Name of the Method: deSelectCheckBox
	 * Brief description: Select Check Box
	 * Arguments: obj--> WebElement object, objName--> Object Name
	 * Created By: TechPirates
	 * Creation Date: June 29, 2016
	 * Last Modified: June 29, 2016
	 * */
	
	public static void deSelectCheckBox(WebElement obj, String objName) throws IOException{
		
		if(obj.isDisplayed()){
			if(obj.isSelected()){
				obj.click();
				Update_Report("Pass", "Deselect Text Box", objName + " is deselected.");
			}
			else
				Update_Report("Pass", "Deselect Text Box", objName + " is already deselected.");
		}
		else
			Update_Report("Fail","Deselect Text Box", objName +" is not displayed. Please check your application.") ;
	}
	

	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
}

