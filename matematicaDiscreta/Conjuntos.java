package matematicaDiscreta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Conjuntos<T> implements Conjunto<T> {
    private Set<T> elementos;
    private Set<ConjuntoObserver<T>> observadores = new HashSet<>();
    
    public Conjuntos(Set<T> elementos) {
        this.elementos = new HashSet<>(elementos);
    }

    public Conjuntos() {
        this.elementos = new HashSet<>();
    }
    

    public Set<T> getElementos() {
		return elementos;
	}

	public void setElementos(Set<T> elementos) {
		this.elementos = elementos;
	}
	@Override
    public Conjunto<T> criarConjunto() {
        return new Conjuntos<>();
    }
	
	public int size() {
        return elementos.size();
    }
	
	 @Override
	    public boolean contains(Object elemento) {
	        return elementos.contains(elemento);
	    }
	 
    @Override
    public void adicionarObservador(ConjuntoObserver<T> observador) {
        observadores.add(observador);
    }
    

	
	/// FAZER A UNIÃO, INTERCECAO,COMPLEMENTO, IGUALDADE E VERIFICAR PETINENCIA
    @Override
    public Conjunto<T> uniao(Conjunto<T> outroConjunto) {
        Set<T> uniao = new HashSet<>(elementos);
        uniao.addAll(((Conjuntos<T>) outroConjunto).elementos);
        return new Conjuntos<>(uniao);
    }

    @Override
    public Conjunto<T> intersecao(Conjunto<T> outroConjunto) {
        Set<T> intersecao = new HashSet<>(elementos);
        intersecao.retainAll(((Conjuntos<T>) outroConjunto).elementos);
        return new Conjuntos<>(intersecao);
    }

    @Override
    public Conjunto<T> diferenca(Conjunto<T> outroConjunto) {
        Set<T> diferenca = new HashSet<>(elementos);
        diferenca.removeAll(((Conjuntos<T>) outroConjunto).elementos);
        return new Conjuntos<>(diferenca);
    }

    @Override
    public Conjunto<T> complemento(Conjunto<T> outroConjunto) {
        Set<T> complemento = new HashSet<>(((Conjuntos<T>) outroConjunto).elementos);
        complemento.removeAll(elementos);
        return new Conjuntos<>(complemento);
    }

    @Override
    public boolean ehIgual(Conjunto<T> outroConjunto) {
        return elementos.equals(((Conjuntos<T>) outroConjunto).elementos);
    }

    @Override
    public boolean verificaPertinencia(T elemento) {
        return elementos.contains(elemento);
    }
    
    
    
    //// CRIAÇÃO DE CONJUNTOS APARTIR DE UM ARRAY
    public static <T> Conjuntos<T> criarConjuntoAPartirDeLista(List<T> lista) {
	    return new Conjuntos<>(new HashSet<>(lista));
	}

	public static <T> Conjuntos<T> criarConjuntoAPartirDeArray(T[] array) {
	    return new Conjuntos<>(new HashSet<>(Arrays.asList(array)));
	}

	public static <T> Conjuntos<T> criarConjuntoAPartirDeOutroConjunto(Conjuntos<T> outroConjunto) {
	    return new Conjuntos<>(new HashSet<>(outroConjunto.elementos));
	}


	
	//CONJUNTO DAS PARTES
	public static <T> Set<Set<T>> conjuntoDasPartes(T[] array) {
        Set<T> conjunto = new HashSet<>(Arrays.asList(array));
        Set<Set<T>> conjuntoPartes = new HashSet<>();
        conjuntoPartes.add(new HashSet<>());

        for (T elemento : conjunto) {
            Set<Set<T>> novosSubconjuntos = new HashSet<>();
            for (Set<T> subconjunto : conjuntoPartes) {
                Set<T> novoSubconjunto = new HashSet<>(subconjunto);
                novoSubconjunto.add(elemento);
                novosSubconjuntos.add(novoSubconjunto);
            }
            conjuntoPartes.addAll(novosSubconjuntos);
        }

        return conjuntoPartes;
    }



	//VER SE É SUPERCONJUNTO E SUBCONJUNTO
		public boolean ehSuperconjunto(Conjuntos<T> outroConjunto) {
		    return outroConjunto.elementos.containsAll(this.elementos);
		}

	public boolean ehSubconjunto(Conjuntos<T> outroConjunto) {
        return this.elementos.containsAll(outroConjunto.elementos);
    }
	

	
	@Override
	public void removerObservador(ConjuntoObserver<T> observador) {
	    observadores.remove(observador);
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conjuntos [elementos=");
		builder.append(elementos);
		builder.append("]");
		return builder.toString();
	}

}


