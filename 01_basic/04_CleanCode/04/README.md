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

### Main 분리 - 시스템 제작과 시스템 사용을 분리하라.

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

- 때로는 객체가 생성되는 시점을 애플리케이션이 결정할 필요로 생긴다.
  - IOC ( Inversion Of Control ) : 제어의 역전

![Clean Code For Factory](https://github.com/keepinmindsh/tech-education/blob/main/assets/cleancode_02.png)

```java

public class Application{
    public static void main(String[] args){
    
      Meterial lineItemProduct = LineItemFactory.makeLineItem("AMaterial");
    
      OrderProcess order = new OrderProcess();
    
      order.setLineItem(lineItemProduct);
    
      order.execute();
    }
}


public class LineItemFactory{
    public static Meterial makeLineItem(String type){
        switch(type){
            case "AMaterial" : 
              return new AMeterial();
            case "BMaterial" : 
              return new BMeterial();
        }
    }
}

class OrderProcess{
    private Meterial lineItem;
    
    public void setLineItem(Meterial lineItem){
      this.lineItem = lineItem;
    }
    
    public void execute(){
      LineItem lineItem = LineItem.getProduct();
    }
}
```

# 의존성의 주입 (Injection)


- 사용과 제작을 분리하는 강력한 매커니즘
- 의존성 주입은 제어 역전 기법을 의존성 관리에 적용한 메커니즘이다.
- 제어역전에서는 한 객체가 맡은 보조 객체를 새로운 객체에게 전적으로 떠넘긴다.
- 새로운 객체는 넘겨받은 책임만 맡으므로 단일 책임 원칙을 지키게 된다.

의존성 관리 맥락에서는 객체는 의존성 자체를 인스턴스로 만드는 책임은 지지 않는다.  
대신에 이런 책임을 다른 "전담" 메커니즘에 넘겨야만한다.  
그렇게 함으로써 제어를 역전한다.  
초기 설정은 시스템 전체에서 필요하므로 "책임질" 메커니즘으로 "Main" 루틴이나 특수 컨테이너를 사용한다.  

```java

import java.sql.Connection;
import java.sql.DriverManager;

public class Application{
  public static void main(String[] args...){
    DBConnector connector = new  OracleConnect();

    FactoryCreator creator = new StatementFactory();

    QueryExecutor executor = new SelectExecutor();

    SqlParametVO voParameter = new SqlParametVO();

    voParameter.setSqlStatment("select * from tb_ab_user where rownum = 1")

    Object rsObj = executor.queryExecute(creator.createStmt(connector), voParameter);


  }
}

interface QueryExecutor{
  public Object queryExecute(Statement stmt, SqlParametVO vo);
}

class SelectExecutor implements QueryExecutor{
  public Object queryExecute(Statement stmt, SqlParametVO vo){

    esultSet rs = stmt.executeQuery(vo.getSqlStatment);

    return rs.getString("FirstName") + " " + rs.getString("LastName");
  }
}

interface FactoryCreator{
  public Statement createStmt(DBConnector connector);
}

class StatementFactory implements FactoryCreator{
  public Statement createStmt(DBConnector connector){

    Connection conn = connector.getConnection();

    Statement stmt = con.createStatement();

    return stmt;
  }
}

interface DBConnector{
  public Connection getConnection();
}

class MsSQLConnect implements DBConnector{
  public Connection getConnection(){
      // Create a variable for the connection string.
      String connectionUrl = "jdbc:sqlserver://:;databaseName=AdventureWorks;user=;password=";

      Connection con = DriverManager.getConnection(connectionUrl);

      return con;
    }
  }
}

class OracleConnect implements DBConnector{
  public Connection getConnection(){
      Connection con = conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORA92", "scott", "tiger");

      return con;
    }
  }
}

```

/*

프레임워크의 중요한 특성은 사용자가 정의한 메소드가 사용자의 어플리케이션 코드가 호출 하기보다 종종 프레임워크로 부터 호출 되어 진다는 것이다.  
프레임워크는 종종 어플리케이션의 행위를 재배치 하고, 순서를 정하는 메인프로그램의 역할을 담당한다. 
역전된 제어는 프레임워크가 확장된 뼈대를 제공하는 힘을 제공한다. 
사용자는 특정 어플리케이션을 위한 커스터마이즈된 알고리즘 메소드를 프레임워크에 전달한다. 

*/

# 확장 

**처음부터 올바르게** 시스템을 만들 수 있다는 믿음은 미신이다.  

우리는 오늘/내일/다음말에 주어진 사용자 스토리에 맞춰 시스템을 구현해야한다. 이는 애자일 방식의 햄식으로 TDD, 리팩터링, 깨끗한 코드는 코드 수준에서 시스템을 조정하고 확장하기 쉽게 만든다.  

하지만 시스템 수준에서는 단순한 아키텍처를 복잡한 아키텍처로 조금씩 키울 수 없다는 현실은 정확하다.  
소프트웨어 시스템은 물리적인 시스템과 다른다. 관심사를 적절히 분리해 관리한다면 소프트웨어 아키텍처를 점진적으로 발전할 수 있다.  
따라서 점진적인 발전을 위해서는 관심사를 적절히 분리할 수 있어야 한다.  

**횡단 관심사** 트랜잭션과 보안, 일부 영속적인 동작은 소스코드가 아닌 배치 기술자에 의해서 조정할 때, 애플리케이션의 자연스러운 객체 경계를 넘나드는 경향이 있는데, 이 때 모든 객체가 전반적으로 동일한 방식을 이용하게 만들어야 한다.  

**자바 프록시**  
자바 프록시는 단순한 상황에 적합하다. 개별 객체나 클래스에서 메서드 호출을 감싸는 경우가 좋은 예다.  
하지만 JDK에서 제공하는 동적 프록시는 인터페이스만 지원한다.  
클래스 프록시를 사용하려면 CGLIB, ASM, javassit 등과 같은 바이트 코드러 처리 라이브러리가 필요하다. 

# 테스트 주도 시스템 아키텍처 구축 


관점으로 관심사를 분리하는 방식은 그 위력이 막강하다. 애플리케이션 도메인 논리를 POJO로 작성할 수 있다면,
즉 코드 수준에서 아키텍처 관심사를 분리할 수 있다면, 진정한 테스트 주도 아키텍처 구축이 가능해진다.
그때그때 새로운 기술을 채택해 단순한 아키텍처를 복잡한 아키텍처로 키워나갈 수도 있다. BDUF(Big Design Up Front)를 추구할 필요가 없다.

**BDUF** : 요구사항이 정확히 정해져 있다는 가정에서 출발하기 때문이다.    
**ADUF** : 새로운 요구사항을 적용하기 위해서 바뀔 필요가 없는 시스템 군을 위한 일반화된 소프트웨어 디자인    

최선의 시스템 구조는 각지 POJO 객체로 구현되는 모듈화된 관심사 영역으로 구성된다. 이렇게 서로 다른 영역은 해당 영역 코드에 최소한의 영향을 미치는 관점이나 유사한 도구를 사용해 통합한다. 이런 구조 역시 코드와 마찬가지로 테스트 주도 기법을 적용할 수 있다.   

# 의사결정을 최적화 하라 

관심사를 모듈로 분리한 POJO 시스템은 기민함을 제공한다. 이런 기민함 덕택에 최신 정보에 기반해 최선의 시점에 최적의 결정을 내리기가 쉬워진다.  
또한 결정의 복잡성도 줄어든다.  

**모듈을 나누고 관심사를 분리하면 지엽적인 관리과 결정이 가능해진다.**. 

# 시스템은 도메인 특화 언어가 필요하다. 

도메인 특화 언어를 사용하면 고차원 정책에서 저차원 세부 사항에 이르기 까지 모든 추상화 수준과 모든 도메인을 POJO로 표현할 수 있다.   
DSL은 간단한 스크립트 언어나 표준 언어로 구현한 API를 가리킨다.     
DSL로 짠 코드는 모데인 전문가가 작성한 구조적인 산문 처럼 읽힌다.    

# 그래서 클린코드는 

시스템 역시 깨끗해야한다.    
깨끗하지 못한 아키텍처는 도메인 논리를 흐리며 기민성을 떨어뜨린다.    
도메인 논리가 흐려지만 제품 품질이 떨어진다.     
버그가 숨어들기 쉬워지고, 스토리를 구현하기는 어려워지는 탓이다.     
기민성이 떨어지면 생산성이 낮아져 TDD를 제공하는 장점이 사라진다.     
모든 추상화 단계에서 의도는 명확히 표현해야한다.     
그러려면 POJO를 작성하고 관점 혹은 관점과 유사한 매커니즘을 사용해 각 구현 관심사를 분리해야한다.    
시스템을 설계하든 개별 모듈을 설계하든, 실제로 돌아가는 가장 단순한 수단을 사용해야한다는 사실을 명심하자.    
