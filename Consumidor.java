package Produc;

public class Consumidor extends Thread{
   
    private int identificador;
    private ColaProd c;
    private int timePuesto;
    
    
    public Consumidor(int name, ColaProd c) {
        super();
        this.identificador = name;
        this.c = c;
        this.timePuesto = 0;
    }

    @Override
    public void run() {
        int retardo;
        int nCoche;
        while (c.isCochesPendiente()) {
            try {
                retardo=(int) (Math.random()*15 + 5);
                timePuesto+=retardo;
                nCoche=c.TerminarCoche(retardo);
                sleep (retardo);
                System.out.println("El puesto "+ identificador+" ha revisado el coche "+nCoche+" en un tiempo de "+retardo);
            } catch (InterruptedException e) {
                System.out.println("Error en el consumidor");
            }
        }
    }

}
