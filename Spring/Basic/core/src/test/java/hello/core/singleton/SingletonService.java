package hello.core.singleton;

public class SingletonService {

    // Java(JVM) 가 뜰 때 -> 바로 SingletonService 의 static 영역에 바로 new 를 통해 자기 자신의 객체를 생성해 -> instance 에 넣어둔다.
    // 자기 자신에 대한 인스턴스 객체를 하나 생성해서 -> 이 인스턴스에만 들어가게 됨
    private static final SingletonService instance = new SingletonService();   // static : 클래스 레벨로 올라가 -> 딱 하나만 존재

    // SingletonService 의 인스턴스를 참조할 수 있는 유일한 방식
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
