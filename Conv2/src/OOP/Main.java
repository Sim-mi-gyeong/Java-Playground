package OOP;

import java.util.Scanner;

// 프로그램 사용자에게 보여질 화면
public class Main {

    static void menu() {
        System.out.println("***** Smart Mirror System Menu *****");
        System.out.println("***** 0 Menu");
        System.out.println("***** 1 사용자 인식");
        System.out.println("***** 2 사용자 등록");
        System.out.println("***** 3 사용자 정보 입력");  // 여기서 스마트 미러 설정도 할 수 있게
        System.out.println("***** 4 사용자 정보 조회");  // mirror가 DB에서 정보를 가져와 Person에게 알려주기
        System.out.println("***** 5 스마트 정보 조회");
        System.out.println("***** 6 Exit ");
        System.out.println("***** ***** ***** ***** ***** *****");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person person;
        Mirror mirror = new Mirror();
        Server server = new Server();
        Database database = new Database();

        menu();
        int mode = 7;
        while(mode != 6) {
            mode = sc.nextInt();
            switch (mode) {
                case 0:
                    menu();
                    break;

                case 1:
                    System.out.println("  사용자를 인식합니다. ");
                    System.out.println("  이름을 입력하세요.  ");

                    String name = sc.next();
                    person = new Person(name);
//                    person.mirror.check_user(name);
                    if (person.mirror.check_user(name)) {
                        System.out.println("이미 등록된 사용자입니다.");
                        System.out.println("사용자 정보를 확인하세요. ");
                    }
                    else{
                        System.out.println("아직 등록되지 않은 사용자입니다.");
                    }

                    menu();
                    break;

                case 2:
//                  mirror.get_authority()가 true가 될 때까지
                    while(true) {
                        System.out.println("등록할 사용자 이름을 입력하세요.");
                        String inputName = sc.next();
                        // Mirror 클래스의 user_list에 사용자 등록
                        mirror.register_user(inputName);
                        break;
                    }

                    menu();
                    break;

                case 3:
                    System.out.println("사용자 이름을 확인해주세요.");
                    String inputName = sc.next();
                    System.out.print("나이를 입력하세요. : ");
                    int inputAge = sc.nextInt();
                    System.out.print("성별을 입력하세요. : ");
                    String inputGender = sc.next();
                    System.out.print("오늘의 할 일의 개수를 입력하세요. : ");
                    int inputToDoListNum = sc.nextInt();
                    String[] inputToDoList = new String[inputToDoListNum];
                    System.out.println("오늘의 할 일을 입력하세요. ");
                    for(int i = 0; i< inputToDoListNum; i++ ) {
                        inputToDoList[i] = sc.next();
                    }

                    System.out.println("스마트 미러 정보도 변경하시겠습니까?(yes/no)");

                    String answer = sc.next();
                    mirror = new Mirror();

                    if(answer == "yes") {
                        System.out.println("현재 밝기는" + mirror.getLight() + "입니다.");
                        System.out.println("변경할 디스플레이 밝기를 입력하세요.(dark/middle/light) ");
                        String changeLight = sc.next();
                        mirror.setLight(changeLight);

                    }
                    else if(answer == "no") {
                        System.out.println("입력 완료되었습니다. ");

                    }
                    System.out.println("입력 완료되었습니다. ");
                    menu();
                    break;

                case 4:
                    System.out.println("정보를 조회할 사용자를 입력하세요. ");
                    String inputName2 = sc.next();
                    person = new Person(inputName2);

                    if(person.mirror.check_user(inputName2)) {
                        System.out.println("해당 사용자의 이름은 : " + database.load_data(inputName2).get(0) + " 입니다.");
                        System.out.println("해당 사용자의 나이는 : " + database.load_data(inputName2).get(1) + " 5입니다.");
                        System.out.println("해당 사용자의 성별은 : " + database.load_data(inputName2).get(2) + " 입니다.");
                        System.out.println("해당 사용자의 오늘 할 일은 : " + database.load_data(inputName2).get(3) +" 입니다.");
                    }
                    else {
                        System.out.println("해당 사용자의 정보는 존재하지 않습니다. ");
                    }

                    menu();
                    break;

                case 5:
                    System.out.println("현재 거울의 밝기는 " + mirror.getLight() + " 상태입니다.");
                    System.out.println("오늘의 날씨는 " + server.get_weather() + " 상태입니다.");
                    server.get_date();
                    server.get_time();

                    menu();
                    break;

                case 6:
                    System.out.println("디스플레이를 종료하겠습니다.");
                    break;
            }
        }
    }
}
