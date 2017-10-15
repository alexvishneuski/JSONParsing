package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GSONInvoiceParserImpl implements IInvoiceParser {

    private final String mSource;

    public GSONInvoiceParserImpl(final String pSource) {
        mSource = pSource;
    }

    @Override
    public Invoice parse() throws Exception {


        final Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new DateTimeDeserializer()).create();
        return gson.fromJson(mSource, Invoice.class);
    }

    private class DateTimeDeserializer implements JsonDeserializer<Timestamp> {
        public Timestamp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {

            Timestamp timestamp = null;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date parsedDate = null;
            try {
                parsedDate = dateFormat.parse(json.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            timestamp = new java.sql.Timestamp(parsedDate.getTime());

            return timestamp;


        }
    }

}


