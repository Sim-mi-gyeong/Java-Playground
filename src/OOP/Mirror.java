package OOP;

import java.util.ArrayList;

// 사용 개인에게 화면 제시를 통해 다양한 정보 제공 -> 사용자 소유로, Person 클래스의 구성요소
// 사용자 인식을 통해 개인 식별 및 데이터베이스에 식별한 사용자 정보 요청(메세지 패싱)해 화면에 제시(표현)
// 개인 정보 외의 다양한 정보를 제공하기 위해 서버에 데이터 요청(메세지 패싱)
public class Mirror {

    private ArrayList<String> user_list;   // Mirror에 등록된 사용자 이름 리스트
    private boolean authority;
    private String display_light;
    private String power;   // 딱히 power는 안 해도 될 듯?

    public Mirror() {
        user_list = new ArrayList<>(10);   // 우선 사용자 10명 정도로 설정
        user_list.add("migyeong");
        authority= false;
        display_light = "middle";
        power = "ON";
    }
//    public String getColor() {
//        return display_color;
//    }
//    // 거울 디스플레이 색상 설정 - 밝게/보통/어둡게
//    public void setColor(String display_color) {
//        this.display_color = display_color;
//    }

    // 사용자 등록 확인
    public boolean check_user(String user_name) {
        if(user_list.contains(user_name)) {
            authority= true;
//            System.out.println("이미 등록된 사용자입니다.");
        }
        else {
            authority= false;
//            System.out.println("아직 등록되지 않은 사용자입니다.");
        }
        return authority;
    }

    // 사용자 정보 확인 권한 상태
    public boolean get_authority() {
        return authority;
    }

    // 사용자 등록하기
    public void register_user(String user_name) {
        if(user_list.contains(user_name)) {
            System.out.println("이미 등록된 사용자입니다. 다시 입력하세요.");
            authority = false;
        }
        else {
            user_list.add(user_name);
            authority= true;
            System.out.println("사용자 등록이 완료되었습니다. ");
        }

    }

    // 거울 디스플레이 밝기
    public String getLight() {
        return display_light;
    }

    // 거울 디스플레이 밝기 설정 - 밝게/보통/어둡게(lighter / middle / darker)
    public void setLight(String display_light) {
        this.display_light = display_light;
    }

    // 거울 디스플레이 활성화 상태 확인
    public String getPower() {
        return power;
    }

    // 거울 디스플레이 활성화 상태 변경(ON / OFF) -> 종료
    public void setPower(String power) {
        this.power = power;
    }

}

