package com.example.tourisme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chargez le Fragment du Splash Screen au démarrage de l'activité principale
        //loadFragment(new SplashScreenFragment());
    }

    // Méthode pour charger un fragment dans le conteneur
    //private void loadFragment(Fragment fragment) {
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.fragment_container, fragment);
        //fragmentTransaction.commit();
    //}
}