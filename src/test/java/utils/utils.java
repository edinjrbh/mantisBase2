package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testes.ExecutarTestes;

public class utils {

	public static void takeScreenshot(String fileName){
	    File scrFile = ((TakesScreenshot)ExecutarTestes.getDriver()).getScreenshotAs(OutputType.FILE);
	    Date data = new Date();
	    try {
	        FileUtils.copyFile(scrFile, new File(".\\evidencias\\"+fileName+data.getTime()+".jpeg"),true);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
