package it.vigorelli;

public class Persona {
    private String nome;
    private String cognome;
    private boolean editable;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona() {
        this.editable = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Persona");
        sb.append("{nome='").append(nome).append('\'');
        sb.append(", cognome='").append(cognome).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;

        Persona persona = (Persona) o;

        if (cognome != null ? !cognome.equals(persona.cognome) : persona.cognome != null) return false;
        if (nome != null ? !nome.equals(persona.nome) : persona.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (cognome != null ? cognome.hashCode() : 0);
        return result;
    }
}
