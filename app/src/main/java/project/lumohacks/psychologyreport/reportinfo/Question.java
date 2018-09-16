package project.lumohacks.psychologyreport.reportinfo;

public class Question {
    public int id;
    public String question;

    // constructs a question with an id and description
    public Question(Integer id, String question ) {
    this.id = id;
    this.question = question;
    }

    public void changeID(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

}
