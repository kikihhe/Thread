package demo;

import java.time.LocalDate;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-29 20:31
 */
public class WorldCup {
    public WorldCup() {
    }

    public WorldCup(String team, String name, String sex, int birthday, String type) {
        this.team = team;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.type = type;
    }

    // 队伍
    private String team; // 中国 阿根廷 法国
    // 姓名
    private String name; //
    // 性别
    private String sex;
    // 出生年份
    private int birthday; // LocalDate.of(2002, 1, 1)
    // 类型
    private String type; // new WorldCup("足球运动员"/ "教练")

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "队伍:" + getTeam() + "\t" +
                "姓名:" + getName() + "\t" +
                "性别:" + getSex() + "\t" +
                "出生年份: " + getBirthday() + "\t" +
                "类型: " + getType() + "\t";

    }
}
