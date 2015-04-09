package com.oracle.ocmjea.gof.behavioral.command;

public class FileSystemReceiverUtil {

	public static FileSystemReceiver getSistemaOperacionalDaMaquina() {
		String osName = System.getProperty("os.name");
		System.out.println("Sistema Operacional: " + osName);
		
		if (osName.contains("Windows")) {
			return new WindowsFileSystemReceiver();
		} else {
			return new UnixFileSystemReceiver();
		}
	}
}
