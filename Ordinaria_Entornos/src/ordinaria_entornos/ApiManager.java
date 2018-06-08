import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiManager​ {

	public double averiguaCambio(String divisaOrigen, String divisaDestino) {

		String json = "";

		String url = "http://free.currencyconverterapi.com/api/v5/convert?q=" + divisaOrigen + "_" + divisaDestino
				+ "&compact=y";

		json = MiClienteREST.request(url);

		try {
			JSONObject json2 = new JSONObject(json);
			JSONObject json3 = json2.getJSONObject(divisaOrigen + "_" + divisaDestino);

			Double d = json3.getDouble("val");

			return d;

		} catch (JSONException e) {
			return 0;
		}

	}

}
