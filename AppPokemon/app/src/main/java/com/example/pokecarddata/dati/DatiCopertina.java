package com.example.pokecarddata.dati;

import java.io.Serializable;

public class DatiCopertina implements Serializable {
    String image;
    String logo;
    String nomeSet;
    String idSet;
    int totalCard;
    String dataRilascio;

    public String getDataRilascio() {
        return dataRilascio;
    }

    public void setDataRilascio(String dataRilascio) {
        this.dataRilascio = dataRilascio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNomeSet() {
        return nomeSet;
    }

    public void setNomeSet(String nomeSet) {
        this.nomeSet = nomeSet;
    }

    public String getIdSet() {
        return idSet;
    }

    public void setIdSet(String idSet) {
        this.idSet = idSet;
    }

    public int getTotalCard() {
        return totalCard;
    }

    public void setTotalCard(int totalCard) {
        this.totalCard = totalCard;
    }

    public DatiCopertina(String image, String logo, String nomeSet, String idSet, int totalCard, String dataRilascio) {
        this.image = image;
        this.logo = logo;
        this.nomeSet = nomeSet;
        this.idSet = idSet;
        this.totalCard = totalCard;
        this.dataRilascio = dataRilascio;
    }
}
