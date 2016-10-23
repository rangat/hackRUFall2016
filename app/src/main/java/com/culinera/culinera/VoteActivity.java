package com.culinera.culinera;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

        BillInfo callBill = new BillInfo(
                "June 29 2016 ",
                "Senate",
                "A bill to amend the Communications Act of 1934 to ensure the integrity of voice communications and to prevent unjust or unreasonable discrimination among areas of the United States in the delivery of such communications."
        );
        BillInfo clinicBill = new BillInfo(
                "September 21, 2016 ",
                "House of Representatives",
                "To amend the Public Health Service Act to foster more effective implementation and coordination of clinical care for people with pre-diabetes, diabetes, and the chronic diseases and conditions that result from diabetes."
        );
        BillInfo maternityBill = new BillInfo(
                "September 21, 2016 ",
                "House of Representatives",
                "To amend the Public Health Service Act to provide for the designation of maternity care health professional shortage areas."
        );
        BillInfo researchBill = new BillInfo(
                "February 9, 2016 ",
                "Senate",
                "A bill to amend the Public Health Service Act to provide for systematic data collection and analysis and epidemiological research regarding Multiple Sclerosis (MS), Parkinson's disease, and other neurological diseases."
        );
        BillInfo mentalBill = new BillInfo(
                "March 16, 2016 ",
                "Senate",
                "A bill to amend the Public Health Service Act to provide comprehensive mental health reform, and for other purposes."
        );
        BillInfo openBill = new BillInfo(
                "May 25, 2016 ",
                "Senate",
                "A bill to expand the Government's use and administration of data to facilitate transparency, effective governance, and innovation, and for other purposes."
        );
        BillInfo driverBill = new BillInfo(
                "March 25, 2015 ",
                "Senate",
                "A bill to limit the retrieval of data from vehicle event data recorders, and for other purposes."
        );

        setContentView(R.layout.activity_vote);

        ArrayList<BillInfo>  list = new ArrayList<BillInfo>();
        list.add(callBill); list.add(clinicBill); list.add(maternityBill); list.add(researchBill); list.add(mentalBill); list.add(openBill); list.add(driverBill);

        BillAdapter m = new BillAdapter(list);
        RecyclerView recList = (RecyclerView)findViewById(R.id.vote_list);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setAdapter(m);



        LoadJSonTask task = new LoadJSonTask();
        task.execute("Execute");

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
