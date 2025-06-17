package domini.patroAbstractFactory;

import domini.patroComposite.*;

public interface IAbstractFactory {
        SensorIndividual crearSensorIndividual(String nom, SensorIndividual.Tipus seleccio);
        DispositiuCompost crearDispositiu(String nom, SensorIndividual.Tipus[] selArray); // grup de sensors
}
