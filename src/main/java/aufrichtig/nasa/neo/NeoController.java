package aufrichtig.nasa.neo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * Request data from the NeoService and populate the NearEarthObjectView
 */
public class NeoController {

    private NeoService service;
    private NearEarthObjectView view;

    public NeoController(NeoService service, NearEarthObjectView view) {
        this.service = service;
        this.view = view;
    }

    public void requestData() {
        service.getAsteroids("2020-05-05", "2020-05-05").enqueue(new Callback<NeoFeed>() {
            @Override
            public void onResponse(Call<NeoFeed> call, Response<NeoFeed> response) {
                NeoFeed.NearEarthObject nearEarthObject = response.body().nearEarthObjects.get("2020-05-05").get(0);
                view.setNearEarthObject(nearEarthObject);
            }

            @Override
            public void onFailure(Call<NeoFeed> call, Throwable t) {

            }
        });
    }

}