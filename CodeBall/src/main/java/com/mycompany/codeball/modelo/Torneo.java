package com.mycompany.codeball.modelo;

import java.util.ArrayList;

public class Torneo {

    private String descripcion;
    private ArrayList<EquipoTemporada> equipos = new ArrayList<>();
    private FasePuntos fasePuntos;
    private FaseEliminatoria faseEliminatoria;

    public Torneo(String descripcion, FaseEliminatoria faseEliminatoria) {
        this.descripcion = descripcion;
        this.faseEliminatoria = faseEliminatoria;
        this.fasePuntos = conseguirFasePuntos(faseEliminatoria);
        this.equipos = conseguirEquipoEnBaseAFase(this.fasePuntos);
    }
  
    public Torneo() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<EquipoTemporada> getEquipos() {
        return equipos;
    }

    public FasePuntos getFasePuntos() {
        return fasePuntos;
    }

    public FaseEliminatoria getFaseEliminatoria() {
        return faseEliminatoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEquipos(ArrayList<EquipoTemporada> equipos) {
        this.equipos = equipos;
    }

    public void setFasePuntos(FasePuntos fasePuntos) {
        this.fasePuntos = fasePuntos;
    }

    public void setFaseEliminatoria(FaseEliminatoria faseEliminatoria) {
        this.faseEliminatoria = faseEliminatoria;
    }
    
    public ArrayList<EquipoTemporada> conseguirEquipoEnBaseAFase(FasePuntos fase){
        ArrayList<EquipoTemporada> equipos = new ArrayList<>();
        for(Grupo g: fase.getGrupos()){
            for(EquipoTemporada e: g.getEquipos()){
                equipos.add(e);
            }
        }
        return equipos;
    }
    
    public FasePuntos conseguirFasePuntos(FaseEliminatoria faseE){
        return faseE.getFasePuntos();
    }
}
