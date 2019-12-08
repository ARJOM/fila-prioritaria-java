package prioritario.view;

import prioritario.model.Banco;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Scanner scanner = new Scanner(System.in);

        menu();
        int opcao = scanner.nextInt();

        do {
            if (opcao==1){
                banco.addPrioritario();
            } else if (opcao==2){
                banco.addNormal();
            } else if (opcao==3){
                System.out.println(banco.desenfileirar());
            }
            banco.imprimir();
            opcao = scanner.nextInt();
        } while (opcao!=4);


//        banco.addNormal();
//        banco.addNormal();
//        banco.addNormal();
//        banco.addPrioritario();
//        banco.desenfileirar();
    }

    public static void menu(){
        System.out.println("" +
                "1) Adicionar um prioritario\n" +
                "2) Adicionar um normal\n" +
                "3) Desenfileirar\n" +
                "4) Sair");
    }
}
