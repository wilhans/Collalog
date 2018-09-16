package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import project.lumohacks.psychologyreport.reportinfo.Question;
import project.lumohacks.psychologyreport.reportinfo.Report;
import project.lumohacks.psychologyreport.reportinfo.ReportTemplate;

public class PsychiatristView extends AppCompatActivity {

    Singleton singleton = Singleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychiatrist_view);

        populateListView();
        addListCallback();
        goToMembersButton();
        populateLineChart();
    }

    private void populateLineChart() {
        LineChart chart = (LineChart) findViewById(R.id.psych_chart);


        ReportTemplate template = new ReportTemplate(singleton.getGroup(), true);
        template.addQuestion("test", 3);
        Report report = new Report(template, 0);
        List<Entry> entries = new ArrayList<Entry>();

        //Q1 - Q4 need to be separated
        for(Question current_question : report.getReportTemplate().getQuestions()){
            entries.add(new Entry(report.getDayFromStarting(),current_question.getRate()));
        }

        //Havent separate the Q1 - Q4 yet
        LineDataSet set = new LineDataSet(entries, "Q1");
        set.setColor(Color.BLUE);
        LineData lineData = new LineData(set);
        chart.setData(lineData);
        chart.invalidate();
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
