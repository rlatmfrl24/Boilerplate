package CharsetDetection;

import java.io.FileNotFoundException;

import org.mozilla.universalchardet.UniversalDetector;

public class CharsetDetecting {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    java.io.FileInputStream fis = new java.io.FileInputStream("F:/dataset/YAHOO!/original/0.htm");
	    
	    DetectCharset("F:/dataset/YAHOO!/original/0.htm");
	    
	}
	
	public static String DetectCharset(String input){
		String encoding = "";
		try {
			byte[] buf = new byte[4096];
			java.io.FileInputStream fis = new java.io.FileInputStream(input);
			UniversalDetector detector = new UniversalDetector(null);
			int nread;
			while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			detector.dataEnd();
			encoding = detector.getDetectedCharset();
			if (encoding != null) {
				System.out.println("Detected encoding = " + encoding);
			} else {
				System.out.println("No encoding detected.");
				encoding = "UTF-8";
			}
			detector.reset();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encoding;
	}
}
