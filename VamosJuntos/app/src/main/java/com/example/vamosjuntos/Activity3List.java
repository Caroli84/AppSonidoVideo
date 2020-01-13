package com.example.vamosjuntos;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Activity3List extends AppCompatActivity {


/*

        ListView listView=(ListView)findViewById(R.id.listViewEventos);

        String names[] ={"A","B","C","D"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);



 */

        ListView listViewEventos;
        ArrayList<Evento> arrayList;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_activity3_list);

            listViewEventos = (ListView) findViewById(R.id.listViewEventos);
            arrayList = new ArrayList<>();

            try {
                JSONObject object = new JSONObject(readJSON());
                JSONArray array = object.getJSONArray("eventoS");
                for (int i = 0; i < array.length(); i++) {

                    JSONObject jsonObject = array.getJSONObject(i);
                    String user = jsonObject.getString("user");
                    String fecha = jsonObject.getString("fecha");
                    String lugar = jsonObject.getString("lugar");
                    String info = jsonObject.getString("info");

                    Evento evento = new Evento(user, fecha,  lugar,  info);

                    arrayList.add(evento);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CustomAdapter adapter = new CustomAdapter(this,arrayList);
            listViewEventos.setAdapter(adapter);


        }


        public String readJSON(){
            String json = null;
            try {
                // Opening data.json.json file
                InputStream inputStream = getAssets().open("eventoS.json");
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                // read values in the byte array
                inputStream.read(buffer);
                inputStream.close();
                // convert byte to string
                json = new String(buffer, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
                return json;
            }
            return json;
        }







    }




    /*

    public String readData(String inFile) {
        String sContent = "";
        try {
            InputStream stream = getAssets().open(inFile);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            sContent = new String(buffer);
        } catch (IOException e) {
            Log.e("TAG", "Error al leer el archivo!, " + e.getMessage());
        }
        return sContent;
    }

    public List<Evento> readJsonStream(InputStream in) throws IOException {
        // Nueva instancia JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return leerArrayEventos(reader);
        } finally {
            reader.close();
        }

    }

    public List leerArrayEventos(JsonReader reader) throws IOException {
        // Lista temporal
        ArrayList eventos = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            // Leer objeto
            eventos.add(leerEvento(reader));
        }
        reader.endArray();
        return eventos;
    }


    public Evento leerEvento(JsonReader reader) throws IOException {
        String user = null;
        String fecha = null;
        String lugar = null;
        String info = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "user":
                    user = reader.nextString();
                    break;
                case "fecha":
                    fecha = reader.nextString();
                    break;
                case "lugar":
                    lugar = reader.nextString();
                    break;
                case "info":
                    info = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new Evento(user,fecha,lugar,info);
    }



     */

