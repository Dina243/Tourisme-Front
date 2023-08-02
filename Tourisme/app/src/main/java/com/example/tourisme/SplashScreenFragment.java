package com.example.tourisme;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SplashScreenFragment extends Fragment {

    private static final long SPLASH_DELAY = 2000; // Durée d'affichage du splash screen (en millisecondes)

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        TextView animatedTextView = view.findViewById(R.id.animated_textview);

        // Animer TextView
        ObjectAnimator animator = ObjectAnimator.ofFloat(animatedTextView, "translationY", 1000f, 0f);
        animator.setDuration(1000);
        animator.start();

        // Charger l'animation depuis XML
        Animation animation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up);
        animatedTextView.startAnimation(animation);

        // Rendre TextView visible quand l'animation commence
        animatedTextView.setVisibility(View.VISIBLE);

        return view;

        //return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(() -> {
            // Après le délai, naviguez vers l'écran principal ou vers un autre fragment
            // Utilisez la méthode 'replace' ou 'add' pour afficher un nouveau fragment
            // Exemple : ((MainActivity) requireActivity()).replaceFragment(new MainFragment());
        }, SPLASH_DELAY);
    }
}


