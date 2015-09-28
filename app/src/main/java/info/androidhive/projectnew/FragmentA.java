package info.androidhive.projectnew;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;

/**
 * Created by rohanmalik on 24/09/15.
 */
public class FragmentA extends Fragment {


    public ActionBar actionBar;

    ListViewSelection mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentA = inflater.inflate(R.layout.fragment_a, container, false);

        ButtonAdapter adapter = new ButtonAdapter(getActivity());
        GridView gridView = (GridView) fragmentA.findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        Log.i("gridView", "adapter");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Button button = (Button) view.findViewById(R.id.buttonA);
                String buttonText = button.getText().toString();

                ((MainActivity) getActivity()).setActionBarTitle("Alphabet : " + buttonText);
                mCallback.changeListPosition(buttonText);

            }
        });


        SearchView searchView = (SearchView) fragmentA.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
             //   Toast.makeText(getActivity(), query, Toast.LENGTH_SHORT).show();

                mCallback.searchContacts(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

            //    Toast.makeText(getActivity(), newText, Toast.LENGTH_SHORT).show();
                mCallback.searchContacts(newText);
                return false;
            }
        });

        return fragmentA;
    }

    public interface ListViewSelection
    {
        public void changeListPosition(String letter);

        public void searchContacts(String query);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (ListViewSelection) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ListViewSelection");
        }
    }


}



