package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PsychiatristView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychiatrist_view);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, PsychiatristView.class);
    }
}
