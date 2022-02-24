package com.thales.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.thales.interfaces.Reader;
import com.thales.interfaces.Writer;

public class FileHandler implements Reader, Writer {
	private BufferedReader input;

	@Override
	public void write(String filename, List<String> content) {
		// TODO Auto-generated method stub
        try {
            PrintWriter out = new PrintWriter("resources/" + filename + ".out");
            for(String line : content) {
                out.write(line);
            }
            out.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void open(String filename) {
		// TODO Auto-generated method stubs
		try {
			input = new BufferedReader(new FileReader("resources/" + filename + ".in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String readLine() {
		// TODO Auto-generated method stub
		try {
			return input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> readLines(int nbLinesToRead) {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		for(int i = 0; i < nbLinesToRead; i ++) {
			result.add(readLine());
		}
		return result;
	}

	@Override
	public List<String> readAll() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		String line;
		while ((line = readLine()) != null){ // while there is a next line
			result.add(line);
		}
		return result;
	}

}
