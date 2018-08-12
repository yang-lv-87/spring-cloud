package com.nosql;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class TestMongodb {

	@Test
	public void test1() {
		MongoClient mongoClient = new MongoClient("192.168.1.111", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		Document document = new Document();
		document.put("key3", "value3");
		document.put("key5", "value5");
		db.getCollection("col4").insertOne(document);
		mongoClient.close();
	}
	
	@Test
	public void test2() {
		MongoClient mongoClient = new MongoClient("192.168.1.111", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		Bson filter = Filters.eq("key3", "value3");
		MongoCursor<Document> iter = db.getCollection("col4").find(filter).iterator();
		while (iter.hasNext()) {
			Document doc = iter.next();
			System.out.println(doc);
		}
		mongoClient.close();
	}
	
	@Test
	public void test3() {
		MongoClient mongoClient = new MongoClient("192.168.1.111", 27017);
		MongoDatabase db = mongoClient.getDatabase("test");
		Bson filter = Filters.eq("key3", "value3");
		Bson filter2 = Filters.eq("key3", "value30");
		Document update = new Document("$set", new Document("key3", "value30"));
		db.getCollection("col4").updateOne(filter, update);
		MongoCursor<Document> iter = db.getCollection("col4").find(filter2).iterator();
		while (iter.hasNext()) {
			Document doc = iter.next();
			System.out.println(doc);
		}
		mongoClient.close();
	}
}
