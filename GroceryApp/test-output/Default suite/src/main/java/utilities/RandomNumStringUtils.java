package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomNumStringUtils {

	public String getRandomstring(int length) {
		String generatedString= RandomStringUtils.randomAlphabetic(length);
		return generatedString;

	}
	
	

}
