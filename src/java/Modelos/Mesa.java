package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rian Alves
 */
public class Mesa {

    private Pedido pedidos;
    private static ArrayList<Mesa> mesas;
    private int id;
    private boolean status;
    private String descricao; 

    public Mesa(Pedido pedidos, boolean status) {
        this.pedidos = pedidos;
        this.status = status;
    }

    public Mesa(int id,String descricao) {
        this.id = id;
        this.descricao = descricao;  
    }

    /**
     * @return the pedidos
     */
    public Pedido getPedido() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedido(Pedido pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    //Criação das 9 mesas pré definidas
    public static ArrayList<Mesa> inicializaMesas() {
        if (mesas == null) {
            mesas = new ArrayList<>();
            for(int i = 0; i< 9; i++)
            {
                mesas.add(new Mesa(i,"Mesa "+i));
            }
        }
        return mesas;
    }

    
    public String getDescricao() {
        return descricao;
    }

    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
