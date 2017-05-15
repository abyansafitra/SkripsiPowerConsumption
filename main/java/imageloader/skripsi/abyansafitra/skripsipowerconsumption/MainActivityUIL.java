package imageloader.skripsi.abyansafitra.skripsipowerconsumption;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivityUIL extends AppCompatActivity {

    String URL = "http://harisuddin.com/website/byan/api/customer/postingan";

    AdapterImageUIL adapter;
    ArrayList listData2;
    ArrayList finalData;
    private EndlessRecyclerViewScrollListener scrollListener;
    Handler handler;
    RecyclerView recyclerView;
    JSONArray result;
    ProgressDialog pd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uil);

        this.handler = new Handler();
        pd = new ProgressDialog(MainActivityUIL.this);
        pd.setMessage("Loading data...");
        pd.show();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Can't connect to server","");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseData = response.body().string();
                MainActivityUIL.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            result = new JSONArray(responseData);
                            Log.d("result", result+"");
                            ArrayList listData = new ArrayList<>();

                            for(int i=0;i<result.length();i++) {
                                JSONObject data = result.getJSONObject(i);

                                ModelFoto modelData = new ModelFoto();

                                modelData.setUser(data.getString("nama_user"));
                                modelData.setFoto_profil(data.getString("foto_profil"));
                                modelData.setFoto(data.getString("foto"));

                                modelData.setLokasi(data.getString("lokasi_user"));
                                modelData.setLike(data.getString("like"));
                                modelData.setStatus(data.getString("status_user"));

                                listData.add(modelData);
                            }
                            finalData = listData;
                            listData2 = listData;



                        }catch (JSONException e){

                        }
                    }
                });

            }
        });
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    initViews();
                                    new CountDownTimer(900000, 1000) {
                                        int count = 0;
                                        public void onTick(long millisUntilFinished) {
                                            recyclerView.smoothScrollToPosition(count++);
                                        }

                                        public void onFinish() {
                                            Toast.makeText(MainActivityUIL.this, "Pengujian Selesai..", Toast.LENGTH_LONG).show();
                                        }

                                    }.start();
                                    pd.dismiss();


                                }
                            },2000
        );

    }



    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdapterImageUIL(getApplicationContext(),finalData);
        recyclerView.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) { //scroll auto
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list

                Log.d("load",""+ page + " " +totalItemsCount);
                final int positionStart = finalData.size();

                finalData.addAll(listData2);

                adapter.notifyDataSetChanged();
            }
        };
        recyclerView.addOnScrollListener(scrollListener);

    }

}
