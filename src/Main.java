import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.*;




public class Main {
        public static void main(String[] args) throws IOException {

                OkHttpClient client = new OkHttpClient();

                // Сегментированное построение URL
                HttpUrl url = new HttpUrl.Builder()
                        .scheme("http")
                        .host("dataservice.accuweather.com")
                        .addPathSegment("forecasts")
                        .addPathSegment("API_V1.0")
                        .addPathSegment("daily")
                        .addPathSegment("5day")
                        .addPathSegment("474212_PC")
                        .addQueryParameter("apikey", "w8B1ieDggRj3l5sDp9DCnF3G2trgPkv6")
                        .addQueryParameter("language", "ru-ru")
                        .addQueryParameter("metric", "true")
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