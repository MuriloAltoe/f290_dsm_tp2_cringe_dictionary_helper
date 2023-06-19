package br.com.muriloaltoe.f290_dsm_tp2_cringe_dictionary_helper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String linkDaApi = "http://localhost:8080/dicionario/";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest requisição = HttpRequest.newBuilder().uri(new URI(linkDaApi)).build();
		HttpResponse<String> response = client.send(requisição, HttpResponse.BodyHandlers.ofString());
		System.out.println("Status da resposta: " + response.statusCode());
		}
}