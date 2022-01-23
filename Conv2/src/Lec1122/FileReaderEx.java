package Lec1122;
// 예제 8-1 FileReader로 텍스트 파일 읽기
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) {
        FileReader fin = null;

        try {
//            fin = new FileReader("src/Lec1122/vector_비율.txt");
            // /Users/simmigyeong/Documents/GitHub/JavaLecture/src/Lec1122/vector_비율.txt
            fin = new FileReader("/Users/simmigyeong/Documents/GitHub/JavaLecture/src/Lec1122/vector_비율.txt");
            int c;
            while ((c = fin.read()) != -1) {   // 한 문자씩 파일 끝까지 읽기
                System.out.print((char)c);
            }


            fin.close();

        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
