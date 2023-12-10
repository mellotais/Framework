package matematicaDiscreta;

import java.util.HashSet;
import java.util.Set;

public class ProdutoCartesiano<T extends Comparable<T>> {

    private final Set<Pair<T>> produtoCartesiano;

    private ProdutoCartesiano(Set<T> conjunto1, Set<T> conjunto2) {
        produtoCartesiano = calcularProdutoCartesiano(conjunto1, conjunto2);
    }

    public Set<Pair<T>> getProdutoCartesiano() {
        return produtoCartesiano;
    }

    private Set<Pair<T>> calcularProdutoCartesiano(Set<T> conjunto1, Set<T> conjunto2) {
        Set<Pair<T>> resultado = new HashSet<>();

        for (T elementoConjunto1 : conjunto1) {
            for (T elementoConjunto2 : conjunto2) {
                Pair<T> novoPar = new Pair<>(elementoConjunto1, elementoConjunto2);
                resultado.add(novoPar);
            }
        }

        return resultado;
    }

    public static <T extends Comparable<T>> ProdutoCartesiano<T> of(Set<T> conjunto1, Set<T> conjunto2) {
        return new ProdutoCartesiano<>(conjunto1, conjunto2);
    }

    
}
