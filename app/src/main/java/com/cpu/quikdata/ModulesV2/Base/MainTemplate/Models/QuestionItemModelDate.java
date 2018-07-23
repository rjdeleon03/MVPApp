package com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models;

import java.util.Calendar;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class QuestionItemModelDate extends RealmObject implements IQuestionItemModel {

    @Required
    @PrimaryKey
    private String id;
    private String question;
    private int year = Calendar.getInstance().get(Calendar.YEAR);
    private int month = Calendar.getInstance().get(Calendar.MONTH);
    private int dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    public QuestionItemModelDate() {}

    public QuestionItemModelDate(String id, String question) {
        this.id = id;
        this.question = question;
    }

    public QuestionItemModelDate(String id, String question, int year, int month, int dayOfMonth) {
        this.id = id;
        this.question = question;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public QuestionItemModelDate(String question, int year, int month, int dayOfMonth) {
        this.id = id;
        this.question = question;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
