package aufrichtig.nasa.neo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NeoServiceFactory {

    public NeoService getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NeoService service = retrofit.create(NeoService.class);
        return service;
    }

}