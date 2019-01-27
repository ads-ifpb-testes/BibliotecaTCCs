package com.ifpb.model;

public class Usuario {

    private int id;
    private static int contador;
    private String nome;
    private String sexo;
    private String email;
    private String senha;
    private String curso;

    public Usuario(String nome, String sexo, String email, String senha, String curso) {
		this.id = ++contador;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
		this.curso = curso;
	}

	public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
