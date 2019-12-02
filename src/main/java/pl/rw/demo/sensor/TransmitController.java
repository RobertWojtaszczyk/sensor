package pl.rw.demo.sensor;

import okhttp3.*;

import java.io.IOException;

public class TransmitController {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    boolean post(String url, String jsonBody) throws IOException {
        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println("response.body().string() = " + response.body().string());
            return response.isSuccessful();
        }
    }
}
