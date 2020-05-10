package aufrichtig.nasa.neo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;

public class NeoFrame extends JFrame {

    public NeoFrame() {
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEO Today");
        setLayout(new BorderLayout());

        NearEarthObjectView view = new NearEarthObjectView();
        add(view, BorderLayout.CENTER);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NeoService service = retrofit.create(NeoService.class);

        NeoController controller = new NeoController(service, view);
        controller.requestData();
    }

    public static void main(String[] args) {
        new NeoFrame().setVisible(true);
    }

}
