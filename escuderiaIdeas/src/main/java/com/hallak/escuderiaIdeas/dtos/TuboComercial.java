package com.hallak.escuderiaIdeas.dtos;

public record TuboComercial(double diametroExterno, double espessuraParede, String name) {
    public double getDiametroInterno() {
        return diametroExterno - 2 * espessuraParede;
    }
	
}
