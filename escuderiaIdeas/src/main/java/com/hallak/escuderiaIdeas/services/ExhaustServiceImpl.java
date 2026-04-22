package com.hallak.escuderiaIdeas.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hallak.escuderiaIdeas.dtos.ExaustaoRequisicao;
import com.hallak.escuderiaIdeas.dtos.ExaustaoResposta;
import com.hallak.escuderiaIdeas.dtos.PrimaryTubeIdeal;
import com.hallak.escuderiaIdeas.dtos.TuboComercial;
import com.hallak.escuderiaIdeas.utils.MathUtils;

@Component
public class ExhaustServiceImpl implements ExhaustService {

    private final List<TuboComercial> tubosComerciais = List.of(
        // 3/4 polegada
        new TuboComercial(19.05, 1.0, "3/4 polegada (Parede 1.0mm)"),
        new TuboComercial(19.05, 1.2, "3/4 polegada (Parede 1.2mm)"),
        new TuboComercial(19.05, 1.5, "3/4 polegada (Parede 1.5mm)"),
        
        // 7/8 polegada
        new TuboComercial(22.22, 1.0, "7/8 polegada (Parede 1.0mm)"),
        new TuboComercial(22.22, 1.2, "7/8 polegada (Parede 1.2mm)"),
        new TuboComercial(22.22, 1.5, "7/8 polegada (Parede 1.5mm)"),
        
        // 1 polegada
        new TuboComercial(25.40, 1.0, "1 polegada (Parede 1.0mm)"),
        new TuboComercial(25.40, 1.2, "1 polegada (Parede 1.2mm)"),
        new TuboComercial(25.40, 1.5, "1 polegada (Parede 1.5mm)"),
        
        // 1 1/8 polegada
        new TuboComercial(28.58, 1.0, "1 1/8 polegada (Parede 1.0mm)"),
        new TuboComercial(28.58, 1.2, "1 1/8 polegada (Parede 1.2mm)"),
        new TuboComercial(28.58, 1.5, "1 1/8 polegada (Parede 1.5mm)"),
        
        // 1 1/4 polegada
        new TuboComercial(31.75, 1.0, "1 1/4 polegada (Parede 1.0mm)"),
        new TuboComercial(31.75, 1.2, "1 1/4 polegada (Parede 1.2mm)"),
        new TuboComercial(31.75, 1.5, "1 1/4 polegada (Parede 1.5mm)"),
        
        // 1 3/8 polegada
        new TuboComercial(34.92, 1.0, "1 3/8 polegada (Parede 1.0mm)"),
        new TuboComercial(34.92, 1.2, "1 3/8 polegada (Parede 1.2mm)"),
        new TuboComercial(34.92, 1.5, "1 3/8 polegada (Parede 1.5mm)"),
        
        // 1 1/2 polegada
        new TuboComercial(38.10, 1.0, "1 1/2 polegada (Parede 1.0mm)"),
        new TuboComercial(38.10, 1.2, "1 1/2 polegada (Parede 1.2mm)"),
        new TuboComercial(38.10, 1.5, "1 1/2 polegada (Parede 1.5mm)"),
        
        // 1 5/8 polegada
        new TuboComercial(41.27, 1.0, "1 5/8 polegada (Parede 1.0mm)"),
        new TuboComercial(41.27, 1.2, "1 5/8 polegada (Parede 1.2mm)"),
        new TuboComercial(41.27, 1.5, "1 5/8 polegada (Parede 1.5mm)"),
        
        // 1 3/4 polegada
        new TuboComercial(44.45, 1.2, "1 3/4 polegada (Parede 1.2mm)"),
        new TuboComercial(44.45, 1.5, "1 3/4 polegada (Parede 1.5mm)"),
        new TuboComercial(44.45, 2.0, "1 3/4 polegada (Parede 2.0mm)"),
        
        // 1 7/8 polegada
        new TuboComercial(47.62, 1.2, "1 7/8 polegada (Parede 1.2mm)"),
        new TuboComercial(47.62, 1.5, "1 7/8 polegada (Parede 1.5mm)"),
        
        // 2 polegadas
        new TuboComercial(50.80, 1.2, "2 polegadas (Parede 1.2mm)"),
        new TuboComercial(50.80, 1.5, "2 polegadas (Parede 1.5mm)"),
        new TuboComercial(50.80, 2.0, "2 polegadas (Parede 2.0mm)"),
        
        // 2 1/4 polegadas
        new TuboComercial(57.15, 1.5, "2 1/4 polegadas (Parede 1.5mm)"),
        new TuboComercial(57.15, 2.0, "2 1/4 polegadas (Parede 2.0mm)"),
        
        // 2 1/2 polegadas
        new TuboComercial(63.50, 1.5, "2 1/2 polegadas (Parede 1.5mm)"),
        new TuboComercial(63.50, 2.0, "2 1/2 polegadas (Parede 2.0mm)"),
        
        // 3 polegadas
        new TuboComercial(76.20, 1.5, "3 polegadas (Parede 1.5mm)"),
        new TuboComercial(76.20, 2.0, "3 polegadas (Parede 2.0mm)"),
        
        // 3 1/2 polegadas
        new TuboComercial(88.90, 1.5, "3 1/2 polegadas (Parede 1.5mm)"),
        new TuboComercial(88.90, 2.0, "3 1/2 polegadas (Parede 2.0mm)"),
        
        // 4 polegadas
        new TuboComercial(101.60, 1.5, "4 polegadas (Parede 1.5mm)"),
        new TuboComercial(101.60, 2.0, "4 polegadas (Parede 2.0mm)")
    );

    @Override
    public ExaustaoResposta calculateExhaust(ExaustaoRequisicao exaustaoRequisicao){
        PrimaryTubeIdeal primaryTubeIdeal = MathUtils.calculatePrimaryTube(exaustaoRequisicao);

        TuboComercial tuboComercialPrimarioEscolhido = tubosComerciais.stream().
        min(Comparator.comparingDouble(tubo -> 
            Math.abs(tubo.getDiametroInterno() - primaryTubeIdeal.diametroInternoIdealMM()))).orElseThrow(() ->
            new RuntimeException("Nenhum tubo comercial encontrado com diâmetro interno próximo ao ideal."));

        TuboComercial tuboComercialSecundarioEscolhido = tubosComerciais.stream()
    .filter(tubo -> tubo.getDiametroInterno() > tuboComercialPrimarioEscolhido.getDiametroInterno())
    .min(Comparator.comparingDouble(TuboComercial::getDiametroInterno))
    .orElseThrow(() -> new RuntimeException("Nenhum tubo secundário válido encontrado"));


        double comprimentoColetor = MathUtils.calculateConeofTransition(
            tuboComercialPrimarioEscolhido.getDiametroInterno(), 
            tuboComercialSecundarioEscolhido.getDiametroInterno(), 
            exaustaoRequisicao.anguloDivergencia());

        double comprimentoIdealSecundarioMM = MathUtils.calculateSecundaryTube(primaryTubeIdeal.comprimentoIdealMM(), comprimentoColetor);
        




        return new ExaustaoResposta(
            primaryTubeIdeal.comprimentoIdealMM(),
            primaryTubeIdeal.diametroInternoIdealMM(),
            tuboComercialPrimarioEscolhido.name(),
            tuboComercialPrimarioEscolhido.diametroExterno(),
            tuboComercialPrimarioEscolhido.espessuraParede(),
            tuboComercialPrimarioEscolhido.getDiametroInterno(),
            tuboComercialSecundarioEscolhido.name(),
            tuboComercialSecundarioEscolhido.diametroExterno(),
            comprimentoIdealSecundarioMM,
            tuboComercialSecundarioEscolhido.espessuraParede(),
            tuboComercialSecundarioEscolhido.getDiametroInterno(),
            comprimentoColetor,
            tuboComercialSecundarioEscolhido.getDiametroInterno() / tuboComercialPrimarioEscolhido.getDiametroInterno()
        );
    }
}
