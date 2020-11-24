package objectRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page {

	public static WebElement element;
	public static String filePath = "C:\\Users\\user\\Documents\\TestCase_3\\src\\test\\resources\\locatorPaths.json";
	public static String collections;
	public static String beingAtHomeList;
	public static String close;

	public static void getPath() {
		try {
			Object obj = new JSONParser().parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			collections = (String) jsonObject.get("collections");
			beingAtHomeList = (String) jsonObject.get("beingAtHomeList");
			close = (String) jsonObject.get("close");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	}
    
	public static WebElement getCollections(WebDriver driver) {
		element = driver.findElement(By.xpath(Home_page.collections));
		return element;

	}

	public static List<WebElement> getCollectionList(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.xpath(Home_page.beingAtHomeList));
		return list;
	}

	public static WebElement getCloseButton(WebDriver driver) {
		element = driver.findElement(By.xpath(Home_page.close));
		return element;

	}
}
