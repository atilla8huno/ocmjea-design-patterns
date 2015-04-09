package com.oracle.ocmjea.gof.behavioral.chain_of_responsibility;

/**
 * GoF's Pattern: Chain of Responsibility
 * 
 * O padrão Chain of Responsibility cria um encadeiamento (chain) de objetos receptores para uma requisição.
 * Esse padrão desacopla os emissores e receptores de uma requisição baseado no tipo do request.
 * Neste padrão, normalmente cada receptor contém uma referência para outro receptor. Se um objeto não pode
 * processar a requisição, então ele passa o mesmo para o próximo receptor, e assim por diante.
 * 
 * Esse tipo de design pattern é do tipo Behavioral Pattern.
 * 
 * Cenário aplicável:
 */
public class LoggerTest {

	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		return errorLogger;
	}

	public static void main(String[] args) {
		
		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
	}
}
