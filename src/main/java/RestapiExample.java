

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
public class RestapiExample {




	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("eliran");


		String host = "https://jsonplaceholder.typicode.com/posts";
//		String charset = "UTF-8";
//		// Headers for a request
//		String x_rapidapi_host = "movie-database-imdb-alternative.p.rapidapi.com";
//		//    String x_rapidapi_key = <YOUR_RAPIDAPI_KEY>;//Type here your key
//		// Params
//		String s = "Pulp";
//		// Format query for preventing encoding problems
//		String query = String.format("s=%s",
//				URLEncoder.encode(s, charset));


		//GET JSON FORMAT 
		System.out.println("json-format");
		HttpResponse <JsonNode> response1 = Unirest.get(host)

				.asJson();
		System.out.println("status:"+response1.getStatus());
		System.out.println("content-type="+response1.getHeaders().get("Content-Type"));
		System.out.println("-------------------------------");


		//GET String format
		System.out.println("string-format id =1 ");

		HttpResponse <String> response2= Unirest.get(host+"/1")

				.asString();
		System.out.println("body\n"+response2.getBody());
		System.out.println("-------------------------------");
		//  System.out.println(response2.getHeaders().get("Content-Type"));

		//Post
		System.out.println("Post\n");
		HttpResponse <JsonNode> res2 =  Unirest.post(host).field("title", "ELIRAN").field("body", "nothing to add")
				.field("userId", 2).asJson();

		System.out.println("status\n"+res2.getStatus());
		System.out.println("body: "+res2.getBody());
		System.out.println("-------------------------------");


		//Delete

		HttpResponse <String> response3= Unirest.delete(host+"/1").asString();
		System.out.println("body: "+response3.getBody());
		System.out.println("status: "+response3.getStatus());


	}

}
