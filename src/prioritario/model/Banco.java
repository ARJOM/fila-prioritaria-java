package prioritario.model;

import java.util.LinkedList;
import java.util.List;
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

    public Queue<String> getFilaNormal() {
        return filaNormal;
    }

    public Queue<String> getFilaPrioritaria() {
        return filaPrioritaria;
    }

    public void setFilaNormal(Queue<String> filaNormal) {
        this.filaNormal = filaNormal;
    }

    public void setFilaPrioritaria(Queue<String> filaPrioritaria) {
        this.filaPrioritaria = filaPrioritaria;
    }

    public void setConsecutivo(int c){
        this.consecutivo = c;
    }

    public void addPrioritario(){
        filaPrioritaria.add("P"+qtprioritario);
        qtprioritario+=1;
    }

    public void addNormal(){
        filaNormal.add("N"+qtnormal);
        qtnormal+=1;
    }

    public String remPrioritario(){
        return filaPrioritaria.poll();
    }

    public String remNormal(){
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
            System.out.print(desenfileirar());
        }
        while (!filaNormal.isEmpty()){
            System.out.print(desenfileirar());
        }
        while (!filaPrioritaria.isEmpty()){
            System.out.print(desenfileirar());
        }
        setFilaNormal(auxNormal);
        setFilaPrioritaria(auxPrioritario);
        setConsecutivo(c);

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


//        def enfileirar(fila, num):
//        fila.append(num)
//
//        def desenfileirar(fila):
//        return fila.pop(0)
//
//        def estahVazia(fila):
//        if len(fila)==0:
//        return True
//        return False
//
//        def inserir(tipo):
//        if tipo=="normal":
//        global filan
//        global IN
//        enfileirar(filan, IN)
//        elif tipo=="prioritario":
//        global filap
//        global IP
//        enfileirar (filap, IP)
//
//        def remover():
//        global c
//        valor = None
//        if (not estahVazia(filap)) and (c < 2):
//        valor = "P"+str(desenfileirar(filap))
//        c+= 1
//        elif(not estahVazia(filan)):
//        valor = "N"+str(desenfileirar(filan))
//        c = 0
//        return valor
//
//        c = 0
//        filan = criarFila()
//        filap = criarFila()
//        IN = 1
//        IP = 1
//
//        op = int(input("Informe uma operação: "))
//        while (op != 4):
//        if (op==1):
//        inserir("normal")
//        IN += 1
//        elif(op==2):
//        inserir("prioritario")
//        IP += 1
//        elif(op==3):
//        print(remover())
//        op = int(input("Informe uma operação: "))