import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class FitxerProperties {
    private Properties properties= new Properties();

    public FitxerProperties(){
        try {
            properties.load(new FileInputStream(new File("Files/BBDD.properties")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRandomPosicio()
    {
        int longitud = (int) properties.get("longitud");
        return (int) (Math.random() * longitud);
    }
    public int getRandomDamage()
    {
        int min = (int) properties.get("min_atac");
        int max = (int) properties.get("max_atac");
        return (int) (Math.random() * (max-min+1)) + min;
    }

    public int getRandomSpeed()
    {
        int min = (int) properties.get("min_velocitat");
        int max = (int) properties.get("max_velocitat");
        return (int) (Math.random() * (max-min+1)) + min;
    }
}
