package matematicaDiscreta;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBuilder<T> {

	private Set<T> elementos = new HashSet<>();

    public ConjuntoBuilder<T> adicionarElemento(T elemento) {
        elementos.add(elemento);
        return this;
    }

    
    public ConjuntoBuilder<T> limparElementos() {
        throw new UnsupportedOperationException("Método não implementado");
    }
    
    public Conjuntos<T> construir() {
        Conjuntos<T> conjunto = new Conjuntos<>(elementos);
        // Notifica os observadores sobre a construção do novo conjunto
        conjunto.notificarObservadores();
        return conjunto;
    }
}
