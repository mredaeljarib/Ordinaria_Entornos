import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.*;

public class MiClienteREST {
	
	public static String request(String dirURL) {

		try {

			// Creamos una URL y una conexi�n a URL
			URL url = new URL(dirURL);
			URLConnection urlConn = url.openConnection();

			// Creamos un InputStreamReader & BufferedReader para leer la respuesta
			InputStreamReader isr = new InputStreamReader(urlConn.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// Mientras el buffer no est� vacio, leemos chars y almacenamos en String
			String txt = "";
			int c;
			while ((c = br.read()) != -1) {
				txt = txt + (char) c;
			}

			// Cerramos el BufferedReader y el InputStreamReader
			br.close();
			isr.close();

			// Devolvemos la respuesta
			return txt;

		} catch (Exception e) {

			// Mostramos informaci�n de la excepci�n
			// System.out.println("Se ha producido una excepci�n inesperada:");
			/* e.printStackTrace(); */

			// Devolvemos null
			return "{\"nada_nada\":{\"val\":0}}";
		}
	}

}
