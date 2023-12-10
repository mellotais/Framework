package matematicaDiscreta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

	public class TesteConjunto {

    @Test
    void testUniao() {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {2, 3, 4, 5};

        Conjunto<Integer> conjuntoA = Conjuntos.criarConjuntoAPartirDeArray(array1);
        Conjunto<Integer> conjuntoB = Conjuntos.criarConjuntoAPartirDeArray(array2);

        Conjunto<Integer> uniao = conjuntoA.uniao(conjuntoB);

        assertEquals(5, uniao.size());
        assertTrue(uniao.contains(1));
        assertTrue(uniao.contains(2));
        assertTrue(uniao.contains(3));
        assertTrue(uniao.contains(4));
        assertTrue(uniao.contains(5));
    }

    @Test
    void testIntersecao() {
        Integer[] array1 = {1, 2, 3, 4};
        Integer[] array2 = {2, 3, 4, 5};

        Conjunto<Integer> conjuntoA = Conjuntos.criarConjuntoAPartirDeArray(array1);
        Conjunto<Integer> conjuntoB = Conjuntos.criarConjuntoAPartirDeArray(array2);

        Conjunto<Integer> intersecao = conjuntoA.intersecao(conjuntoB);

        assertEquals(3, intersecao.size());
        assertTrue(intersecao.contains(2));
        assertTrue(intersecao.contains(3));
        assertTrue(intersecao.contains(4));
    }

    @Test
    void testDiferenca() {
        Integer[] array1 = {1, 2, 3, 4};
        Integer[] array2 = {2, 3, 4, 5};

        Conjunto<Integer> conjuntoA = Conjuntos.criarConjuntoAPartirDeArray(array1);
        Conjunto<Integer> conjuntoB = Conjuntos.criarConjuntoAPartirDeArray(array2);

        Conjunto<Integer> diferenca = conjuntoA.diferenca(conjuntoB);

        assertEquals(1, diferenca.size());
        assertTrue(diferenca.contains(1));
    }

    @Test
    void testComplemento() {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {2, 3, 4, 5};

        Conjunto<Integer> conjuntoA = Conjuntos.criarConjuntoAPartirDeArray(array1);
        Conjunto<Integer> conjuntoB = Conjuntos.criarConjuntoAPartirDeArray(array2);

        Conjunto<Integer> complemento = conjuntoA.complemento(conjuntoB);

        assertEquals(1, complemento.size());
        assertTrue(complemento.contains(1));
    }

    @Test
    void testEhIgual() {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};

        Conjunto<Integer> conjuntoA = Conjuntos.criarConjuntoAPartirDeArray(array1);
        Conjunto<Integer> conjuntoB = Conjuntos.criarConjuntoAPartirDeArray(array2);

        assertTrue(conjuntoA.ehIgual(conjuntoB));
    }

    @Test
    void testVerificaPertinencia() {
        Integer[] array1 = {1, 2, 3};

        Conjunto<Integer> conjuntoA = Conjuntos.criarConjuntoAPartirDeArray(array1);

        assertTrue(conjuntoA.verificaPertinencia(2));
        assertFalse(conjuntoA.verificaPertinencia(4));
    }
}
