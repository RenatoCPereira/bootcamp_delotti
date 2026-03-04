import java.util.Objects;

public class Usuario {

    private String nome;
    private String cpf;
    private int idade;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idade == usuario.idade && Objects.equals(nome, usuario.nome) && Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, idade);
    }

    @Override
    public String toString() {
        return "nome = " + nome + "\n" +
                "cpf = " + cpf + "\n" +
                "idade = " + idade + "\n" +
                "_________________________";


    }
}
