package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MembersPage extends AppCompatActivity {
    private String[] members = {"John", "Jane", "Peter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_page);

        initializeMembersList();
        addMembersButton();
    }

    private void addMembersButton() {
        Button loginBtn = (Button) findViewById(R.id.add_members_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MembersPage.this, "TestButton", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeMembersList() {
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
