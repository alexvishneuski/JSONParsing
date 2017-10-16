package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.overJson;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.factory.InvoiceParserFactory;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.customentities.Invoice;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.IInvoiceListParser;
import com.github.alexvishneuski.jsonparsing.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONInvoiceListParserImpl implements IInvoiceListParser {

    private final InputStream mInputStream;

    public JSONInvoiceListParserImpl(InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }

    @Override
    public List<Invoice> parce() throws Exception {

        JSONArray jsonArray = new JSONArray(IOUtils.toString(mInputStream));
        List<Invoice> invoices = new ArrayList<>();
        Invoice invoice;

        for (int n = 0; n < jsonArray.length(); n++) {
            JSONObject invoiceJSON = jsonArray.getJSONObject(n);
            invoice = new InvoiceParserFactory().createJsonParser(invoiceJSON.toString()).parse();
            invoices.add(invoice);

        }

        return invoices;
    }

}
