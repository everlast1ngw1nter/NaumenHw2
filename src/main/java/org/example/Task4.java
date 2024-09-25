package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;

public class Task4 {

    public static void executeTask() throws IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient())
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/anything"))
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            var pattern = Pattern.compile("\"Accept\": +\"(.+)\",");
            var matcher = pattern.matcher(response.body());
            var output = "No Accept header";
            if (matcher.find()) {
                output = matcher.group(1);
            }
            System.out.println(output);
        }
    }
}
