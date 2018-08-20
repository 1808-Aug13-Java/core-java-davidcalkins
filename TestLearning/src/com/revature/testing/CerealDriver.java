package com.revature.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CerealDriver {

	public static void main(String[] args) {
		Cereal cereal = new Cereal();
		
		try {
			File file = new File("./Cereal.ser");
			ObjectOutputStream oOutput = new ObjectOutputStream(new FileOutputStream(file));
			
			oOutput.writeObject(cereal);
			oOutput.close();
			
			
			ObjectInputStream oInput = new ObjectInputStream(new FileInputStream(file));
			
			Cereal cereal2 = (Cereal) oInput.readObject();
			
			oInput.close();
			System.out.println(cereal2.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
