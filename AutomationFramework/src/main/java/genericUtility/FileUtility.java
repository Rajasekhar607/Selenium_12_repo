package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author gunas
 *
 */
public class FileUtility {
	/**
	 * This method
	 * @return 
	 * @throws IOException 
	 */
  public  String getDatafromProperty(String key) throws IOException {
  FileInputStream fis = new FileInputStream("./src/test/resources/TestData/Commondata.properties");
   Properties prop = new Properties();
   prop.load(fis);
   return prop.getProperty(key);


	}
}