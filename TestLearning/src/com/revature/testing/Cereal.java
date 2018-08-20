package com.revature.testing;

import java.io.Serializable;

public class Cereal implements Serializable {
	
	private int aField;
	private int anotherField;
	private transient int transientField;
	
	
	public Cereal() {
		aField = 5;
		anotherField = 10;
		transientField = 15;
	}


	@Override
	public String toString() {
		return "Cereal [aField=" + aField + ", anotherField=" + anotherField + ", transientField=" + transientField
				+ "]";
	}


	
	
}
