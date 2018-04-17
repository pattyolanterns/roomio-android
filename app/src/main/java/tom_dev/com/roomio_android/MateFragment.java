package tom_dev.com.roomio_android;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MateFragment extends Fragment {


    public MateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String meKey = getArguments().getString("me-id");
        String mateKet = getArguments().getString("mate-id");
        return inflater.inflate(R.layout.fragment_mate, container, false);
    }

}
