package exercici1;

import exercici1.statePattern.Confirmat;
import exercici1.statePattern.IState;

import java.util.UUID;

public class Comanda {

    /* ---------- Atributs d’instància ---------- */
    private IState estat;
    private String direccio;
    private String numeroSeguiment;
    private int intentsFallits;          // gestionat exclusivament pels estats NO_ENTREGAT*

    /* ---------- Constructor ---------- */
    public Comanda(String direccio) {
        this.estat = Confirmat.getInstance();
        this.direccio = direccio;
        this.intentsFallits = 0;
    }

    /* ---------- Getters públics ---------- */
    public IState getEstat()               { return estat; }
    public String getNumeroSeguiment()     { return numeroSeguiment; }
    public String getDireccio()            { return direccio; }
    public int    getIntentsFallits()      { return intentsFallits; }

    /* ---------- Canvi d’adreça (només permès en PREPARACIO i ADRECA_INCORRECTA) ---------- */
    public void actualitzarDireccio(String nova) {
        if(nova == null) throw new IllegalArgumentException("Adreça incorrecte");
        this.estat = estat.actualitzarDireccio();
        this.direccio = nova;
    }

    /* ---------- Operacions de flux ---------- */
    public void preparar() {
        this.estat = estat.preparar();
    }

    public void enviar() {
        this.estat = estat.enviar();
        numeroSeguiment = UUID.randomUUID().toString();
    }

    public void iniciarTransit() {
        this.estat = estat.iniciarTransit();
    }

    public void lliurar() {
        this.estat = estat.lliurar();
    }

    public void registrarAbsencia() {
        intentsFallits++;
        this.estat = estat.registrarAbsencia(intentsFallits);
    }

    public void registrarDireccioIncorrecta() {
        intentsFallits++;
        this.estat = estat.registrarDireccioIncorrecta();
    }

    /** Simula que han passat 3 dies sense nova adreça */
    public void caducarDireccioSenseCanvi() {
        this.estat = estat.caducarDireccioSenseCanvi();
    }

    public void rebreDevolucio() {
        this.estat = estat.rebreDevolucio();
    }

}

