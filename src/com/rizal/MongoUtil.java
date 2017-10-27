package com.rizal;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rizal.collection.Barang;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.net.UnknownHostException;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoUtil {
    public final String host = "mongodb://localhost:27017";
    public final String dbName = "ennol";


    public void connect() throws UnknownHostException{
        MongoClientURI mongoClientURI = new MongoClientURI(host);
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);;

        MongoCollection<Barang> collection = mongoDatabase.getCollection("barang", Barang.class);
//        Barang ada = new Barang();
//        ada.setHarga(Double.valueOf(19000));
//        ada.setNama("Sabun Wings");
//        ada.setQty(Integer.valueOf(76));
//        collection.insertOne(ada);
//        Barang barang = collection.find().first();
//        System.out.println(barang);
//        List<Barang> barangs = asList(
//                new Barang("Silet", Double.valueOf(9700), Integer.valueOf(41)),
//                new Barang("Sepatu", Double.valueOf(9900), Integer.valueOf(45)),
//                new Barang("Buku", Double.valueOf(5600), Integer.valueOf(78)),
//                new Barang("Sikat", Double.valueOf(9000), Integer.valueOf(90))
//
//        );
//        collection.insertMany(barangs);
        System.out.println("total # of barang : " + collection.count());
        System.out.println("");
        // lets get all the documents in the collection and print them out
        Block<Barang> printBlock = new Block<Barang>() {
            @Override
            public void apply(final Barang barang) {
                System.out.println(barang);
            }
        };

        collection.find().forEach(printBlock);

        System.out.println("");
        mongoClient.close();




    }
}
