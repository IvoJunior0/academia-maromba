public class Colaborador {
    // Atributos
    private static int contador;
    private int codigo;
    private String nome;

    // Construtores
    public Colaborador() {
        this.nome = "Auxiliar";
        contador++;
        this.codigo = contador;
    }

    public Colaborador(String nome) {
        this.nome = nome;
        contador++;
        this.codigo = contador;
    }

    // Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getID() {
        return this.codigo;
    }

    public int getContagem() {
        return contador;
    }
}