package CapaAplicacio;

import CapaDomini.EstrategiaDescompteVenda.IEstrategiaDescompteVenda;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;


public abstract class FactoriaAbstracteEstrategiaDescompteVenda {

	private static IEstrategiaDescompteVenda estrategiaFixarPreuVenda;

	public static final IEstrategiaDescompteVenda getEstrategiaFixarPreuVenda() {
		if (estrategiaFixarPreuVenda == null) {
			try {

				Properties laMevaConfiguracio = new Properties();
				laMevaConfiguracio.load(new FileInputStream(new File("FitxerConfiguracio.properties")));
				String nom = (String) laMevaConfiguracio.get("nomFactoriaEstrategiaDescompte");
				// opció de fer un condicional

				// opció Programació Reflexiva
				Class laClasse = Class.forName(nom);
				Method metodeEstatic = laClasse.getDeclaredMethod("getInstanciaUnica");
				FactoriaAbstracteEstrategiaDescompteVenda factoriaConcreta = (FactoriaAbstracteEstrategiaDescompteVenda) metodeEstatic.invoke(null);
				estrategiaFixarPreuVenda = factoriaConcreta.obtenirEstrategiaDecompte();

			} catch (Exception e) {
				//Si no es pot crear una estratègia concreta, crearem l'estrategia nul·la (sense cap descompte)
			}
		}
		return estrategiaFixarPreuVenda;
	}

	protected abstract IEstrategiaDescompteVenda obtenirEstrategiaDecompte();	
}