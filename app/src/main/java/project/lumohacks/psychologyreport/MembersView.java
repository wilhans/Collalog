package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MembersView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_view);

        goToMembersButton();
    }

    private void goToMembersButton() {
        Button membersBtn = (Button) findViewById(R.id.group_members_button);
        membersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MembersPage.makeIntent(MembersView.this);
                startActivity(intent);

            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, MembersView.class);
    }
}
