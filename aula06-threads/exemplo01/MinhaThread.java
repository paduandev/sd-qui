package exemplo01;

public class MinhaThread extends Thread {
    
    public MinhaThread(String nome) {
        super(nome);
    }

    // run === main
    @Override
    public void run() {
        System.out.println("Executando a " + getName());
        try {
            sleep(3000); //simulando 3 seg de trabalho
        } catch (Exception e) {
            
        }
        System.out.println("Finalizando a " + getName());
    }
}
