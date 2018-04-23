
package Modelos;

/**
 *
 * @author Rian Alves
 */
public class Item {
    private int idItem;
    private Produto produto;
    private int quantidade; 

    public Item(Produto produto, int quantidade) {
        this.idItem = produto.getCodigo();
        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
