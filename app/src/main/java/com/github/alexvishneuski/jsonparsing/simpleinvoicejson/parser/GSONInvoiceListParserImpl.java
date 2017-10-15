package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;
import com.github.alexvishneuski.jsonparsing.utils.IOUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GSONInvoiceListParserImpl implements IInvoiceListParser {

    private final InputStream mInputStream;

    public GSONInvoiceListParserImpl(InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }

    @Override
    public List<Invoice> parce() throws Exception {
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
        Invoice[] invoicesArr = customGson.fromJson(IOUtils.toString(mInputStream), Invoice[].class);
        List<Invoice> invoices = new ArrayList<>((Arrays.asList(invoicesArr)));
        return invoices;
    }
}
