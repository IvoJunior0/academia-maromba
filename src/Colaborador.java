public class Colaborador {
    // Atributos
    private String nome;

    // Construtores
    public Colaborador() {
        this.nome = "Auxiliar";
    }

    public Colaborador(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}