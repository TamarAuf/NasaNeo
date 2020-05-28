package aufrichtig.nasa.neo;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;

public class NeoFrame extends JFrame {

    @Inject
    public NeoFrame(NearEarthObjectView view, NeoController controller) {
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEO Today");
        setLayout(new BorderLayout());

        add(view, BorderLayout.CENTER);
        controller.requestData();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new NeoFrameModule());

        NeoFrame frame = injector.getInstance(NeoFrame.class);

        frame.setVisible(true);
    }

}
