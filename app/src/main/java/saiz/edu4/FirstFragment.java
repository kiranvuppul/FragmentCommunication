package saiz.edu4;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.widget.ArrayAdapter.createFromResource;

/**
 * Created by saikiran on 11/2/2015.
 */
public class FirstFragment extends Fragment implements AdapterView.OnItemClickListener {

     ListView l;
    Communicator cm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.first, container, false);
        l= (ListView) v.findViewById( R.id.listView);
        ArrayAdapter arrayAdapter= createFromResource(getActivity(), R.array.colors, android.R.layout.simple_list_item_1);
        l.setAdapter(arrayAdapter);
        l.setOnItemClickListener(this);
        return v;
    }
    public void setCommunicator(Communicator cm){
        this.cm=cm;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    cm.respond(position);
    }



    public interface Communicator{
        public void respond(int index);
    }
}
