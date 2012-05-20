package it.vigorelli;


public class Citta {
    private String nome;
    private int postalCode;

    public Citta() {
    }

    public Citta(String nome, int postalCode) {
        this.nome = nome;
        this.postalCode = postalCode;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Citta");
        sb.append("{nome='").append(nome).append('\'');
        sb.append(", postalCode=").append(postalCode);
        sb.append('}');
        return sb.toString();
    }
}
