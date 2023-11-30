package com.sarrussys.bloodguardian.services;

import com.sarrussys.bloodguardian.repositores.BolsaSangueRepository;
import com.sarrussys.bloodguardian.repositores.SaidasRepository;

import java.util.Arrays;
import java.util.List;

public class SaidaService {

    private BolsaSangueRepository bolsaSangueRepository = new BolsaSangueRepository();
    private SaidasRepository saidasRepository = new SaidasRepository();


    public List<Integer> getPorcentageEntradasSaidas() {
        Integer tamanhoEntrada = bolsaSangueRepository.buscarTodos().size();
        Integer tamanhoSaidas = saidasRepository.buscarTodos().size();

        return Arrays.asList(tamanhoEntrada, tamanhoSaidas);
    }
}
