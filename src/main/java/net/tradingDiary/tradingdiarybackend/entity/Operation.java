package net.tradingDiary.tradingdiarybackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "data", nullable = false)
    private String data;
    @Column(name = "time", nullable = false)
    private String time;
    @Column(name = "result", nullable = false)
    private String result;
    @Column(name = "dynamic", nullable = false)
    private String dynamic;
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

    public long getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public String getTime() {
        return this.time;
    }

    public String getResult() {
        return this.result;
    }

    public String getDynamic() {
        return this.dynamic;
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

    public void setDynamic(String dynamic) {
        this.dynamic = dynamic;
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
