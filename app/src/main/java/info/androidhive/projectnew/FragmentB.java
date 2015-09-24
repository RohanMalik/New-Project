package info.androidhive.projectnew;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rohanmalik on 24/09/15.
 */
public class FragmentB extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentB = inflater.inflate(R.layout.fragment_b, container, false);
        return fragmentB;
    }
}
