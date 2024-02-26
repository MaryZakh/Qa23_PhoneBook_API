package okhttp;

import com.google.gson.Gson;
import dto.DeleteByIDResponseDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class DeleteContactByIDOkhttp {

    String id;

    @BeforeMethod
    public void preCondition() {
        //create contact
        //get id from "message": "Contact was added! ID: 4165465-4fhfgh4-3254
        //id=""
    }

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibWFyYUBnbWFpbC5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTcwOTU3MDg1MywiaWF0IjoxNzA4OTcwODUzfQ.ubMWdSsOhLqZoZJfhL773FmBaEnGXwWi-EJ4NjKj7DM";
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();


    @Test
    public void deleteContactByIDSuccess() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/" + id)
                .delete()
                .addHeader("Authorization", token)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(response.code(), 200);
        DeleteByIDResponseDTO dto = gson.fromJson(response.body().string(), DeleteByIDResponseDTO.class);
        Assert.assertEquals(dto.getMessage(), "Contact was deleted!");
        System.out.println(dto.getMessage());

    }
}
