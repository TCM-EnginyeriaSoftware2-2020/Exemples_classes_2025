package CapaPresentacio;

import Subsystems.SubSystemA;
import Subsystems.SubSystemC;
import Subsystems.SubSystemE;
import Subsystems.Facade.Facade;

public class Clients_Main {

	public static void main(String[] args) {
		
		//clients();
		clientsFacade();
	}
	private static void clients()
	{
		// els clients fan el accés als subsistemes
		System.out.println("***El client C1 executa A i E");
		SubSystemA.getInstance().execute();
		SubSystemE.getInstance().execute();
		
		System.out.println("\n***El client C2 executa A i C");
		SubSystemA.getInstance().execute();
		SubSystemC.getInstance().execute();
		
		System.out.println("\n***El client C3 executa A i E");
		SubSystemA.getInstance().execute();
		SubSystemE.getInstance().execute();
	}

	
	private static void clientsFacade()
	{
		// els clients fan el accés als subsistemes
		System.out.println("***El client C1 executa A i E");
		Facade.executeProgramacioReflexiva(1,"A");
		Facade.executeProgramacioReflexiva(1,"E");
		
		System.out.println("\n***El client C2 executa A i C");
		Facade.executeProgramacioReflexiva(2,"A");
		Facade.executeProgramacioReflexiva(2,"C");
		
		System.out.println("\n***El client C3 executa A i E");
		Facade.executeProgramacioReflexiva(3,"A");
		Facade.executeProgramacioReflexiva(3,"E");
	}

}
