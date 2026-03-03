import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Inserir usuario");
            System.out.println("2 - Listar usuario");
            System.out.println("3 - Atualizar usuario");
            System.out.println("4 - Deletar usuario");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção:");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0); // Repete enquanto não escolher 0





























        teclado.close();





    }
}