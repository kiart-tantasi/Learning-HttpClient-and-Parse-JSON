package com.example.learninghttprequest;

import com.example.learninghttprequest.jackson.Article;
import com.example.learninghttprequest.jackson.ArticleJsonAnySetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class SendRequestController {

//    @GetMapping("sendrequest")
//    public String sendRequest() throws IOException {
//        BufferedReader reader;
//        String line;
//        StringBuffer response = new StringBuffer();
//        String requestResponse = "Something went wrong";
//        try {
//            URL url = new URL("https://petch.blog/api/articles/petchdotblog-admin-system");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            // Request Setup
//            connection.setRequestMethod("GET");
//            connection.setConnectTimeout(5000);
//            connection.setReadTimeout(5000);
//            int status = connection.getResponseCode();
//            if (status != 200) { // ERROR
//                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//
//            } else { // 200
//                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            }
//            // read response
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//            requestResponse = response.toString();
//        } catch(Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return requestResponse;
//    }

    @GetMapping("sendrequestasync")
    public ArticleJsonAnySetter sendRequestAsync() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://petch.blog/api/articles/petchdotblog-admin-system")).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString = httpResponse.body().toString();
        ArticleJsonAnySetter result = new ObjectMapper()
                .readerFor(ArticleJsonAnySetter.class)
                .readValue(jsonString);

        return result;
    }

    @GetMapping("article")
    public Article getArticle() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://petch.blog/api/articles/petchdotblog-admin-system")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body().toString();
        Article article = new ObjectMapper()
                .readerFor(Article.class)
                .readValue(jsonString);

        return article;
    }

    @GetMapping("article2")
    public Article getArticle2() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://petch.blog/api/articles/petchdotblog-admin-system")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // parse JSON
        ObjectMapper mapper = new ObjectMapper();
        Article article = mapper.readValue(response.body(), new TypeReference<Article>() {});

        return article;
    }

}
