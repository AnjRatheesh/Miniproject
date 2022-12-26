package inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import inetbanking.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseurl = readconfig.getApplicationURL();
	public String uname = readconfig.getUsername();
	public String pwd = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		

		logger = Logger.getLogger("BaseClass");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\target\\log4j.properties");        

		if (br.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			
			
			driver = new ChromeDriver();
		} else if (br.equals("Edge")) {

			System.setProperty("webdriver.Edge.driver", readconfig.getEdgepath());//using driver download
			driver = new EdgeDriver();
		}
		driver.get(baseurl);


	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void captureScreeshot(WebDriver driver,String  tname,String Screeshotfilename) throws IOException{
		DateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		Screeshotfilename=dateFormat.format(date);
		File Screeshotfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(Screeshotfile,new File(System.getProperty("user.dir")+"/Screenshots/"+tname+Screeshotfilename+".png"));
		System.out.println("Screenshot taken");
		
		
		//----------------------------------------		
		//TakesScreenshot ts=(TakesScreenshot) driver;
		//File source=ts.getScreenshotAs(OutputType.FILE);
		//File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname +".png");
		//FileUtils.copyFile(source, target);
		//System.out.println("Screenshot taken");
		
	}
}
