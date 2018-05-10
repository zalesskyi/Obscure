package com.zalesskyi.android.obscure.interactors;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zalesskyi.android.obscure.ObscureApi;

import java.io.UnsupportedEncodingException;


abstract class BaseInteractor {
    protected ObscureApi api;


    protected String encode(String gson) {
        Log.d("RETy", "BaseInteractor encode() gson " + gson);
        try {
            byte[] enc = gson.getBytes("UTF-8");
            String b64 = Base64.encodeToString(enc, Base64.URL_SAFE);
            b64 = b64.replace("\n", "");
            b64 = b64.replaceAll("\t", "");
            b64 = b64.replace("\r", "");
            return b64;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.d("RETy", "BaseInteractor encode() UnsupportedEncodingException " + e.getMessage());
        }
        return null;
    }


    protected String decode(String gson) {
        Log.d("RETy", "BaseInteractor decode() gson " + gson);
        byte[] data = Base64.decode(gson, Base64.URL_SAFE);
        try {
            return new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.d("RETy", "BaseInteractor decode() UnsupportedEncodingException " + e.getMessage());
        }
        return null;
    }

    protected String toJson(Object obj) throws NullPointerException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String mgson = gson.toJson(obj);
        return mgson;
    }
}


