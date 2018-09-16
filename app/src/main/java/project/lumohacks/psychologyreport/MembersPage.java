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
import android.widget.TextView;
import android.widget.Toast;

import project.lumohacks.psychologyreport.groupInfo.Group;

public class MembersPage extends AppCompatActivity {

    Singleton singleton = Singleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_page);

        initializeMembersList();
        addMembersButton();
        addListCallback();
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
        String[] members = singleton.getGroup().getGroupMember();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.members_list,
                members
        );
        ListView list = (ListView) findViewById(R.id.members_list_view);
        list.setAdapter(adapter);
    }

    private void addListCallback() {
        ListView list = (ListView) findViewById(R.id.members_list_view);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                Group group = singleton.getGroup();

                String memberClicked = textView.getText().toString();
                group.removeMember(memberClicked);
                initializeMembersList();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MembersPage.class);
    }
}
