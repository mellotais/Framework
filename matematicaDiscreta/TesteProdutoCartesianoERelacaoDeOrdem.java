package matematicaDiscreta;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class TesteProdutoCartesianoERelacaoDeOrdem {

    @Test
    public void testProdutoCartesiano() {
        Set<Integer> conjunto1 = new HashSet<>();
        conjunto1.add(1);
        conjunto1.add(2);

        Set<Integer> conjunto2 = new HashSet<>();
        conjunto2.add(3);
        conjunto2.add(4);

        ProdutoCartesiano<Integer> produtoCartesiano = ProdutoCartesiano.of(conjunto1, conjunto2);
        Set<Pair<Integer>> resultado = produtoCartesiano.getProdutoCartesiano();

        // Verificar se o resultado está correto
        assertEquals(4, resultado.size());
        assertTrue(resultado.contains(new Pair<>(1, 3)));
        assertTrue(resultado.contains(new Pair<>(1, 4)));
        assertTrue(resultado.contains(new Pair<>(2, 3)));
        assertTrue(resultado.contains(new Pair<>(2, 4)));
    }

    @Test
    public void testRelacaoDeOrdem() {
        Set<Integer> conjunto = new HashSet<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        RelacaoDeOrdem<Integer> relacao = new RelacaoDeOrdem<>(conjunto);

        // Adiciona algumas relações
        relacao.adicionarRelacao(1, 1);
        relacao.adicionarRelacao(2, 2);
        relacao.adicionarRelacao(1, 2);
        relacao.adicionarRelacao(2, 3);
        relacao.adicionarRelacao(1, 3);

        // Verifica propriedades da relação
        assertTrue(relacao.verificaReflexividade());
        assertTrue(relacao.verificaTransitividade());
        assertTrue(relacao.verificaSimetria());
        assertTrue(relacao.verificaAntissimetria());
        assertEquals(Arrays.asList(1), relacao.elementosMinimos());
        assertEquals(Arrays.asList(3), relacao.elementosMaximos());
        assertTrue(relacao.verificaConnex());
        assertTrue(relacao.verificaIgualdade());
        assertTrue(relacao.verificaOrdemParcial());
        assertFalse(relacao.verificaOrdemTotal()); // Aqui estamos assumindo que a relação não é total
    }
}
