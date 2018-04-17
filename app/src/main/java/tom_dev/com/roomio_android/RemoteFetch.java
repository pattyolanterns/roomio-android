package tom_dev.com.roomio_android;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RemoteFetch {
    private final String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric";

    public JSONObject getJSON(Context context, String city){
        try {
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.addRequestProperty("x-api-key", context.getString(R.string.open_weather_maps_app_id));

            JSONObject obj = streamToJSON(connection.getInputStream());


        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject streamToJSON(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not successful
            if(data.getInt("cod") != 200){
                return null;
            }
            return data;

        } catch  (Exception e){
            return null;
        }
    }

    public ArrayList<Transaction> getTransactions(String roomID, String meID, String mateID) {

        ArrayList<Transaction> trans = new ArrayList<Transaction>();

        return trans;
    }

    public ArrayList<Mate> getMates(String meID, String roomID) {
        ArrayList<Mate> mates = new ArrayList<Mate>();

        return mates;
    }

    public ArrayList<Room> getRooms(String meID) {
        ArrayList<Room> rooms = new ArrayList<Room>();

        return rooms;
    }

    public double getBalance(String roomID, String meID, String mateID) {
        double balance = 5.0;

        return balance;
    }

    public double getBalance(String roomID, String meID) {
        double balance = 5.0;

        return balance;
    }

    public Mate getMe(String meID) {
        Mate me = new Mate();

        return me;
    }
}
