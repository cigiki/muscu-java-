package com.example.muscu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ConnexionActivity extends AppCompatActivity {

    private EditText etIdentifiant, etPassword;
    private Button btnConnexion;

    /**
     * File d'attente pour les requetes web service
     */
    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        // Récupération des vues
        etIdentifiant = findViewById(R.id.editTextIdentifiant);
        etPassword = findViewById(R.id.editTextPassword);
        btnConnexion = findViewById(R.id.buttonConnexion);

        // Action du bouton
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etIdentifiant.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(ConnexionActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                   demandeConnexion(username, password);
                }
            }
        });

        //j'instancie ma file d'attente
        rq= Volley.newRequestQueue(this);
    }

    private void demandeConnexion(final String username, final String password) {
        String url = Config.baseUrl+"/webservice/login"; // URL de ton API

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                this::traiteConnexion,
                this::gereErreurs) {
            /*
                Dans cette zone , je définis les parametres qui seront passés à ma requete de login
             */
            @Override
            protected Map<String, String> getParams() {
                // Paramètres POST envoyés à l'API
                Map<String, String> params = new HashMap<>();
                params.put("identifiant", username);
                params.put("mdp", password);
                return params;
            }
        };
        // ⚡ Ajout de la requête à la queue Volley
        rq.add(stringRequest);
    }



        public void traiteConnexion(String reponse){
            try {
                JSONObject jsonObject = new JSONObject(reponse);
                String token = jsonObject.getString("token"); // Récupérer le JWT

                // Stocker le JWT dans SharedPreferences
                SharedPreferences prefs = getSharedPreferences("app_prefs", MODE_PRIVATE);
                prefs.edit().putString("jwt_token", token).apply();

                Toast.makeText(ConnexionActivity.this, "Connexion réussie !", Toast.LENGTH_SHORT).show();

                // Ici tu peux rediriger vers ton activité principale
                // startActivity(new Intent(ConnexionActivity.this, MainActivity.class));

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(ConnexionActivity.this, "Erreur lors de la connexion", Toast.LENGTH_SHORT).show();
            }
        }


        public void gereErreurs(VolleyError error) {

            // Afficher le message d'erreur envoyé par ton API
            if(error.networkResponse != null && error.networkResponse.data != null){
                String body = new String(error.networkResponse.data);
                try{
                    JSONObject obj = new JSONObject(body);
                    Toast.makeText(ConnexionActivity.this, obj.getString("error"), Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ConnexionActivity.this, "Erreur réseau avec reponse", Toast.LENGTH_SHORT).show();
                    Log.e("MUSCU","Problème réseau (reponse reçue)",error);
                }
            } else {
                Toast.makeText(ConnexionActivity.this, "Erreur réseau sans reponse", Toast.LENGTH_SHORT).show();
                Log.e("MUSCU","Problème réseau (pas de reponse reçue)",error);
                error.printStackTrace();
            }
        }


    }
