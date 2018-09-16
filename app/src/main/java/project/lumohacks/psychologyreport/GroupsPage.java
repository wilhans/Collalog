package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GroupsPage extends AppCompatActivity {

    Singleton singleton = Singleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_page);

        populateListView();
        accessPsychiatristView();
    }

    private void populateListView() {
        // Create list of items
        String[] clients = new String[1];
        clients[0] = singleton.getGroup().getClientName();

        // Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,               //Context for the activity
                R.layout.client_button,    //Layout to use (create)
                clients);                  //Client buttons to be displayed

        // Configure the list view
        ListView list = (ListView) findViewById(R.id.clientsListView);
        list.setAdapter(adapter);
    }

    private void accessPsychiatristView() {
        ListView list = (ListView) findViewById(R.id.clientsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = PsychiatristView.makeIntent(GroupsPage.this);
                startActivity(intent);
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, GroupsPage.class);
    }
}
