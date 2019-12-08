package prioritario.model;

import java.util.LinkedList;
import java.util.Queue;

public class Banco {
    private Queue<String> filaNormal;
    private Queue<String> filaPrioritaria;
    private int qtprioritario;
    private int qtnormal;
    private int consecutivo;


    public Banco() {
        this.filaNormal = new LinkedList<>();
        this.filaPrioritaria = new LinkedList<>();
        qtprioritario = 1;
        qtnormal = 1;
        consecutivo = 0;
    }

    public void addPrioritario(){
        filaPrioritaria.add("P"+qtprioritario);
        qtprioritario+=1;
    }

    public void addNormal(){
        filaNormal.add("N"+qtnormal);
        qtnormal+=1;
    }

    private String remPrioritario(){
        return filaPrioritaria.poll();
    }

    private String remNormal(){
        return filaNormal.poll();
    }

    public String desenfileirar(){
        if (!filaPrioritaria.isEmpty() && consecutivo<3){
            consecutivo += 1;
            return remPrioritario();
        } else if (!filaNormal.isEmpty()) {
            consecutivo = 0;
            return remNormal();
        } else if (!filaPrioritaria.isEmpty()){
            consecutivo += 1;
            return remPrioritario();
        }
        return "fila vazia";
    }

    public void imprimir(){
        Queue<String> auxNormal = new LinkedList<>(this.filaNormal);
        Queue<String> auxPrioritario = new LinkedList<>(this.filaPrioritaria);
        int c = consecutivo;
        while (!filaNormal.isEmpty() && !filaPrioritaria.isEmpty()){
            System.out.print(desenfileirar()+" ");
        }
        while (!filaNormal.isEmpty()){
            System.out.print(desenfileirar()+" ");
        }
        while (!filaPrioritaria.isEmpty()){
            System.out.print(desenfileirar()+" ");
        }
        System.out.println();

        this.filaNormal = auxNormal;
        this.filaPrioritaria = auxPrioritario;
        this.consecutivo = c;

//        int tamannho = filaNormal.size() + filaPrioritaria.size();
//        int indiceN = 0;
//        int indiceP = 0;
//        int c = consecutivo;
//        System.out.println(tamannho);
//        for (int i = 0; i < tamannho; i++){
//            if (c<2){
//                System.out.println(filaPrioritaria.element(indiceP));
//            }
//        }
    }


}
