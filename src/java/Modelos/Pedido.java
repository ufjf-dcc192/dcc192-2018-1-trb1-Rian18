package Modelos;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import java.io.File;
import static java.lang.System.in;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rian Alves
 */
public class Pedido {

    
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    private int id;
    private Double somaT;
    private ArrayList<Item> itens;

    public Pedido(LocalDateTime horaInicio, LocalDateTime horaFim, int mesa) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.id = mesa;
        itens = new ArrayList<>();
        for(Produto item:ListadeItens.getItens() )
        {
            
            itens.add(new Item(item,0));
        }
        somaT=0.0;
    }

   
    public String getHoraInicio() {
        return horaInicio.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFim
     */
    public String getHoraFim() {
        if(horaFim == null)
        {
            return "Pedido Aberto";
        }
        return horaFim.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(LocalDateTime horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @return the status


    /**
     * @return the itens
     */
    public ArrayList<Item> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void setItem(Item i) {
        this.itens.add(i);
    }
     public Item getItem(int i) {
         return itens.get(i);
    }

    /**
     * @return the somaT
     */
    public Double getSomaT() {
        somaT = 0.0;
        for(Item item:this.itens)
        {
            somaT+=(item.getProduto().getPreco()*item.getQuantidade());
        }
        return somaT;
    }

    /**
     * @param somaT the somaT to set
     */
    public void setSomaT(Double somaT) {
        this.somaT = somaT;
    }

    public static File gerarArquivo(Integer numMesa) {
        return new File("TESTE", "Pedido " + numMesa + ".txt");
    }

    

    public Date StringToHora(String hora1) {
        Date hora = null;
        return hora;

    }

    public String ToSerial(int i) {
        return this.getItens().get(i) + "";
    }

    /**
     * @return the id
     */
    public int getMesa() {
        return id;
    }

    /**
     * @param mesa the id to set
     */
    public void setMesa(int mesa) {
        this.id = mesa;
    }
    
    



}
