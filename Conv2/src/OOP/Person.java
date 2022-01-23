package OOP;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;

// 스마트 미러를 보유 빛 스마트 미러가 인식하고자 하는 대상
public class Person {

    private String user_name;
    private String gender;
    private int age;
    private String stringAge;
    private ArrayList<String> to_do_list;
    private ScriptObjectMirror arr;

    Database database;   // 구성요소
    Mirror mirror;

    Person(String name) {
        user_name = name;
        stringAge = age + "살";
        database = new Database();
        mirror = new Mirror();

    }
    // 데이터베이스 정보 가져오기
    public ArrayList load_database(){
        return (ArrayList)arr.get(1);
    }

    // 사용자 이름 확인
    public String check_user_name(Mirror mirror) {
        // DB 호출
        user_name = arr.getClassName();
        return user_name;
    }
    // 사용자 성별 확인
    public String check_gender() {
        // DB 호출
        gender = arr.getClassName();
        return gender;
    }
    // 사용자 나이 확인
    public String check_age() {
        // DB 호출
        stringAge =  arr.getClassName();
        return stringAge;
    }
}
