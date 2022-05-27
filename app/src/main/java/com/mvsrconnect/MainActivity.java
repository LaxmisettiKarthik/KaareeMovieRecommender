package com.mvsrconnect;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.SortedList;

import com.airbnb.lottie.LottieAnimationView;
import android.app.Dialog;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    EditText movie_name;
    TextView movielist;
    Button recommend;
   // Button Streamlit;
    ProgressDialog progressDialog;

    LottieAnimationView lottie;

   String url = "https://movieme11.herokuapp.com/movie";
    int MY_SOCKET_TIMEOUT_MS=500;
    private SortedList<StringRequest> requestQueue;
    StringRequest stringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie_name = findViewById(R.id.search);
        movielist = findViewById(R.id.movielist);
        recommend = findViewById(R.id.recommendBtn);
        //Streamlit = findViewById(R.id.Streamlitbtn);
        //progressBar=findViewById(R.id.progressBar);


        recommend.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

               Toast.makeText (MainActivity.this , "Request pampav ga Kasepu Agu" , Toast.LENGTH_LONG ).show ( );
                //hit the API ->volley

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("hello");
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
               progressDialog.show();
             final   StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                      // response ->  Toast.makeText(MainActivity.this, response.toString(),Toast.LENGTH_LONG).show();
                       new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {
                                Toast.makeText (MainActivity . this , " Success " , Toast.LENGTH_LONG ).show ( );
                                try {
                                    //JSONObject jsonObject = new JSONObject().getJSONObject(response);
                                    JSONObject jsonObject = new JSONObject(response);
                                 // ProgressDialog.show(MainActivity.this, "dialog title",
                                 //           "dialog message", true);
                                    String data = jsonObject.getString("movies");
                                    movielist.setText(data);
                                    progressDialog.dismiss();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }



                        },
                        new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      
                      Toast.makeText(MainActivity.this,"Server loading error try after 3min",Toast.LENGTH_SHORT).show();

                    }
                }){

                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> Params = new HashMap<>();
                        Params.put("movie_name",movie_name.getText().toString());

                        return Params;
                    }


                };
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);
                stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                        20000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
               // RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);


            }
        });
        //StringRequest stringRequest = new StringRequest {
  /*  Streamlit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    });

      lottie =findViewById(R.id.lottieAnimationView);
     lottie.animate().translationY(3000).setDuration(10000);
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            if(recommend.equals(true))
                lottie.playAnimation();
                //lottie.loop(true);

            }
        },1000);*/


    }


}