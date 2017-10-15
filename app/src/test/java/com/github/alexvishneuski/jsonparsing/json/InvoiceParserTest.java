package com.github.alexvishneuski.jsonparsing.json;

import android.util.Log;

import com.github.alexvishneuski.jsonparsing.BuildConfig;
import com.github.alexvishneuski.jsonparsing.http.IHttpClient;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    public void parseObjectOverJson() throws Exception {
        Log.d(TAG, "Method parseObjectOverJson is started");
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
        Log.d(TAG, "Method parseObjectOverJson is finished");
    }

    @Test
    public void parseArrayOverJson() throws Exception {
        Log.d(TAG, "Method parseArrayOverJson is started");

        //prepared response with jsonArray
        InputStream mockedInputStream = Mocks.stream("invoice/invoice_json_array.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getInvoiceList");

        //parsed response over JSONA

        final List<Invoice> invoiceList = invoiceListParserFactory.createJsonListParser(response).parce();

        assertTrue(invoiceList.size() == 3);
        assertEquals(29, invoiceList.get(0).getInvoiceNumber().intValue());
        assertNotNull(invoiceList.get(1));
        Log.d(TAG, "Method parseArrayOverJson is finished");
    }

    @Test
    public void parseJbjectOverGson() throws Exception {
        Log.d(TAG, "Method parseJbjectOverGson is started");
        //prepared response with jsonObject
        InputStream mockedInputStream = Mocks.stream("invoice/invoice_json_object_2.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackEnd/getInvoice?id=29");

        //parsed response over GSON
        final Invoice invoice = invoiceParserFactory.createGsonParser(IOUtils.toString(response)).parse();
        assertEquals(29, invoice.getInvoiceNumber().intValue());

        assertEquals("06-05-2017 01:43:35", invoice.getCommonInfo().convertFromTimestamp2String(invoice.getCommonInfo().getCreated()));
        assertEquals("EXECUTED", invoice.getCommonInfo().getContractStatus().toString().toUpperCase());
        assertEquals(250, invoice.getCommonInfo().getTotalAmount().intValue());
        assertEquals("Britsko", invoice.getCommonInfo().getCustomerCompanyName());
        assertEquals(4, invoice.getDetails().size());
        assertEquals("Modified Item: 80", invoice.getDetails().get(0).getItemName());
        assertEquals(10, invoice.getDetails().get(0).getItemVariantPrice().intValue());

        Log.d(TAG, "Method parseJbjectOverGson is finished");
    }

    @Test
    public void parseArrayOverGson() throws Exception {
        Log.d(TAG, "Method parseArrayOverGson is started");

        //prepared response with jsonArray
        InputStream mockedInputStream = Mocks.stream("invoice/invoice_json_array.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getInvoiceList");

        //parsed response over GSON

        final List<Invoice> invoiceList = invoiceListParserFactory.createGsonListParser(response).parce();

        assertTrue(invoiceList.size() == 3);
        assertEquals(29, invoiceList.get(0).getInvoiceNumber().intValue());
        assertNotNull(invoiceList.get(1));
        Log.d(TAG, "Method parseArrayOverGson is finished");
    }
}
