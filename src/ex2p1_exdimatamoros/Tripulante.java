/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex2p1_exdimatamoros;

/**
 *
 * @author exdir
 */
public class Tripulante {
    private String nombre;
    private String especie;
    private String planeta;
    int habilidadAtaque;
    int habilidadDefensa;
    int habilidadTecnica;
    
    public Tripulante(String nombre, String especie, String planeta, int habilidadAtaque, int habilidadDefensa, int habilidadTecnica) {
        this.nombre = nombre;
        this.especie = especie;
        this.planeta = planeta;
        this.habilidadAtaque = habilidadAtaque;
        this.habilidadDefensa = habilidadDefensa;
        this.habilidadTecnica = habilidadTecnica;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public int getHabilidadAtaque() {
        return habilidadAtaque;
    }

    public void setHabilidadAtaque(int habilidadAtaque) {
        this.habilidadAtaque = habilidadAtaque;
    }

    public int getHabilidadDefensa() {
        return habilidadDefensa;
    }

    public void setHabilidadDefensa(int habilidadDefensa) {
        this.habilidadDefensa = habilidadDefensa;
    }

    public int getHabilidadTecnica() {
        return habilidadTecnica;
    }

    public void setHabilidadTecnica(int habilidadTecnica) {
        this.habilidadTecnica = habilidadTecnica;
    }
    
    @Override
     public String toString() {
        return "Tripulante{" + "nombre=" + nombre + ", especie=" + especie + ", planeta=" + planeta + ", habilidadAtaque=" + habilidadAtaque + ", habilidadDefensa=" + habilidadDefensa + ", habilidadTecnica=" + habilidadTecnica + '}';
    }
     
}
