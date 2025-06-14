package capaDomini;

import capaPersistencia.IFontDades;

import java.util.ArrayList;
import java.util.List;

public final class FactoriaProducte {

    private static FactoriaProducte instanciaUnica = new FactoriaProducte();
    private FactoriaProducte(){}

    public static FactoriaProducte getInstanciaUnica() {
        return instanciaUnica;
    }

    public List<AbstractProduct> crearProducte(IFontDades font){
        List<String[]> dades = font.obtenirProductes();
        List<AbstractProduct> resultat = new ArrayList<>();
        AbstractProduct p;
        int id, venuts;
        String nom;
        float preu;

        for (String[] entrada : dades) {
            try {
                id = Integer.parseInt(entrada[0]);
                nom = entrada[1];
                preu = Float.parseFloat(entrada[2]);
                switch ( entrada.length){
                    case 3: p = crearProducte(id, nom, preu); break;
                    case 4:
                        venuts = Integer.parseInt(entrada[3]);
                        p = crearProducte(id, nom, preu, venuts);
                        break;
                    default:
                        throw new RuntimeException("Font de dades incorrecte");
                }
                resultat.add(p);
            } catch (Exception e) {
                System.err.println("Error en importar producte: " + e.getMessage());
            }
        }

        return resultat;
    }

    public AbstractProduct crearProducte(int id, String descripcio, float preu, int venuts) {
        return new ProducteVenut(id, descripcio, preu, venuts);
    }
    public AbstractProduct crearProducte(int id, String descripcio, float preu) {
        return new ProducteExtern(id, descripcio, preu);
    }
}
