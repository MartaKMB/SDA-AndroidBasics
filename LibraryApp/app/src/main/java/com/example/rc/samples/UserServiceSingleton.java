package com.example.rc.samples;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class UserServiceSingleton {

//    obiekt odpowiedzialny za serializacje i deserializacje JSONa

    private Gson gson = new GsonBuilder().create();

//    jedna instancja dla calej aplikacji, wiec
//    jeden obiekt w pamieci
//    klasa dostarczajaca narzedzia

    private static final UserServiceSingleton ourInstance = new UserServiceSingleton();

    public static UserServiceSingleton getInstance() {
        return ourInstance;
    }

    private UserServiceSingleton() {
    }

    public Boolean login(LoginModel loginModel) {

//        logika wyslania credentials na server i przekazanie wynikow spowrotem

        boolean isLogIn = false;

//        wyslanie req postem



        return isLogIn;
    }

    public String  performPostCall(String requestURL, LoginModel model) {

        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);

//            POST wiec wrzucamy dane na serwer

            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

//            stream wejsciowy, wypelnianie body jsonem
//            przygotowanie req

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(gson.toJson(model));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
