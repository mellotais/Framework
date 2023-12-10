package matematicaDiscreta;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBuilder<T> {

	private Set<T> elementos = new HashSet<>();

    public ConjuntoBuilder<T> adicionarElemento(T elemento) {
        elementos.add(elemento);
        return this;
    }

    public Conjuntos<T> construir() {
        return new Conjuntos<>(elementos);
    }
    
    public ConjuntoBuilder<T> limparElementos() {
        throw new UnsupportedOperationException("Método não implementado");
    }
    
    
}
