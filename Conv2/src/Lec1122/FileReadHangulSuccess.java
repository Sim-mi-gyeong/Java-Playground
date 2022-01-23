package Lec1122;
// 예제 8-2 InputStreamReader로 한글 텍스트 파일 읽기

// FileInputStream: 바이트 단위로 처리 -> InputStream: 바이트 단위의 자료 처리
// FileReader: 문자 단위로 처리 -> Reader: 문자열 단위의 자료 처리

// FileInputStream 은 InputStream을 상속받아 구현
// FileReader는 InputStreamReader -> Reaer 클래스로부터 구현

// 윈도우의 문자표(MS949) < -- > Mac의 문자표(UTF-8)

import java.io.*;

public class FileReadHangulSuccess {
    public static void main(String[] args) {
        InputStreamReader in = null;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("src/Lec1122/vector_비율.txt");
            in = new InputStreamReader(fin, "UTF-8");   // MS949 = CP959
            int c;

            System.out.println("인코딩 문자의 집합은 " + in.getEncoding());

            while((c = fin.read()) != -1){
                System.out.print((char)c);
            }
            in.close();
            fin.close();
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("입출력 오류");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
