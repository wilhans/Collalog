package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import project.lumohacks.psychologyreport.groupInfo.MemberType;

public class LoginPage extends AppCompatActivity {

    Singleton singleton = Singleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginButton();
    }

    private void loginButton() {
        Button loginBtn = (Button) findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEdit = (EditText) findViewById(R.id.username);
                String username = usernameEdit.getText().toString();
                MemberType userType = singleton.getGroup().memberExist(username);
                if(userType != null) {
                    singleton.setUserLogin(username);
                    if(userType == MemberType.HealthProfessional) {
                        Intent intent = GroupsPage.makeIntent(LoginPage.this);
                        startActivity(intent);
                    } else {
                        Intent intent = MembersView.makeIntent(LoginPage.this);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, LoginPage.class);
    }
}
