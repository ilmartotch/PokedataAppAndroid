package com.example.pokecarddata.dati;

public class DatiCopertina {
    String image;
    String nomeSet;
    String idSet;

    public DatiCopertina(String image, String nomeSet, String idSet) {
        this.image = image;
        this.nomeSet = nomeSet;
        this.idSet = idSet;
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