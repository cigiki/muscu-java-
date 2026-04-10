package com.example.muscu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlanningActivity extends AppCompatActivity {

    private RecyclerView rvPlanning;
    private RequestQueue rq;
    private String token; // Déclaré ici pour être accessible dans getHeaders()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        rvPlanning = findViewById(R.id.rvPlanning);
        rvPlanning.setLayoutManager(new LinearLayoutManager(this));

        rq = Volley.newRequestQueue(this);

        // Récupérer l'user_id et le token sauvegardés après connexion
        SharedPreferences prefs = getSharedPreferences("app_prefs", MODE_PRIVATE);
        int userId = prefs.getInt("user_id", 0);
        token = prefs.getString("jwt_token", null);

        if (userId != 0) {
            // On appelle la méthode qui fait la requête
            demandeplanning(String.valueOf(userId));
        } else {
            Toast.makeText(this, "Utilisateur non trouvé", Toast.LENGTH_SHORT).show();
        }
    }

    private void demandeplanning(String userId) {
        String url = Config.baseUrl + "/service/planning-semaine?user_id=" + userId;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                this::traitePlanning,
                this::gereErrorPlanning) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                // Utilisation du token récupéré dans le onCreate
                if (token != null) {
                    headers.put("Authorization", "Bearer " + token);
                }
                return headers;
            }
        };

        rq.add(stringRequest);
    }

    public void traitePlanning(String reponse) {
        try {
            JSONObject jsonObject = new JSONObject(reponse);
            JSONArray planningArray = jsonObject.getJSONArray("planning");

            ArrayList<PlanningExercice> listeExercices = new ArrayList<>();

            for (int i = 0; i < planningArray.length(); i++) {
                JSONObject item = planningArray.getJSONObject(i);

                // Extraction des données selon ton JSON Postman
                int jour = item.getInt("jour");
                String nom = item.getString("nom_exercice");

                // Création de l'instance et ajout à la liste
                listeExercices.add(new PlanningExercice(jour, nom));
            }

            // MISE À JOUR DE LA LISTE (Une seule fois après la boucle)
            PlanningAdapter adapter = new PlanningAdapter(listeExercices, this);
            rvPlanning.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erreur de lecture des données JSON", Toast.LENGTH_SHORT).show();
        }
    }

    private void gereErrorPlanning(VolleyError error) {
        Toast.makeText(this, "Erreur réseau ou session expirée", Toast.LENGTH_SHORT).show();
    }
}