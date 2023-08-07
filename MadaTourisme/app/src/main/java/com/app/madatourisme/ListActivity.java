package com.app.madatourisme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerViewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);

        // Appel à l'API pour récupérer la liste des éléments
        fetchListItemsFromApi();

    }

    private void fetchListItemsFromApi() {
        ApiService.getListItems(new ApiService.ListItemsCallback() {
            @Override
            public void onSuccess(List<String> items) {
                // Mettre à jour l'adaptateur avec les données récupérées
                updateAdapterWithData(items);
            }

            @Override
            public void onFailure(String errorMessage) {
                // Gérer l'erreur en cas d'échec de l'appel à l'API
                Toast.makeText(ListActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateAdapterWithData(List<String> dataList) {
        // Mettez à jour l'adaptateur avec les données récupérées de l'API
        listAdapter.setData(dataList);
        listAdapter.notifyDataSetChanged();
    }
}