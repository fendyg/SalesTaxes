import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileWrite {
	/*
	 * Write output strings to a file
	 * 
	 * output		[ArrayList<String>]: Output strings to be written to a file
	 * inputCount	[int]: Output file number 
	 */
	public void writeFile(ArrayList<String> output, int inputCount) {
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter("output/output"+inputCount+".txt"));
			
			for (String s : output) {
				write.write(s);
				write.newLine();
			}
			
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
