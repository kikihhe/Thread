package demo;

import java.time.LocalDate;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-29 20:34
 */
public class Coach extends WorldCup {
    // 国籍
    private String country;
    // 执教年龄
    private int teachAge;
    public Coach() {
    }

    public Coach(String country, int teachAge) {
        this.country = country;
        this.teachAge = teachAge;
    }

    public Coach(String team, String name, String sex, LocalDate birthday, String type, String country, int teachAge) {
        super(team, name, sex, birthday, type);
        this.country = country;
        this.teachAge = teachAge;
    }


    // 业余爱好
    public void sing() {
        System.out.println(getName() + "在唱歌.");
    }
    // 战术安排
    public void arrange() {
        System.out.println(getName() + "开始战术安排");
    }
    // 首发阵容
    public void squads() {
        System.out.println("首发阵容");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTeachAge() {
        return teachAge;
    }

    public void setTeachAge(int teachAge) {
        this.teachAge = teachAge;
    }



    public String toString() {
        return super.toString() + "\t" +
                "国籍: " + getCountry() + "\t" +
                "执教年龄: " + getTeachAge() + "年";
    }

}
