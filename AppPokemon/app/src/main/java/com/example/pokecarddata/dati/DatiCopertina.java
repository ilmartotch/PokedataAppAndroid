package com.example.pokecarddata.dati;

public class DatiCopertina {
    String image;
    String logo;
    String nomeSet;
    String idSet;
    int totalCard;

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

    public DatiCopertina(String image, String logo, String nomeSet, String idSet, int totalCard) {
        this.image = image;
        this.logo = logo;
        this.nomeSet = nomeSet;
        this.idSet = idSet;
        this.totalCard = totalCard;
    }
}


//JSON SEMPLE RESPONSE
//{
//        "data": {
//        "id": "swsh1",
//        "name": "Sword & Shield",
//        "series": "Sword & Shield",
//        "printedTotal": 202,
//        "total": 216,
//        "legalities": {
//        "unlimited": "Legal",
//        "standard": "Legal",
//        "expanded": "Legal"
//        },
//        "ptcgoCode": "SSH",
//        "releaseDate": "2020/02/07",
//        "updatedAt": "2020/08/14 09:35:00",
//        "images": {
//        "symbol": "https://images.pokemontcg.io/swsh1/symbol.png",
    //        "logo": "https://images.pokemontcg.io/swsh1/logo.png"
//        }
//        }
//        }