package com.example.dream_house2.ui.favors;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dream_house2.API.FireBaseClient;
import com.example.dream_house2.Modules.Post;
import com.example.dream_house2.Modules.favorites;
import com.example.dream_house2.common.common;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class FavorViewModel extends ViewModel {
    private MutableLiveData<List<favorites>> favoritesMutableLiveData ;
    private List<favorites> favoritesList = new ArrayList<>();
    LiveData<List<favorites>> GetFavoritesMutableLiveData() {
        if (favoritesMutableLiveData==null )favoritesMutableLiveData=new MutableLiveData<>();
        return favoritesMutableLiveData;
    }

    void GetFavors(){
        FireBaseClient.GetInstance().getFirebaseFirestore()
                .collection(common.Favor_DataBase_Table)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            try {
                                favorites favor = document.toObject(favorites.class);
                                if (favor.getPost().getPost_owner().equals(common.Current_Client)){ favoritesList.add(favor);}
                            } catch (Throwable t) {
                                Log.e("GetFavorException", Objects.requireNonNull(t.getMessage()));
                            }
                        }
                        favoritesMutableLiveData.setValue(favoritesList);
                    }
                });
    }


}