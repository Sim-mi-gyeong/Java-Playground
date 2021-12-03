package OOP;

import java.util.ArrayList;
import java.util.List;

// 사용자 개인의 정보가 저장된 데이터베이스 -> 사용자 정보는 사용자(Person) 클래스의 구성요소
public class Database {

    Mirror mirror;
    Person person;

    private boolean db_exist;
    private String db_name;
    private String user_name;
    private List<List<String>> arr;

    public Database() {
        db_exist = false;
        db_name = "user_information";  // DB 테이블 이름

        arr = new ArrayList<>();
        int info_num = 4;
        for (int i = 0; i<2; i++) {

            String[] arrRowTempItems = {"migyeong", 22+"살", "여자", "공부하기"};
            List<String> arrRowItems = new ArrayList<>();

            for (int j = 0; j < info_num; j++) {
                arrRowItems.add(arrRowTempItems[j]);
            }
            arr.add(arrRowItems);
        }

    }

//    // 사용자 데이터베이스 이름 입력 받기
//    public String get_database_name() {
//        return db_name;
//    }
//
    // 사용자 데이터베이스 존재 여부 확인
    public boolean get_exist_db(String user_name) {
        if(mirror.check_user(user_name)) {
            db_exist = true;
        }
        else {
            db_exist = false;
        }
        return false;
    }
//
    public void register_data(String inputName, int inputAge, String inputGender, int inputToDoListNum, String... inputToDoList) {
        Main main = new Main();

        int info_num = 4;
        for (int i = 1; i<10; i++) {

            String[] arrRowTempItems = {inputName, inputAge + "살", inputGender,  inputToDoList[0]};
            List<String> arrRowItems = new ArrayList<>();

            for (int j = 0; j < info_num; j++) {
                arrRowItems.add(arrRowTempItems[j]);
            }
            arr.add(arrRowItems);
        }

    }

    // 사용자 이름에 따른 정보 알려주기
    public ArrayList load_data(String user_name) {
        return (ArrayList) arr.get(1);
    }
}
