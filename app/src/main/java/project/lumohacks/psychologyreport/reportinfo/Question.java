package project.lumohacks.psychologyreport.reportinfo;

public class Question {
    private int id;
    private String question;
    private int rate;

    // constructs a question with an id and description
    public Question(String question, int rate ) {
        id++;
        this.rate = rate;
        this.question = question;
    }

    public void changeID(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public int getRate() { return rate; }

}
