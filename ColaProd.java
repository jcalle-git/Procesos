package Produc;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class ColaProd {

    private PriorityQueue<Integer> colaDeCliente;
    private int tiempoTotal;
    private Semaphore sm;
    
    public ColaProd() {
        sm=new Semaphore(1);
        this.tiempoTotal = 0;
        this.colaDeCliente=new PriorityQueue<Integer>();
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }



    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }



    public void nuevoCoche(int nCoche) {
        try {
            sm.acquire();
            colaDeCliente.add(nCoche);
            sm.release();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR EN CREAR COCHE");
        }
    }
    
    public int TerminarCoche(int tiempoParcial) {
        int coche=0;
        try {
            if (isCochesPendiente()) {
                sm.acquire();
                coche=colaDeCliente.poll();
                tiempoTotal+=tiempoParcial;
                sm.release();
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println("ERROR EN ELIMINAR COCHE");
        }
        return coche;
    }

    public boolean isCochesPendiente() {
        // TODO Auto-generated method stub
        return colaDeCliente.size() > 0;
    }


}
