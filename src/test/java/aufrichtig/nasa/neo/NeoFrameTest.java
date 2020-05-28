package aufrichtig.nasa.neo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NeoFrameTest {

    @Test
    public void requestData() {
        // given
        NearEarthObjectView view = new NearEarthObjectView();
        NeoController controller = mock(NeoController.class);

        // when
        NeoFrame frame = new NeoFrame(view, controller);

        // then
        verify(controller).requestData();
    }

}