package com.hallak.escuderiaIdeas.dtos;

public record ExaustaoResposta(double comprimentoIdealPrimarioMM, double diametroInternoIdealPrimarioMM,
    String comercialPrmarioTuboSugerido, double comercialPrimarioDiametroExternoMM,
    double comercialPrimarioEspessuraParedeMM, double comercialPrimarioDiametroInternoMM,
    String comercialSecundarioTuboSugerido, double comercialSecundarioDiametroExternoMM,
    double comprimentoIdealSecundarioMM,double comercialSecundarioEspessuraParedeMM, double comercialSecundarioDiametroInternoMM,
    double comprimentoConeTransicaoMM, double razaoExpansao
) {

}
