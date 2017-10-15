package com.github.alexvishneuski.jsonparsing.json;

import com.github.alexvishneuski.jsonparsing.BuildConfig;
import com.github.alexvishneuski.jsonparsing.http.IHttpClient;
import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.IInvoice;
import com.github.alexvishneuski.jsonparsing.json.model.IUsersList;
import com.github.alexvishneuski.jsonparsing.mocks.Mocks;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.factory.InvoiceListParserFactory;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.factory.InvoiceParserFactory;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;
import com.github.alexvishneuski.jsonparsing.utils.Constants;
import com.github.alexvishneuski.jsonparsing.utils.IOUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class InvoiceParserTest {
    private static final String TAG = InvoiceParserTest.class.getSimpleName();

    private static final String SOURCE = "{\n" +
            "  \"id\" : 1,\n" +
            "  \"name\" : \"First Name and Last Name\",\n" +
            "  \"avatar\" : \"http://placehold.it/32x32\"\n" +
            "}";

    private static final int EXPECTED_ID = 1;
    private static final String EXPECTED_NAME = "First Name and Last Name";
    private static final String EXPECTED_AVATAR = "http://placehold.it/32x32";
    //classMember initialization
    private IHttpClient mHttpClient;

    private InvoiceParserFactory invoiceParserFactory;
    private InvoiceListParserFactory invoiceListParserFactory;

    @Before
    //interfaceMocking
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
        invoiceParserFactory = new InvoiceParserFactory();
        invoiceListParserFactory = new InvoiceListParserFactory();
    }

    @Test
    public void parseOverJsonObject() throws Exception {
        //prepared response with jsonObject
        InputStream mockedInputStream = Mocks.stream("invoice/invoice_json_object.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackEnd/getInvoice?id=29");

        //parsed response over JSONObject
        final Invoice invoice = invoiceParserFactory.createJsonParser(IOUtils.toString(response)).parse();
        assertEquals(29, invoice.getInvoiceNumber().intValue());
        assertEquals("06-05-2017 01:43:35", invoice.getCommonInfo().convertFromTimestamp2String(invoice.getCommonInfo().getCreated()));
        assertEquals("EXECUTED", invoice.getCommonInfo().getContractStatus().toString().toUpperCase());
        assertEquals(250, invoice.getCommonInfo().getTotalAmount().intValue());
        assertEquals("Britsko", invoice.getCommonInfo().getCustomerCompanyName());
        assertEquals(4, invoice.getDetails().size());
        assertEquals("Modified Item: 80", invoice.getDetails().get(0).getItemName());
        assertEquals(10, invoice.getDetails().get(0).getItemVariantPrice().intValue());
    }

    @Test
    public void parseOverJsonArray() throws Exception {
        //prepared response with jsonArray
        InputStream mockedInputStream = Mocks.stream("user/homework_json_array_preparing.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getInvoiceList");

        //parsed response over JSONArray

        final List<Invoice> invoiceList = invoiceListParserFactory.createJsonListParser(response).parce();
        /*

        assertTrue(userList.getUsersList().size() == 3);
        assertTrue(userList.getUsersList().get(0).getId() == 99);
        assertEquals(userList.getUsersList().get(0).getName(), "Aliaksandr Vishneuski");
        */
    }


}
