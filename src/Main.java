import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Inserir usuario");
            System.out.println("2 - Listar usuario");
            System.out.println("3 - Atualizar usuario");
            System.out.println("4 - Deletar usuario");
            System.out.println("0 - Sair");
            System.out.print(" Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    Usuario usuario = new Usuario();
                    System.out.println("Informe seu nome:");
                    usuario.setNome(teclado.nextLine());
                    System.out.println("Informe seu cpf:");
                    usuario.setCpf(teclado.nextLine());
                    System.out.println("Informe sua idade:");
                    usuario.setIdade(teclado.nextInt());
                    listaUsuarios.add(usuario);
                    System.out.println("Cadastro realizado com sucesso!");
                    break;

                case 2:
                    if (listaUsuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado!.");
                    } else {
                        for (Usuario us : listaUsuarios) {
                            System.out.println(us);
                        }
                    }

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

        } while (opcao != 0);

        teclado.close();


    }
}