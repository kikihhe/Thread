package demo;

import java.time.LocalDate;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-29 20:38
 */
public class FootballPlayer extends WorldCup {
    // 身高
    private double high;
    // 号码
    private int number;
    // 射门
    public void shoot() {
        System.out.println(getName() + "射门了!");
    }
    //铲球
    public void slide() {
        System.out.println(getName() + "铲球成功夺走了球权!!");
    }

    public FootballPlayer(double high, int number) {
        this.high = high;
        this.number = number;
    }

    public FootballPlayer(String team, String name, String sex, LocalDate birthday, String type, double high, int number) {
        super(team, name, sex, birthday, type);
        this.high = high;
        this.number = number;
    }

    public String toString() {
        return super.toString() + "\t" +
                "身高: " + getHigh() + "cm\t" +
                "号码: " + getNumber();
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
