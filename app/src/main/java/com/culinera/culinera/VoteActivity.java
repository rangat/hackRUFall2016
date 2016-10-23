package com.culinera.culinera;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class VoteActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        LoadJSonTask task = new LoadJSonTask();
        task.execute();

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private class LoadJSonTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params){
            try{
                JSONObject object = readJsonFromUrl("https://congress.api.sunlightfoundation.com/upcoming_bills?apikey=4e700942b55a4240ae8a8ad398e8f309");
                JSONArray array = object.getJSONArray("results");
                String[] resultingArray = array.join(",").split(",");
                String stuff = resultingArray[6];
                Log.i("Test", stuff);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result){

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}
