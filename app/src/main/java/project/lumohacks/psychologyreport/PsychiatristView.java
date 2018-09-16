package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PsychiatristView extends AppCompatActivity {

    Singleton singleton = Singleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychiatrist_view);

        populateListView();
        addListCallback();
        goToMembersButton();
    }

    private void populateListView() {
        // Create list of items
        String[] clients = singleton.getGroup().getGroupMember();

        // Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,               //Context for the activity
                R.layout.members_list,    //Layout to use (create)
                clients);                  //Client buttons to be displayed

        // Configure the list view
        ListView list = (ListView) findViewById(R.id.reports_list_view);
        list.setAdapter(adapter);
    }

    private void addListCallback() {
        ListView list = (ListView) findViewById(R.id.reports_list_view);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void goToMembersButton() {
        Button membersBtn = (Button) findViewById(R.id.members_button);
        membersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MembersPage.makeIntent(PsychiatristView.this);
                startActivity(intent);
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, PsychiatristView.class);
    }
}
