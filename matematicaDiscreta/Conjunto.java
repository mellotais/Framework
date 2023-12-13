package matematicaDiscreta;

import java.util.Set;


	//Interface para o Factory Method e Observer
	public interface Conjunto<T> {
	 Conjunto<T> uniao(Conjunto<T> outroConjunto);
	 Conjunto<T> intersecao(Conjunto<T> outroConjunto);
	 Conjunto<T> diferenca(Conjunto<T> outroConjunto);
	 Conjunto<T> complemento(Conjunto<T> outroConjunto);
	 boolean ehIgual(Conjunto<T> outroConjunto);
	 boolean verificaPertinencia(T elemento);
	 boolean  ehSubconjunto(Conjuntos<T> outroConjunto);
	 Set<T> getElementos();
	
	 // Método do Factory para criar instâncias de Conjuntos
	 Conjunto<T> criarConjunto();
	
	 // Método para adicionar observadores
	 void adicionarObservador(ConjuntoObserver<T> observador);
	 
	 // Método para remover observadores
	 void removerObservador(ConjuntoObserver<T> observador);

	 void notificarObservadores();
		
	 int size();
	 
	 boolean contains(Object elemento);
	}

