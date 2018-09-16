package project.lumohacks.psychologyreport;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import project.lumohacks.psychologyreport.groupInfo.MemberType;
import project.lumohacks.psychologyreport.reportinfo.Question;
import project.lumohacks.psychologyreport.reportinfo.Report;
import project.lumohacks.psychologyreport.reportinfo.ReportTemplate;

public class MembersView extends AppCompatActivity {

    Singleton singleton = Singleton.getInstance();
    String username = singleton.getUserLogin();
    String password = singleton.getUserPassword();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_view);

        addReportsButton();
        setGoToMembersButton();
        populateLineChart();
    }

    private void populateLineChart() {
        LineChart chart = (LineChart) findViewById(R.id.members_chart);


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

    private void setGoToMembersButton(){
        if(singleton.getGroup().getMemberType(username) == MemberType.Associate){
            Button membersBtn = (Button) findViewById(R.id.group_members_button);
            membersBtn.setVisibility(View.GONE);
        } else {
            goToMembersButton();
        }
    }

    private void addReportsButton() {
        Button addReportsBtn = (Button) findViewById(R.id.add_report_button);
        addReportsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = AddReport.makeIntent(MembersView.this);
                startActivity(intent);
            }
        });
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
