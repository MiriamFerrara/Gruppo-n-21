package com.example.saf;

public class Tipo {

    int imag;
    String nome, litri, gradi;

    public Tipo(int imag, String nome, String litri, String gradi) {
        this.imag = imag;
        this.nome = nome;
        this.litri = litri;
        this.gradi = gradi;
    }

    public int getImag() {
        return imag;
    }

    public String getNome() {
        return nome;
    }

    public String getLitri() {
        return litri;
    }

    public String getGradi() {
        return gradi;
    }
}
