package project.lumohacks.psychologyreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GroupsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_page);

        populateListView();
        registerClickCallback();
    }

    private void populateListView() {
        // Create list of items
        String[] clients = {"7", "5", "6", "1"};

        // Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,               //Context for the activity
                R.layout.client_button,    //Layout to use (create)
                clients);                  //Client buttons to be displayed

        // Configure the list view
        ListView list = (ListView) findViewById(R.id.clientsListView);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.clientsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id){
                TextView textView = (TextView) viewClicked;
                String message = "You clicked #" + position
                                 + ", which is string: " + textView.getText().toString();
                Toast.makeText(GroupsPage.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
