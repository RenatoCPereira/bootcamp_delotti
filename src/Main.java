import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Inserir usuário");
            System.out.println("2 - Listar usuário");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Deletar usuário");
            System.out.println("0 - Sair");
            System.out.print(" Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    Usuario.cadastrar(listaUsuarios, teclado);
                    break;
                case 2:
                    Usuario.listar(listaUsuarios);
                    break;
                case 3:
                    Usuario.atualizar(listaUsuarios, teclado);
                    break;
                case 4:
                    Usuario.remover(listaUsuarios, teclado);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        teclado.close();


    }
}