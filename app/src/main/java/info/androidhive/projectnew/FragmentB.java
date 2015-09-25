package info.androidhive.projectnew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by galaxy on 24/09/15.
 */
public class FragmentB extends Fragment
{
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View  contactsView =inflater.inflate(R.layout.fragment_b, container, false);



                ArrayList<String> list = new ArrayList<String>();
                list.add("");
                list.add("");
                list.add("");
                ContactsAdapter adapter = new ContactsAdapter(getActivity(),list);
        listView = (ListView) contactsView.findViewById(R.id.contactlist);
               listView.setAdapter(adapter);
        return contactsView;
    }
}