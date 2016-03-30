package saiz.edu4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements FirstFragment.Communicator {
    FragmentManager fm;
    SecondFragment f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirstFragment frag = new FirstFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.relative, frag, "first");
        transaction.commit();
        frag.setCommunicator(this);
    }

    @Override
    public void respond(int index) {
        f2 = (SecondFragment) fm.findFragmentById(R.id.second);
        f2.change(index);


    }
}