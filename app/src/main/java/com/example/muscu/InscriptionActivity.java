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
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class InscriptionActivity extends AppCompatActivity {

    private EditText etNom, etPrenom, etIdentifiant, etPassword;
    private Button btnInscription;

    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Récupération des champs
        etNom = findViewById(R.id.editTextNom);
        etPrenom = findViewById(R.id.editTextPrenom);
        etIdentifiant = findViewById(R.id.editTextIdentifiant);
        etPassword = findViewById(R.id.editTextPassword);
        btnInscription = findViewById(R.id.buttonInscription);

        // Initialisation Volley
        rq = Volley.newRequestQueue(this);

        // Action bouton
        btnInscription.setOnClickListener(view -> {
            Toast.makeText(this, "CLICK OK", Toast.LENGTH_SHORT).show();


            String nom = etNom.getText().toString().trim();
            String prenom = etPrenom.getText().toString().trim();
            String identifiant = etIdentifiant.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if(nom.isEmpty() || prenom.isEmpty() || identifiant.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                demandeInscription(nom, prenom, identifiant, password);
            }
        });
    }

    /**
     * Envoi requête inscription
     */
    private void demandeInscription(String nom, String prenom, String identifiant, String password) {

        String url = Config.baseUrl + "/webservice/register";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                this::traiteInscription,
                this::gereErreurs
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("nom", nom);
                params.put("prenom", prenom);
                params.put("identifiant", identifiant);
                params.put("mdp", password);
                params.put("type", "utilisateur");
                return params;
            }
        };

        rq.add(request);
    }

    /**
     * Traitement réponse API
     */
    private void traiteInscription(String response) {
        try {
            JSONObject json = new JSONObject(response);

            if(json.has("token")) {
                String token = json.getString("token");

                // Sauvegarde JWT
                SharedPreferences prefs = getSharedPreferences("app_prefs", MODE_PRIVATE);
                prefs.edit().putString("jwt_token", token).apply();

                Toast.makeText(this, "Inscription réussie + connecté", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Inscription réussie", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Erreur traitement réponse", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Gestion erreurs Volley
     */
    private void gereErreurs(VolleyError error) {

        if(error.networkResponse != null && error.networkResponse.data != null){
            String body = new String(error.networkResponse.data);

            try {
                JSONObject obj = new JSONObject(body);
                Toast.makeText(this, obj.getString("error"), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Erreur serveur", Toast.LENGTH_SHORT).show();
                Log.e("MUSCU", "Erreur réponse: " + body, error);
            }

        } else {
            Toast.makeText(this, "Erreur réseau", Toast.LENGTH_SHORT).show();
            Log.e("MUSCU", "Pas de réponse serveur", error);
        }
    }
}