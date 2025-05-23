package Subsystems.Facade;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import CapaPresistencia.AccesAFitxer;
import Subsystems.*;

public final class Facade {
	// façana és única -> singleton

	private Facade(){}

	// un altre exemple de façana
	public static void imprimir(){
		SubSystemA.getInstance().execute();
	}
	public static void encuadernar(){
		SubSystemC.getInstance().execute();
	}
	public static void fotocopiar(){
		SubSystemE.getInstance().execute();
	}

	public static void execute(int client, String nameSubSystem){
		if( ! AccesAFitxer.getInstance().tePermisos(client,nameSubSystem))
			throw new RuntimeException("El client "+ client +" no té accés a "+nameSubSystem);

		switch (nameSubSystem){
			case "A": SubSystemA.getInstance().execute();break;
			case "C": SubSystemC.getInstance().execute();break;
			case "E": SubSystemE.getInstance().execute();break;
			default: throw new RuntimeException("Subsistema incorrecte");
		}
	}

	public static void executeProgramacioReflexiva(int client, String nameSubSystem) {
		if (!AccesAFitxer.getInstance().tePermisos(client, nameSubSystem))
			throw new RuntimeException("El client " + client + " no té accés a " + nameSubSystem);

		nameSubSystem = "Subsystems.SubSystem"+nameSubSystem;
		try {
			Class laClasse = Class.forName(nameSubSystem);
			Method elMetodeEstatic = laClasse.getMethod("getInstance");
			Method elMetodeObjectual = laClasse.getMethod("execute");
			ISubSystem instance = (ISubSystem) elMetodeEstatic.invoke(null);
			elMetodeObjectual.invoke( instance );

			//SubSystemA.getInstance().execute();
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}