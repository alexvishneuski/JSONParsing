package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.ContractDetail;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.ContractStatus.valueOf;

public class JSONInvoiceParserImpl implements IInvoiceParser {

    private static final String INVOICE_NUMBER = "invoiceNumber";

    private static final String COMMON_INFO = "commonInfo";
    //private static final String CONTRACT_ID = "contractId";
    private static final String CREATED = "created";
    private static final String CONTRACT_STATUS = "contractStatus";
    private static final String TOTAL_AMOUNT = "totalAmount";
    private static final String CUSTOMER_COMPANY_NAME = "customerCompanyName";

    private static final String DETAILS = "details";
    private static final String ITEM_NAME = "itemName";
    private static final String ITEM_VARIANT_PRICE = "itemVariantPrice";

    private final String mSource;

    public JSONInvoiceParserImpl(final String pSource) {
        mSource = pSource;
    }

    @Override
    public Invoice parse() throws Exception {

        Invoice invoice = new Invoice();

        final JSONObject jsonInvoice = new JSONObject(mSource);

        //obtaining of invoice number
        invoice.setInvoiceNumber(jsonInvoice.optInt(INVOICE_NUMBER));

        //obtaining contract common info
        //obtaining of invoice number
        //invoice.getCommonInfo().setContractId(jsonInvoice.optJSONObject(COMMON_INFO).optInt(CONTRACT_ID));
        //obtaining of created
        invoice.getCommonInfo().setCreated(convertFromJSONToTimestamp(jsonInvoice.optJSONObject(COMMON_INFO).optString(CREATED)));
        //obtaining of contract status
        invoice.getCommonInfo().setContractStatus(valueOf(jsonInvoice.optJSONObject(COMMON_INFO).optString(CONTRACT_STATUS).toUpperCase()));
        //obtaining totalAmount
        invoice.getCommonInfo().setTotalAmount(new BigDecimal(jsonInvoice.optJSONObject(COMMON_INFO).optInt(TOTAL_AMOUNT)));
        //obtaining customerCompanyName
        invoice.getCommonInfo().setCustomerCompanyName(jsonInvoice.optJSONObject(COMMON_INFO).optString(CUSTOMER_COMPANY_NAME));

        //obtaining array of contract details
        List<ContractDetail> contractDetails = new ArrayList<>();

        JSONArray jsonDetailsArray = jsonInvoice.optJSONArray(DETAILS);
        ContractDetail contractDetail = null;
        if (jsonDetailsArray != null) for (int i = 0; i < jsonDetailsArray.length(); i++) {
            JSONObject jsonDetail = jsonDetailsArray.optJSONObject(i);
            contractDetail.setItemName(jsonDetail.optString(ITEM_NAME));
            contractDetail.setItemVariantPrice(new BigDecimal(jsonDetail.optInt(ITEM_VARIANT_PRICE)));
            contractDetails.add(contractDetail);
        }
        invoice.setDetails(contractDetails);
        return invoice;
    }


    @Override
    public List<Invoice> parce() throws Exception {
        return null;
    }

    private Timestamp convertFromJSONToTimestamp(String date) throws Exception {
        Timestamp timestamp;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate = dateFormat.parse(date);
        timestamp = new java.sql.Timestamp(parsedDate.getTime());

        return timestamp;

    }


}




