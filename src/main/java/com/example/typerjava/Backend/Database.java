package com.example.typerjava.Backend;

import com.mongodb.*;
import org.bson.*;

import com.mongodb.client.*;
import org.bson.conversions.Bson;

public class Database {
    private static final String url = "mongodb+srv://admin:Mosqnjd-1@typercluster.c75mpyd.mongodb.net/";

    public void connect() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(url))
                .serverApi(serverApi)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("admin");
            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                Document commandResult = database.runCommand(command);
                System.out.println("Successfully connected");
            } catch (MongoException me) {
                System.err.println(me);
            }
        }
    }

    public void InstertDoc(/*ouble wpm, int wordCount*/) {
        System.out.println("test");
    }
}
