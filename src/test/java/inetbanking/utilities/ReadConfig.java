package inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties Pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			Pro = new Properties();
			Pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}

	}

	public String getApplicationURL() {
		String url = Pro.getProperty("baseurl");
		return url;
	}

	public String getUsername() {
		String username = Pro.getProperty("uname");
		return username;
	}

	public String getPassword() {
		String password = Pro.getProperty("pwd");
		return password;
	}

	public String getChromepath() {
		String chromepath = Pro.getProperty("chromePath");
		return chromepath;
	}
	public String getEdgepath() {
		String Edgepath = Pro.getProperty("edgePath");
		return Edgepath;
	}

}
