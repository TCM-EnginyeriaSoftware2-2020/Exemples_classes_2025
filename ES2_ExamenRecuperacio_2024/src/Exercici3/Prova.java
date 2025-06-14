package Exercici3;

public class Prova {

    public static void main(String[] args) {
        PersonaComposta elisa = new PersonaComposta("Elisa Saryol", AbstractPerson.Genere.Dona, 10);
        PersonaComposta julian = new PersonaComposta("Julian Horrillo", AbstractPerson.Genere.Home, 8);
        PersonaComposta adso = new PersonaComposta("Adso Fernandez", AbstractPerson.Genere.Home, 8);
        elisa.add(julian);
        elisa.add(adso);

        PersonaComposta triado = new PersonaComposta("Joan Triadó", AbstractPerson.Genere.Home, 6);
        PersonaComposta rosa = new PersonaComposta("Rosa Herrero", AbstractPerson.Genere.Dona, 6);
        julian.add(triado);
        julian.add(rosa);

        PersonaFulla alfons = new PersonaFulla("Alfons Palacios", AbstractPerson.Genere.Home, 4);
        rosa.add(alfons);
        //la resta de l'organigrama és repetitiu

        System.out.println("Salari total: " + elisa.getSalari());
        System.out.println(elisa.mostrarPercentatgeGenere());
    }

}
