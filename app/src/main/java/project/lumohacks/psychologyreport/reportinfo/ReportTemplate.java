package project.lumohacks.psychologyreport.reportinfo;

import java.util.ArrayList;
import java.util.List;
import project.lumohacks.psychologyreport.groupInfo.Group;

public class ReportTemplate {
    public int id;
    public List<Question> questions;
    public boolean allowsAdditionalComment = true;

    // creates new report template with no questions, id is same as associated group's id
    // specifies if additional comment is allowed
    public ReportTemplate(Group associatedGroup, boolean allowsAdditionalComment) {
        this.allowsAdditionalComment = allowsAdditionalComment;
        questions = new ArrayList<>();
        id = associatedGroup.getGroupID();
    }

    // adds questions to the report in order
    public void addQuestion(String question) {
        int questionID = questions.size() + 1;
        questions.add(new Question(questionID, question));
    }

    // removes question, updates id of remaining questions according to new order
    public void removeQuestion(int questionID) {
        questions.remove(questionID - 1);
        for (int i = questionID - 1; i < questions.size(); i++) {
            questions.get(i).changeID(i +1);
        }
    }


    // returns the list of questions
    public List<Question> getQuestions() {
        return questions;
    }

}
