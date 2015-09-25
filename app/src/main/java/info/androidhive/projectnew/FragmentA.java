package info.androidhive.projectnew;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by rohanmalik on 24/09/15.
 */
public class FragmentA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentA = inflater.inflate(R.layout.fragment_a,container, false);

        ButtonAdapter adapter = new ButtonAdapter(getActivity());
        GridView gridView = (GridView) fragmentA.findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        return fragmentA;
    }
}
