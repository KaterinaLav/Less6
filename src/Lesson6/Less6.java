package Lesson6;


import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Less6 {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.accuweather.com/")
                .build();

        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("accuweather.com") // mytestservice.com
                .addPathSegment("v2") // v2
                .addPathSegment("daily") // companies
                .addPathSegment("5") // 2
                .build();

        System.out.println(url.toString());

        // При необходимости указать заголовки
        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);
    }

}