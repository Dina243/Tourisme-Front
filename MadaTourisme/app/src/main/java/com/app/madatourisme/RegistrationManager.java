package com.app.madatourisme;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationManager {
    private static final String BASE_URL = "https://androidm1p10-manoa-dina.onrender.com/";

    public void registerUser(Utilisateur utilisateur) {
        // instance de Retrofit avec l'URL de base
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Utilisation de cette instance Retrofit pour créer ApiService
        ApiService apiService = retrofit.create(ApiService.class);

        // Appel de la méthode registerUser() de l'ApiService pour enregistrer l'utilisateur
        Call<Void> call = apiService.registerUser(utilisateur);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // L'inscription a réussi
                    System.out.println("Inscription réussie !");
                } else {
                    // L'inscription a échoué
                    System.out.println("Erreur lors de l'inscription : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Une erreur de réseau s'est produite
                System.out.println("Erreur de réseau : " + t.getMessage());
            }
        });
    }
}
