package com.hallak.escuderiaIdeas.utils;

import com.hallak.escuderiaIdeas.dtos.ExaustaoRequisicao;
import com.hallak.escuderiaIdeas.dtos.PrimaryTubeIdeal;

public class MathUtils {


    public static PrimaryTubeIdeal calculatePrimaryTube(ExaustaoRequisicao requisicao){
        //(P = [(850 * ED) / RPM] - 3)

        double ed = 180 + requisicao.anguloValvulaBPMI();
        double comprimentoIdealPOL = (850 * ed) / requisicao.rpm() - 3;
        double comprimentoIdealMM = comprimentoIdealPOL * 25.4;
        
        double diametroInternoIdealPOL = Math.sqrt(requisicao.cc() / ((comprimentoIdealPOL + 3.0) * 25.0)) * 2.1;
        double diametroInternoIdealMM = diametroInternoIdealPOL * 25.4;

        return new PrimaryTubeIdeal(comprimentoIdealMM, diametroInternoIdealMM);
    }

    public static double calculateConeofTransition(double diametroInternoPrimarioMM, double diametroInternoSecundarioMM, double anguloDivergencia) {
      // CL = ((Tubo Secundário - Tubo Primário) / 2) * cot(α);

        return (diametroInternoSecundarioMM - diametroInternoPrimarioMM) / 2 * 
            (1 / Math.tan(Math.toRadians(anguloDivergencia)));

    }

    public static double calculateSecundaryTube(double comprimentoTuboPrimarioMM, double comprimentoColetorMM) {
        double comprimentoPrimarioPOL = comprimentoTuboPrimarioMM / 25.4;
        double comprimentoConePOL = comprimentoColetorMM / 25.4;

        double tlPOL = (comprimentoPrimarioPOL + 3) - comprimentoConePOL;

        return tlPOL * 25.4;
}

}
