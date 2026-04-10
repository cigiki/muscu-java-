package com.example.muscu;

public class PlanningExercice {
    private int jour;
    private String nomExercice;

    public PlanningExercice(int jour, String nomExercice) {
        this.jour = jour;
        this.nomExercice = nomExercice;
    }

    public int getJour() { return jour; }
    public String getNomExercice() { return nomExercice; }
}