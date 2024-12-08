package model;

public class Coletor {
    private int coletorId;
    private String nome;
    private String telefone;
    private String areaAtuacao;

    public Coletor(int coletorId, String nome, String telefone, String areaAtuacao) {
        this.coletorId = coletorId;
        this.nome = nome;
        this.telefone = telefone;
        this.areaAtuacao = areaAtuacao;
    }

    public int getColetorId() { return coletorId; }
    public void setColetorId(int coletorId) { this.coletorId = coletorId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getAreaAtuacao() { return areaAtuacao; }
    public void setAreaAtuacao(String areaAtuacao) { this.areaAtuacao = areaAtuacao; }
}
