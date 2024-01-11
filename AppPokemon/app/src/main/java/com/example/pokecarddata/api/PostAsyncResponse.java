package com.example.pokecarddata.api;

import com.example.pokecarddata.dati.DatiCopertina;

import java.util.ArrayList;

public interface PostAsyncResponse {
    void processoTerminato(ArrayList<DatiCopertina> listaDatiCopertina);

    void processoFallito(Exception e);
}
