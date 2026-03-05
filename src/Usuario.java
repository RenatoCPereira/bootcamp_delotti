import java.util.Objects;

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
        return idade == usuario.idade && Objects.equals(nome, usuario.nome) && Objects.equals(cpf, usuario.cpf) && Objects.equals(senha, usuario.senha) && Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, idade, senha, email);
    }

    @Override
    public String toString() {
        return "\n nome = " + nome +
                "\n cpf = " + cpf +
                "\n idade = " + idade +
                "\n senha = " + senha +
                "\n email = " + email +
                "\n-----------------------";
    }
}
