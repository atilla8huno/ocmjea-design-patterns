package com.oracle.ocmjea.gof.behavioral.command;

public interface FileSystemReceiver {

	void openFile();
	void writeFile();
	void closeFile();
}
