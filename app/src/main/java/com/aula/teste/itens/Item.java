package com.aula.teste.itens;

public class Item {

    String name;
    String email;
    int imagem;

    public Item(String name, String email, int imagem) {
        this.name = name;
        this.email = email;
        this.imagem = imagem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
