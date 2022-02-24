package com.thales.interfaces;

import java.util.List;

public interface Reader {

	void open(String filename);
	String readLine();
	List<String> readLines(int nbLinesToRead);
	List<String> readAll();
}
