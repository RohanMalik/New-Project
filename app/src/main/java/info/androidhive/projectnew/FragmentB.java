package info.androidhive.projectnew;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by galaxy on 24/09/15.
 */
public class FragmentB extends Fragment
{
  //  ListView listView;

    ArrayList<String> contact_ids;
    String query ="";

    ListView listView;
    int count = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View contactsView = inflater.inflate(R.layout.fragment_b, container, false);
        contact_ids = getIds(query);


        createListView(contactsView);


 /*              ArrayList<String> list = new ArrayList<String>();
                list.add("");
                list.add("");
                list.add("");
                ContactsAdapter adapter = new ContactsAdapter(getActivity(),list);
        listView = (ListView) contactsView.findViewById(R.id.contactlist);
               listView.setAdapter(adapter);
        return contactsView;     */


        return contactsView;
    }

    public void createListView(View contactsView)

    {



      /*  for (int i = 0; i<contact_ids.size() ; i++ )
        {
            Log.i("ID ","id "+contact_ids.get(i));
        }  */

        ContactsAdapter adapter = new ContactsAdapter(getActivity(),contact_ids);
         listView = (ListView) contactsView.findViewById(R.id.contactlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView phNumber = (TextView) view.findViewById(R.id.phonenumber);
                String data = "tel:" + phNumber.getText().toString();

                if (!phNumber.getText().toString().equals("")) {
                    Log.i("Number", data);

                    //                String dummy = "tel:9694979945";
                    Uri uri = Uri.parse(data);

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "No Contact Number Found", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public void changePosition(String letter)
    {

        String letterLower = letter.toLowerCase();
        count = 0;

        ContentResolver contentResolver = getActivity().getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY+" COLLATE NOCASE");

        if (cursor.getCount() > 0)
        {
            while (cursor.moveToNext())
            {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
                Log.i("name",name);
                if (name.startsWith(letter) || name.startsWith(letterLower))
                {
                    Log.i("name","match");
                    break;
                }
                else
                {
                    count++;
                    Log.i("Count",""+count);
                }
            }
        }
        if (count == contact_ids.size())
        {
            Toast.makeText(getActivity(),"No Contacts ",Toast.LENGTH_SHORT).show();
            listView.setSelection(0);
        }
        else {
            listView.smoothScrollToPosition(count);
        }
    }

    public void searchConatctsList(String query)
    {
        contact_ids = getIds(query);


        if (contact_ids.size() > 0){

            ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(),contact_ids);
            listView.setAdapter(contactsAdapter);
        }
    }
    public ArrayList<String> getIds(String query){
        String str = " ";

        ArrayList<String> idList  = new ArrayList<String>();

        ContentResolver contentResolver = getActivity().getContentResolver();
       Cursor cursor = null;
        String selection = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY+" LIKE ?";





        if (query.equals("")) {

            cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " COLLATE NOCASE");

        }
        else {

            String selectionArgs[] = { "%"+query+"%" };
            cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, selection, selectionArgs, ContactsContract.Contacts.DISPLAY_NAME_PRIMARY+" COLLATE NOCASE");

        }


        if (cursor.getCount()>0) {
          //  Log.i("Cursor Count", "" + cursor.getCount());

            idList.clear();

            while(cursor.moveToNext()) {


                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

                idList.add(id);
            }
        }

        else {
            Toast.makeText(getActivity(), "No Contacts Matching " + query, Toast.LENGTH_SHORT).show();
        }
        return idList;
    }


    }

