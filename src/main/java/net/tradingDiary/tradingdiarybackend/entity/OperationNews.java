package net.tradingDiary.tradingdiarybackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "operationsNews")

public class OperationNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "data", nullable = false)
    private String data;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "result", nullable = false)
    private String result;
    @Column(name = "news", nullable = false)
    private List<String> news;
    @Column(name = "target_points")
    private double targetPoints;
    @Column(name = "stop_points")
    private double stopPoints;
    @Column(name = "risk_return", nullable = false)
    private double riskReturn;
    @Column(name = "comments")
    private String comments;
    @Column(name = "image")
    private String image;

    public String getData() {
        return this.data;
    }

    public String getTime() {
        return this.time;
    }

    public String getResult() {
        return this.result;
    }

    public String getNews() {
        return this.news.toString();
    }

    public double getTargetPoints() {
        return this.targetPoints;
    }

    public double getStopPoints() {
        return this.stopPoints;
    }

    public double getRiskReturn() {
        return this.riskReturn;
    }

    public String getComments() {
        return this.comments;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNews(List<String> news) {
        this.news = news;
    }

    public void setTargetPoints(double targetPoints) {
        this.targetPoints = targetPoints;
    }

    public void setStopPoints(double stopPoints) {
        this.stopPoints = stopPoints;
    }

    public void setRiskReturn(double riskReturn) {
        this.riskReturn = riskReturn;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
