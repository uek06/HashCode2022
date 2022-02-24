package com.thales.interfaces;

import com.thales.models.FileHandler;

public abstract class AbstractAlgorithm implements Strategy {
	protected FileHandler fh = new FileHandler();

	@Override
	public abstract void process(String filename);

	@Override
	public abstract String getName();

}
