package OOP;

import java.text.SimpleDateFormat;
import java.util.Locale;

// 스마트 미러를 통해 요청받은 정보를 조회해 스마트 미러에게 전달
public class Server {

    private String weather;

    public Server() {
        weather = "맑고 구름 없음";
    }

    // 날씨 정보
    public String get_weather() {
        return weather;
    }

    // 날짜 정보
    public void get_date() {
        long systemTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        String date = formatter.format(systemTime);

        System.out.println("오늘의 날짜는 " + date + " 입니다.");
    }

    // 시간 정보
    public void get_time() {
        long systemTime = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
        String time = formatter.format(systemTime);
        System.out.println("현재 시간은 " + time + " 입니다.");
    }

}
