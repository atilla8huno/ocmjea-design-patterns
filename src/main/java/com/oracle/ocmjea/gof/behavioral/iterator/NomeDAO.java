package com.oracle.ocmjea.gof.behavioral.iterator;

public class NomeDAO implements Container {

	public String nomes[] = { "Átilla", "Ben-Hur", "Jullierme", "Lúcio" };

	@Override
	public Iterador getIterador() {
		return new NomeIterador();
	}

	/**
	 * Implementação do Iterator para a lista de nomes (nomes[])
	 */
	private class NomeIterador implements Iterador {
		
		int index;

		@Override
		public boolean temProximo() {
			if (index < nomes.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object proximo() {
			if (this.temProximo()) {
				return nomes[index++];
			}
			return null;
		}
	}
}
