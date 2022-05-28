# 시스템의 사용과 제작을 분리 

소프트웨어 시스템은 ( 어플리케이션인 객체로 저장하고 의존성을 ‘연결’하는)준비과정과 (준비사항 이후에 이미지) 런타임 로직을 분리

- 제작

```java

enum DREAM {
    DEVELOPER,
    CEO,
    CTO
}

class DreamFactory {
    
    public static void getDream(DREAM dream){
        switch (dream){
            case CEO -> new CEO();
            case CTO -> new CTO();
            case DEVELOPER -> new DEVELOPER();
        }
    }
}

```

- 사용

```java

class Human {
    public static void main(String[] args) {
        CTO cto = DreamFactory.getDream(DREAM.CTO);
        
        cto.makeDecision();
    }
}

```

### Main 분리 - 시스템 제작과 시스템 사용을 분리하라.Permalink

- 시스템 생성과 사용을 분리하는 한가지 방법
- 생성과 관련된 코드는 모두 Main이나 Main이 호출하는 모듈로 옮기고, 나머지 시스템은 모든 객체가 생성되었고, 모든 의존성이 연결되었다고 가정한다.

![Clean Code](https://github.com/keepinmindsh/tech-education/blob/main/assets/cleancode_01.png)

```java

public class MainTest{
  public void Main(args[] args){
    Implementer impl = new Instance.getInstanceObject(); // 구축자 
    
    Start start = new Starter(impl); // Application

    start.execute(); 
  }
} 

```

# 팩토리의 필요성

# 의존성의 주입 (Injection)

# 확장 

# 테스트 주도 시스템 아키텍처 구축 

# 의사결정을 최적화 하라 

# 시스템은 도메인 특화 언어가 필요하다. 

# 그래서 클린코드는 