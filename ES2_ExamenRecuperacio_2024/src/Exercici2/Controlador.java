package Exercici2;

import Exercici2.PatroEstats.IEstats;

public class Controlador {
    private double temperaturaSensor;
    private double temperaturaDesitjada;
    private boolean estiu;
    private IEstats estat;

    public Controlador( double temperaturaSensor, double temperaturaDesitjada)
    {
        this.temperaturaDesitjada = temperaturaDesitjada;
        this.temperaturaSensor = temperaturaSensor;
        this.estiu = true;
        this.estat = IEstats.getEstatInicial();
    }

    public void setTemperaturaSensor( double temperaturaSensor)
    {
        this.temperaturaSensor = temperaturaSensor;
        this.estat = this.estat.sensor(activarVentilador());
    }

    private boolean activarVentilador() // aquí podríem fer un patró estrategia
    {
        if( this.estiu)
            return this.temperaturaSensor > this.temperaturaDesitjada;
        return this.temperaturaSensor < this.temperaturaDesitjada;
    }


    public String botoON() { return "ON"; }
    public String botoVentilador() { return "algo"; }

    public void botoAugmentarTemperaturaDesitjada() { this.temperaturaDesitjada++; }
    public void botoDisminuirTemperaturaDesitjada() { this.temperaturaDesitjada--; }
}
