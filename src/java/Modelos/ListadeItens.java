package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rian Alves
 */
public class ListadeItens {

    private static List<Produto> itensPedido;

    public static List<Produto> getItens() {
        if (itensPedido == null) {
            itensPedido = new ArrayList<>();
            itensPedido.add(new Produto(0, "Arroz a Grega", 21.0));
            itensPedido.add(new Produto(1, "Feijão Tropeiro", 32.0));
            itensPedido.add(new Produto(2, "Batata Frita", 21.0));

        }

        return itensPedido;
    }
}
