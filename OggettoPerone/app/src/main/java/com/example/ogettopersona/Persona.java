package com.example.ogettopersona;

import java.io.Serializable;

public class Persona implements Serializable {

    public String nome;
    public String cognome;

    public Persona(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String GetNomeCognome(){
        return nome + " " + cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
