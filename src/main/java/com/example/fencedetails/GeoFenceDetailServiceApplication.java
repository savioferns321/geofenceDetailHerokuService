package com.example.fencedetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeoFenceDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoFenceDetailServiceApplication.class, args);

		/*MongoClient client = null;
		try {

			List<MongoCredential> credentials = new ArrayList<>();
			credentials.add(MongoCredential.createScramSha1Credential("savioferns321", "savio_mongo", 
					new char[] {'m','l','a','b','1','2','3'}));
			ServerAddress address = new ServerAddress("ds041633.mlab.com:41633");
			client = new MongoClient(address, credentials);
			MongoDatabase database = client.getDatabase("admin");
			MongoIterable<String> collections = database.listCollectionNames();
			for (String string : collections) {
				System.out.println(string);
			}

		} finally {
			if(client != null)
				client.close();
		}*/

		/*MongoClient client = new MongoClient(Arrays.asList(new ServerAddress("ds041633.mlab.com"), new ServerAddress("ds041633.mlab.com:41633")),
				Collections.singletonList(MongoCredential.createCredential("savioferns321",
						"admin",
						"mlab123".toCharArray())),
				MongoClientOptions.builder().serverSelectionTimeout(1000).build());


		try {
			client.getDB("admin").command("ping");
		} catch (MongoTimeoutException e) {
			// do something
		}*/
		
		/*try {
		    MongoClientURI mongoClientURI = new MongoClientURI("mongodb://savioferns321:mongodb123@ds041633.mlab.com:41633/savio_mongo");
		    MongoClient mongoClient = new MongoClient(mongoClientURI);
		    MongoDatabase database = mongoClient.getDatabase("savio_mongo");
		    System.out.println(database.getCollection("addresses").count());
		}
		catch(Exception e) {
		    // TODO: some proper exception handling
		    System.err.println(e.getLocalizedMessage());
		}
*/

	}
}
