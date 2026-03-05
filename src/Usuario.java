import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Usuario {

    public String nome;
    public String cpf;
    public int idade;
    public String senha;
    public String email;


    public Usuario() {
    }

    public Usuario(String nome, String cpf, int idade, String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.senha = senha;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "\n Nome = " + nome +
                "\n Cpf = " + cpf +
                "\n Idade = " + idade +
                "\n Email = " + email +
                "\n Senha = " + senha +
                "\n-----------------------";
    }


    public static void cadastrar(ArrayList<Usuario> listaUsuarios, Scanner teclado) {

        Usuario usuario = new Usuario();

        System.out.println("Informe o nome:");
        usuario.setNome(teclado.nextLine());

        System.out.println("Informe o CPF:");
        String cpf = teclado.nextLine();

        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                System.out.println("CPF já cadastrado!");
                return;
            }
        }

        usuario.setCpf(cpf);

        System.out.println("Informe a idade:");
        usuario.setIdade(teclado.nextInt());
        teclado.nextLine();

        System.out.println("Informe o email:");
        usuario.setEmail(teclado.nextLine());

        System.out.println("Informe a senha:");
        usuario.setSenha(teclado.nextLine());

        listaUsuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void listar(ArrayList<Usuario> listaUsuarios) {

        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario us : listaUsuarios) {
            System.out.println(us);
        }
    }

    public static void atualizar(ArrayList<Usuario> listaUsuarios, Scanner teclado) {

        System.out.println("Informe o CPF do usuário que deseja atualizar:");
        String cpf = teclado.nextLine();

        boolean encontrado = false;

        for (Usuario usuario : listaUsuarios) {

            if (usuario.getCpf().equals(cpf)) {

                System.out.println("Usuário encontrado!");

                System.out.println("Novo nome:");
                usuario.setNome(teclado.nextLine());

                System.out.println("Nova idade:");
                usuario.setIdade(teclado.nextInt());
                teclado.nextLine();

                System.out.println("Novo email:");
                usuario.setEmail(teclado.nextLine());

                System.out.println("Nova senha:");
                usuario.setSenha(teclado.nextLine());

                System.out.println("Usuário atualizado com sucesso!");

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Usuário não encontrado!");
        }
    }


    public static void remover(ArrayList<Usuario> listaUsuarios, Scanner teclado) {

        System.out.println("Informe o CPF do usuário:");
        String cpf = teclado.nextLine();

        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);

        if (listaUsuarios.remove(usuario)) {
            System.out.println("Usuário removido com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
