package com.example.osondutochi.mykiddiesquiz;

public class QuestionLibrary {
    //Let's create an String Array to hold the Questions.
    public String[] questionPull = {
            "What is the 17th letter of the english alphabet? ",
            "The two holes in the nose are called?",
            "_____ is the hottest place in the earth?",
            "What type of angle has 90 degrees?",
            "How many colours has the rainbow",
    };

    public String[][] questionOptions = {
            {"P", "S", "Q", "R"},
            {"Nostrils", "Nosal", "Nose holes", "Nasal holes"},
            {"Nigeria", "Ethiopia", "United Kingdom", "China"},
            {"Trapezium", "Isosceles angle", "Acute angle", "Right angle"},
            {"6", "7", "7.5", "9"},
    };

    public String[] correctAnswers = {
            "Q", "Nostrils", "Ethiopia", "Right angle", "7",
    };

    //Let's get the Questions.
    public String getEachQuestion(int a) {
        String question = questionPull[a];
        return question;
    }

    //Let's get the choice 1
    public String getChoice1(int a) {
        String choice0 = questionOptions[a][0];
        return choice0;
    }

    //Let's get the choice 2
    public String getChoice2(int a) {
        String choice1 = questionOptions[a][1];
        return choice1;
    }

    //Let's get the choice 3
    public String getChoice3(int a) {
        String choice2 = questionOptions[a][2];
        return choice2;
    }

    //Let's get the choice 4
    public String getChoice4(int a) {
        String choice3 = questionOptions[a][3];
        return choice3;
    }

    //Let's get all the correct answers.
    public String getCorrectAnswers(int a) {
        String answers = correctAnswers[a];
        return answers;
    }

}
