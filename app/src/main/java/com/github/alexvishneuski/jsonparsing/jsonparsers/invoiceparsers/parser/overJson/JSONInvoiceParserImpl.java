package com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.overJson;

import com.github.alexvishneuski.jsonparsing.model.customentities.ContractCommonInfo;
import com.github.alexvishneuski.jsonparsing.model.customentities.ContractDetail;
import com.github.alexvishneuski.jsonparsing.model.customentities.Invoice;
import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.IInvoiceParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.github.alexvishneuski.jsonparsing.model.datamodel.ContractStatus.valueOf;

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
        ContractCommonInfo info = new ContractCommonInfo();
        //obtaining of invoice number
        //invoice.getCommonInfo().setContractId(jsonInvoice.optJSONObject(COMMON_INFO).optInt(CONTRACT_ID));
        //obtaining of created
        info.setCreated(convertFromJSONToTimestamp(jsonInvoice.optJSONObject(COMMON_INFO).optString(CREATED)));
        //obtaining of contract status
        info.setContractStatus(valueOf(jsonInvoice.optJSONObject(COMMON_INFO).optString(CONTRACT_STATUS).toUpperCase()));
        //obtaining totalAmount
        info.setTotalAmount(new BigDecimal(jsonInvoice.optJSONObject(COMMON_INFO).optInt(TOTAL_AMOUNT)));
        //obtaining customerCompanyName
        info.setCustomerCompanyName(jsonInvoice.optJSONObject(COMMON_INFO).optString(CUSTOMER_COMPANY_NAME));

        invoice.setCommonInfo(info);

        //obtaining array of contract details
        List<ContractDetail> contractDetails = new ArrayList<>();

        JSONArray jsonDetailsArray = jsonInvoice.optJSONArray(DETAILS);
        ContractDetail contractDetail = new ContractDetail();
        if (jsonDetailsArray != null) for (int i = 0; i < jsonDetailsArray.length(); i++) {
            JSONObject jsonDetail = jsonDetailsArray.optJSONObject(i);
            contractDetail.setItemName(jsonDetail.optString(ITEM_NAME));
            contractDetail.setItemVariantPrice(new BigDecimal(jsonDetail.optInt(ITEM_VARIANT_PRICE)));
            contractDetails.add(contractDetail);
        }
        invoice.setDetails(contractDetails);
        return invoice;
    }


    private Timestamp convertFromJSONToTimestamp(String date) throws Exception {
        Timestamp timestamp;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        Date parsedDate = dateFormat.parse(date);
        timestamp = new java.sql.Timestamp(parsedDate.getTime());

        return timestamp;

    }


}




