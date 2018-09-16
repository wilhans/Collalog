package project.lumohacks.psychologyreport.reportinfo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

     public ReportTemplate reportTemplate;
     public Map<Integer, Integer> answerMap;
     public int dayFromStarting;
     public String additionalComment;


     // constructs a report with questions from the report template
     public Report(ReportTemplate reportTemplate, int dayFromStarting) {
          this.reportTemplate = reportTemplate;
          answerMap = new HashMap<>();
          this.dayFromStarting = dayFromStarting;
          loadQuestionsToReport();

     }

     // loads questions from the template into the HashMap
     private void loadQuestionsToReport() {
          List<Question> listOfQuestions = reportTemplate.getQuestions();
          for (Question question : listOfQuestions) {
               answerMap.put(question.id, 0);
          }
     }

     // adds an answer to a question on the report
     public void answerQuestion(int questionID, int answer) {
          answerMap.put(questionID, answer);
     }


     public String getAdditionalComment() {
          return additionalComment;
     }

     public Map<Integer, Integer> getAnswerMap() {
          return answerMap;
     }

     // prints each question followed by its answer
     public void printQuestionsAndAnswers() {
          List<Question> listOfQuestions = reportTemplate.getQuestions();
          for(Question q : listOfQuestions) {
               System.out.printf(q.id + " " + q.getQuestion());
               System.out.printf(answerMap.get(q.id).toString());
               System.out.println(additionalComment);
          }
     }



}
