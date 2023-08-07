package com.app.madatourisme;

import com.app.madatourisme.ui.login.AuthResponse;
import com.app.madatourisme.ui.login.LoginRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    static void getListItems(ListItemsCallback listItemsCallback) {
    }

    @POST("/inscription")
    Call<Void> registerUser(@Body Utilisateur utilisateur);

    @POST("/login")

    Call<AuthResponse> loginUser(@Body LoginRequest loginRequest);


    public interface ListItemsCallback {
        void onSuccess(List<String> items);

        void onFailure(String errorMessage);
    }
}
