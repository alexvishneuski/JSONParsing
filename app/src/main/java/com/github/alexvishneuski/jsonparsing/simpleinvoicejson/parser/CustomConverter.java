package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

public class CustomConverter //implements JsonDeserializer<Invoice>
{
/*
    public Custom deserialize(JsonElement json, Type type,
                              JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();

        Timestamp timestamp = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(object.getAsJsonObject("commonInfo").getAsString("created"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timestamp = new java.sql.Timestamp(parsedDate.getTime());

        return timestamp;



        Date date = new Date(object.get("date").getAsLong());



        BigInteger integer = new BigInteger(object.get("integer").getAsString());
        return new Custom(date, integer);
    }


        public Invoice deserialize(JsonElement json, Type type,
                                  JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = json.getAsJsonObject();
            Timestamp timestamp = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            timestamp = new java.sql.Timestamp(dateFormat.parce().getTime());

            Date parsedDate = dateFormat.parse(date);
            Timestamp timestamp = new Timestamp(object.get("date").getAsLong());
            BigInteger integer = new BigInteger(object.get("integer").getAsString());
            return new Invoice(date, integer);
        }
    }
    */
}





