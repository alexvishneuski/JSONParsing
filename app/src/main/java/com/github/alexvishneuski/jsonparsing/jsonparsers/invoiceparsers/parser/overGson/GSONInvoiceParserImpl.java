package com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.overGson;

import com.github.alexvishneuski.jsonparsing.model.customentities.Invoice;
import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.IInvoiceParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GSONInvoiceParserImpl implements IInvoiceParser {

    private final String mSource;

    public GSONInvoiceParserImpl(final String pSource) {
        mSource = pSource;
    }

    @Override
    public Invoice parse() throws Exception {

        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Timestamp> deserializer = new JsonDeserializer<Timestamp>() {
            @Override
            public Timestamp deserialize(JsonElement json, Type typeOfT,
                                         JsonDeserializationContext context) throws JsonParseException {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
                Date parsedDate = null;
                if (json == null) return null;
                try {
                    parsedDate = dateFormat.parse(json.getAsString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

                return timestamp;

            }
        };
        gsonBuilder.registerTypeAdapter(Timestamp.class, deserializer);
        Gson customGson = gsonBuilder.create();
        Invoice invoice = customGson.fromJson(mSource, Invoice.class);
        return invoice;
    }
}




