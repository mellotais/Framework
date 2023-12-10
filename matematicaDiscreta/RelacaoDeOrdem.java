package matematicaDiscreta;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RelacaoDeOrdem<T> {

    private final Set<T> conjunto;
    private final Map<Pair<T>, Boolean> relacionamento;

  
    
    public RelacaoDeOrdem(Set<T> conjunto) {
        this.conjunto = conjunto;
        this.relacionamento = new HashMap<>();
        inicializarRelacionamento();
    }


    private void inicializarRelacionamento() {
        for (T a : conjunto) {
            for (T b : conjunto) {
                relacionamento.put(new Pair<>(a, b), false);
            }
        }
    }

    public void adicionarRelacao(T elemento1, T elemento2) {
        if (conjunto.contains(elemento1) && conjunto.contains(elemento2)) {
            relacionamento.put(new Pair<>(elemento1, elemento2), true);
        }
    }

    public boolean verificaReflexividade() {
        return conjunto.stream().allMatch(elemento -> relacionamento.get(new Pair<>(elemento, elemento)));
    }

    public boolean verificaTransitividade() {
        for (T a : conjunto) {
            for (T b : conjunto) {
                for (T c : conjunto) {
                    if (relacionamento.get(new Pair<>(a, b)) && relacionamento.get(new Pair<>(b, c)) && !relacionamento.get(new Pair<>(a, c))) {
                        return false; // Se uma transição não for encontrada, a relação não é transitiva
                    }
                }
            }
        }
        return true; // Se não encontrar contraexemplo, a relação é transitiva
    }

    
    public boolean verificaSimetria() {
        return conjunto.stream().allMatch(a -> conjunto.stream().allMatch(b ->
                relacionamento.get(new Pair<>(a, b)) == relacionamento.get(new Pair<>(b, a))));
    }

    public boolean verificaAntissimetria() {
        return conjunto.stream().allMatch(a -> conjunto.stream().allMatch(b ->
                !relacionamento.get(new Pair<>(a, b)) || !relacionamento.get(new Pair<>(b, a)) || a.equals(b)));
    }

    public Set<T> elementosMinimos() {
        return conjunto.stream()
                .filter(a -> conjunto.stream().noneMatch(b -> relacionamento.get(new Pair<>(a, b))))
                .collect(Collectors.toSet());
    }

    public Set<T> elementosMaximos() {
        return conjunto.stream()
                .filter(a -> conjunto.stream().noneMatch(b -> relacionamento.get(new Pair<>(b, a))))
                .collect(Collectors.toSet());
    }

    public boolean verificaConnex() {
        for (T a : conjunto) {
            for (T b : conjunto) {
                if (!a.equals(b) && !relacionamento.get(new Pair<>(a, b)) && !relacionamento.get(new Pair<>(b, a))) {
                    return false; // Se não existe uma relação entre a e b, ou entre b e a, a relação não é connex
                }
            }
        }
        return true; // Se não encontrar  a relação é connex
    }
    
    public boolean verificaIgualdade() {
        return verificaReflexividade() && verificaSimetria() && verificaAntissimetria();
    }

    public boolean verificaOrdemParcial() {
        return verificaReflexividade() && verificaAntissimetria() && verificaTransitividade();
    }

    public boolean verificaOrdemTotal() {
        if (verificaOrdemParcial()) {
            return false;
        }
        return verificaConnex();
    }

    
    

}
