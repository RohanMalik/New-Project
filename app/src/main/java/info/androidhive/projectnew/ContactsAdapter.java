package info.androidhive.projectnew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rohanmalik on 24/09/15.
 */
public class ContactsAdapter extends ArrayAdapter<String>
{

    private final Context context;
    ArrayList<String> nList;

    public ContactsAdapter(Context context, ArrayList<String> nList)
    {

        super(context, R.layout.contacts_view, nList);
        this.context = context;
        this.nList=nList;


    }

    public class ViewHolder {
        TextView description;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        final ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = inflater.inflate(R.layout.contacts_view, parent, false);
            holder = new ViewHolder();
            holder.description = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {

                holder = (ViewHolder) view.getTag();
            }

        holder.description.setText("abc");
        return view;

    }
}
