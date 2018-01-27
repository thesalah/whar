package com.zigzag.riverx;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import java.util.HashMap;
/**
 * Created by salah on 24/1/18.
 */

public class ViewModelFactory implements ViewModelProvider.Factory {

    @SuppressLint("StaticFieldLeak")
    private static ViewModelFactory INSTANCE;

    private final Context applicationContext;

    public ViewModelFactory(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ViewModelFactory(context.getApplicationContext());
        }
        return INSTANCE;
    }

    HashMap<Class<? extends RiveRxViewModel>, RiveRxViewModel> viewModelHashMap = new HashMap<>();

    public void registerViewModel(Class<? extends RiveRxViewModel> modelClass, RiveRxViewModel viewModel){
        if(!viewModelHashMap.containsKey(modelClass)){
            viewModelHashMap.put(modelClass,viewModel);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        for (HashMap.Entry<Class<? extends RiveRxViewModel>, RiveRxViewModel> entry : viewModelHashMap.entrySet()) {
            Class<? extends RiveRxViewModel> key = entry.getKey();
            if (modelClass.isAssignableFrom(key)) {
                return (T) entry.getValue();
            }
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}