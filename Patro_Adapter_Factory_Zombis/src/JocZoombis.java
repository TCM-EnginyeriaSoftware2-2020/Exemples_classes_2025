public class JocZoombis {


    public static void main(String[] args) {
        System.out.println("Juguem!");

        FitxerProperties myProperties = new FitxerProperties();

        Personatge personatge = new Personatge( myProperties.getRandomPosicio() );

        ZoombiAmagat amagat = new ZoombiAmagat( myProperties.getRandomPosicio() );
        ZoombiAtacant atacant = new ZoombiAtacant( myProperties.getRandomPosicio(), myProperties.getRandomDamage());
        ZoombiCaminant caminant = new ZoombiCaminant( myProperties.getRandomPosicio(), myProperties.getRandomSpeed());

        while(personatge.getVida() > 0){

            if(caminant.moure(personatge.getPosicio()))
            {
                System.out.println("T'ha atrapat un caminant, però corres");
                personatge.setPosicio(myProperties.getRandomPosicio());
            }
            if( personatge.getPosicio() == amagat.getPosicio()){
                System.out.println("Has trobat un zoombi amagat, però corres");
                personatge.setPosicio(myProperties.getRandomPosicio());
            }
            if (personatge.getPosicio() == atacant.getPosicio()) {
                System.out.println("T'ha atacat un zoombi");
                personatge.setVida(atacant.getDamage());
            }
        }
        System.out.println("Has mort");
    }


}
