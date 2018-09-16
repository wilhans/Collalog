package project.lumohacks.psychologyreport.reportinfo;

import java.util.ArrayList;
import java.util.List;

public class ReportTemplate {

    public int id;
    public List<Question> questions;

    // creates new report template with no questions
    public ReportTemplate() {
        questions = new ArrayList<>();
    }

    // adds questions to the report in order
    public void addQuestion(String question) {
        int questionID = questions.size() + 1;
        questions.add(new Question(questionID, question));
    }

    //removes question, updates id of remaining questions according to new order
    public void removeQuestion(int questionID) {
        questions.remove(questionID - 1);
        for (int i = questionID - 1; i < questions.size(); i++) {
            questions.get(i).changeID(i +1);
        }
    }
}
