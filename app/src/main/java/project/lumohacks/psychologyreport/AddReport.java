package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_report);

        checkSeekbarListener();
        addSubmitButton();
    }

    private void addSubmitButton() {
        Button button = (Button) findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void checkSeekbarListener() {
        final SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        final SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        final SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        final SeekBar seekBar4 = (SeekBar) findViewById(R.id.seekBar4);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView progress1 = (TextView) findViewById(R.id.progress_1);
                progress1.setText(progress + "/" + seekBar1.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView progress2 = (TextView) findViewById(R.id.progress_2);
                progress2.setText(progress + "/" + seekBar2.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView progress3 = (TextView) findViewById(R.id.progress_3);
                progress3.setText(progress + "/" + seekBar3.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView progress4 = (TextView) findViewById(R.id.progress_4);
                progress4.setText(progress + "/" + seekBar4.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    public static Intent makeIntent(Context context) {
        return new Intent(context, AddReport.class);
    }
}
