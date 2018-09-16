package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MembersPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_page);

        initializeMembersList();
    }

    private void initializeMembersList() {
        String[] members = {"John", "Jane", "Peter"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.members_list,
                members
        );
        ListView list = (ListView) findViewById(R.id.members_list_view);
        list.setAdapter(adapter);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MembersPage.class);
    }
}
