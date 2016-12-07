package comsorrgriflastquestwiki.github.lastquestwiki;

/**
 * Created by Reishin on 2016-11-20.
 */

public class FaqItem {
    //Getter and setter for the faq fragment

    private String question;
    private String answer;

    public FaqItem(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question) {

        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {

        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
