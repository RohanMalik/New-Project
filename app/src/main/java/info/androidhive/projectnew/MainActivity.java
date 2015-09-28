package info.androidhive.projectnew;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements FragmentA.ListViewSelection {



    android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("New project");

        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.parseColor("#F48FB1"));

        actionBar.setBackgroundDrawable(colorDrawable);


        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentA, new FragmentA()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentB, new FragmentB()).commit();
        }






    }

    public void setActionBarTitle(String title) {

        actionBar.setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeListPosition(String letter) {
        FragmentB contactsFragment = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);

        if (contactsFragment !=null)
        {
            contactsFragment.changePosition(letter);
        }
    }

    @Override
    public void searchContacts(String query) {
        FragmentB contactsFragment = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);

        if (contactsFragment !=null)
        {
           contactsFragment.searchConatctsList(query);
        }
    }


}
