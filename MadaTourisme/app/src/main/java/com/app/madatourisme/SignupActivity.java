package com.app.madatourisme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Etablissement de requête POST vers le point d'API d'inscription
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.app.madatourisme.ApiService;

public class SignupActivity extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText mail;
    private EditText mdp;
    private EditText role;
    private Button buttonSubmit;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        mail = findViewById(R.id.mail);
        mdp = findViewById(R.id.mdp);
        role = findViewById(R.id.role);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonSubmit.setOnClickListener(v -> {
            String name = nom.getText().toString();
            String firstname = prenom.getText().toString();
            String email = mail.getText().toString();
            String password = mdp.getText().toString();
            String function = role.getText().toString();

            // Vérifiez si les champs nom, email et mot de passe ne sont pas vides.
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(firstname) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(function)) {
                Toast.makeText(SignupActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(SignupActivity.this, "Inscription réussie!", Toast.LENGTH_SHORT).show();
        });
    }

    private void registerUser(String name, String firstname, String email, String password, String function) {
        Utilisateur utilisateur = new Utilisateur(name, firstname, email, password, function);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://androidm1p10-manoa-dina.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Void> call = apiService.registerUser(utilisateur);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SignupActivity.this, "Inscription réussie!", Toast.LENGTH_SHORT).show();
                    // Redirigez l'utilisateur vers l'écran de connexion (ou une autre activité) après une inscription réussie.
                    // Par exemple, vous pouvez utiliser Intent pour cela.
                } else {
                    Toast.makeText(SignupActivity.this, "Erreur lors de l'inscription. Veuillez réessayer.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Erreur lors de la communication avec le serveur.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}