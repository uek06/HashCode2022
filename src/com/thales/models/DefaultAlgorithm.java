package com.thales.models;

import com.thales.interfaces.AbstractAlgorithm;

public class DefaultAlgorithm extends AbstractAlgorithm {

	@Override
	public void process(String filename) {
		// TODO Auto-generated method stub
		this.fh.open(filename);
		this.fh.readAll();
		this.fh.write(this.getName() + '-' + filename, null);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
