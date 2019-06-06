package com.example.hw6;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetworkConnection {

    final static String TAG = "NETWORK CONNECTION";

    public static String getData(String url){
        try{
            return getData(new URL(url));
        }catch(MalformedURLException e){
            Log.d(TAG, "Malformed URL");
        }
        return null;
    }

    public static String getData(String url, String... uriParams){
        Uri.Builder builder = Uri.parse(url).buildUpon();

        if((uriParams.length % 2) != 0){
            Log.d(TAG, "Odd number of params provided");
            return null;
        }

        for(int i = 0; i < uriParams.length; i+=2){
            builder.appendQueryParameter(uriParams[i], uriParams[i + 1]);
        }

        return getData(builder.build().toString());
    }


    public static String getData(URL url){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String results = "";

        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null ){
                builder.append(line);
            }

            results = builder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(urlConnection != null){
                urlConnection.disconnect();
            }
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        return results;
    }

}
