# 자료 추상화 

추상 인터페이스를 제공해 사용자가 구현을 모른채 자료의 핵심을 조작할 수 있어야 진정한 의미의 추상 클래스다. 

```java

public interface Star {
    public void blingbling();
}

```

```java

public class Sirius implements Star {
    public void blingbling(){
        System.out.println("시리우스");
    }
}

```
자료를 세세하게 공개하기 보다는 추상적인 개념으로 표현하는 것이 좋다. 


> [추상화(Abstraction)](https://github.com/keepinmindsh/dream_tech_education/blob/main/00_mind/dv_basic/README.MD)

# 객체지향/절차지향의 상호 보완적인 관계 

절차지향과 객체지향은 상호 보완적인 관계가 존재한다.   
절차적인 코드는 기존 자료 구조를 변경하지 않으면서 새 함수를 추가하기 쉽다.   
반면, 객체지향 코드는 기본 함수를 변경하지 않으며서 새 클래스를 추가하기 쉽다. 

#### 절차지향 vs 객체지향

- **절차지향 코드는 새로운 자료 구조를 추가하기 어렵다. 그러려면 모든 함수를 고쳐야 한다.** 

```java
public class Square {
  public Point topLeft;
  public double side;
}

public class Rectangle {
  public Point topLeft;
  public double height;
  public double width;
}

public class Circle {
  public Point center;
  public double radius;
}

public class Geometry {
  public final double PI = 3.141592653589793;

  public double area(Object shape) throws NoSuchShapeException {
    if( shape instanceof Square ){
      Square s = (Square)shape;
      return s.side * s.side;
    }
    else if ( shape instanceof Rectangle) {
      Rectangle r = (Rectangle)shape;
      return r.height * r.width;
    }
    else if ( shape instanceof Circle) {
      Circle c = (Circle)shape;
      return PI * c.radius * c.radius;
    }

    throw new NoSuchShapeException();
  }
}
```
  
- **객체지향 코드는 새로운 함수를 추가하기 어렵다. 그러려면 모든 클래스를 고쳐야한다.** 

```java
public interface Shape {
    double area();
}

public class Square implements Shape {
  private Point topLeft;
  private double side;

  public double area(){
    return side * side;
  }
}

public class Rectangle implements Shape {
  private Point topLeft;
  private double height;
  private double width;

  public double area() {
    return height * width;
  }
}

public class Circle implements Shape {
  private Point center;
  private double radius;
  public final double PI = 3.141592653589793;

  public double area() {
    return height * width;
  }
}
```

> 객체지향 코드에서 어려운 변경은 절차적인 코드에서 쉬우며, 절차적인 코드에서 어려운 변경은 객체지향 코드에서 쉽다.  
> 객체는 동작을 공개하고 자료를 숨긴다. 그래서 기본 동작을 변경하지 않으면서 새 객체의 타입은 추가하기는 쉬운 반면에  
> 기존의 객체에 새 동작을 추가하기는 어렵다.

#### 절차지향시 고려할 수 있는 대안 

노련한 객체지향 설계자는 VISITOR 패턴 등을 통해서 문제를 해결할 수 있다. 

- Visitor Pattern

```java
package DesignPattern.gof_visitor.sample04;

public class PrintDemo {

    public static void main(String[] args) {

        Caller caller = new Caller();

        caller.accept(new InputPrintVisitor());
        caller.accept(new LoadPrintVisiter());
        caller.accept(new OutputPrintVisitor());
    }
}
```

```java
public interface PrintVisitor {
  public void visit(Front front );
  public void visit(POS pos);
  public void visit(WEB web);
  public void visit(Kiosk kiosk);
}

public class OutputPrintVisitor implements PrintVisitor {
    
  @Override
  public void visit(Front front) {
      System.out.println("프론트 출력했습니다.");
  }

  @Override
  public void visit(POS pos) {
      System.out.println("포스를 출력했습니다.");
  }

  @Override
  public void visit(WEB web) {
      System.out.println("웹을 출력했습니다.");
  }

  @Override
  public void visit(Kiosk kiosk) {

  }
}

public class LoadPrintVisiter implements PrintVisitor
{

    @Override
    public void visit(Front front) {
        System.out.println("프론트 데이터를 호출했습니다.");
    }

    @Override
    public void visit(POS pos) {
        System.out.println("포스 데이터를 호출했습니다.");
    }

    @Override
    public void visit(WEB web) {
        System.out.println("웹 데이터를 호출했습니다.");
    }

    @Override
    public void visit(Kiosk kiosk) {

    }
}

public class InputPrintVisitor implements PrintVisitor {

  @Override
  public void visit(Front front) {
      System.out.println("프론트 데이터를 입력했습니다.");
  }

  @Override
  public void visit(POS pos) {
      System.out.println("포스 데이터를 입력했습니다.");
  }

  @Override
  public void visit(WEB web) {
      System.out.println("웹 데이터를 입력했습니다.");
  }

  @Override
  public void visit(Kiosk kiosk) {

  }
}
```

```java
public interface PrinterElement {
  public void accept(PrintVisitor printVisitor);
}


public class Caller implements PrinterElement {

  List<PrinterElement> printList;

  public Caller(){

      printList = new ArrayList<>();

      printList.add(new Front());
      printList.add(new POS());
      printList.add(new WEB());
  }

  @Override
  public void accept(PrintVisitor printVisitor) {
      printList.forEach( value -> {
          value.accept(printVisitor);
      });
  }
}


public class WEB implements PrinterElement {
  @Override
  public void accept(PrintVisitor printVisitor) {
      printVisitor.visit(this);
  }
}

public class POS implements PrinterElement {
  @Override
  public void accept(PrintVisitor printVisitor) {
      printVisitor.visit(this);
  }
}

public class Kiosk implements PrinterElement {
  @Override
  public void accept(PrintVisitor printVisitor) {
      printVisitor.visit(this);
  }
}

public class Front implements PrinterElement {
  @Override
  public void accept(PrintVisitor printVisitor) {
      printVisitor.visit(this);
  }
}
```

#### 객체지향 - 디미터의 법칙 

모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다는 법칙이다. 클래스의 성향이 자료구자나 객체냐에 따라 달라짐. 
객체로 고려하여 작성된 코드 일 경우, 추상적일 필요가 있음.   

> 디미터 법칙을 위반하는지 여부는 ctxt, Options, scratchDir 이 객체인지 아니면 자료구조인지에 달렸다.  
> 객체라면 내부 구조를 숨겨야 하므로 확실히 디미터의 법칙을 위반한다.    
> 반면, 자료구조라면 당연히 내부 구조를 노출하므로 디미터의 법칙이 적용되지 않는다.

- 추천하지 않는 호출 방식 

```java
class Sample{
    public static void main(String[] args) {
        final string outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
    }
}
```

- 추천하는 호출 방식 

```java
class Sample {
    public static void main(String[] args) {
        Options opts = ctxt.getOptions();
        File scratchDir = opts.getScratchDir();
        final String outputDir = scratchDir.getAbsolutePath();
    }
}
```

> 우리가 알고 있는 메서드 체이닝은 전부 본인 자신을 리턴하는 방식이고, 위의 기차 출동을 반환하는 값마다   
> 자료구조가 달라진다. 

#### 자료 전달 객체

- DAO( Data Access Object) : DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트 
- DTO( Data Transfer Object ) : VO로 바꿔 말할 수 있는데, 계층간 데이터 교환을 자바빈즈를 말한다. 
  - 여기서 계층간은 컨트롤러, 뷰, 비즈니스 계층을 말하며 각 계층 간의 데이터 교환을 위한 객체 
  - 데이터 베이스와 통신하거나 소켓에서 받은 메시지의 구문을 분석할 때 유용하다. 
  - 데이터 베이스에 저장된 가공되지 않은 정보를 애플리케이션 코드에서 사용할 객체로 변환하는 일련의 단계에서 가장 처음으로 사용하는 구조체.

# Java 내의 규칙 

#### 오류코드 보다는 예외를 사용하라. 

```java
class Sample {
    private DeviceHandle getHandle(DeviceId id) throws Exception{
        throw new DeviceShutdownError("Invalid handle for : " + id.toString());
    }    
}
```

#### Try-Catch-Finally

예외에서 프로그램 안에다 범위를 정의한다는 사실은 매우 흥미롭다.   
try-catch-finally 문에서 try 블록에 들어가는 코드를 실행하면   
어느 시점에서든 실행이 중단된 후 catch 블록으로 넘어갈 수 있다.  

어떤 면에서 try 블록은 트랜잭션과 비슷하다.  
try 블록에서 무슨 일이 생기든지 catch 블록은 프로그램 상태를 일관성 있게 유지해야 한다.    
그러므로 예외악 발생할 코드를 짤 때는 try-catch-finally 문으로 시작하는 편이 낫다.  
그러면 try 블록에서 무슨일이 생기든지 호출자가 기대하는 상태를 정의하기 쉬워진다.

- Try-Catch-Finally 를 사용하는 예제 

```java
class Sample{
    
  @Test(expected = StorageException.class)
  public void retrieveSectionShouldThrowOnInvalidFileName(){
    sectionStore.retrieveSection("invalid - file");
  }

  public List<RecordedGrip> retrieveSection(String sectionName){
    try{
      FileInputStream stream = new FileInputStream(sectionName);
      stream.close();

    }catch(FileNotFoundException e){
      throw new StorageException("retrieval error", e);
    }

    return new ArrayList<RecordedGrip>();
  }
}
```

- Try-with-Resources 활용시 

```java
class Sample {
  public static void viewTable(Connection con) throws SQLException {

    String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

    try (Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        String coffeeName = rs.getString("COF_NAME");
        int supplierID = rs.getInt("SUP_ID");
        float price = rs.getFloat("PRICE");
        int sales = rs.getInt("SALES");
        int total = rs.getInt("TOTAL");

        System.out.println(coffeeName + ", " + supplierID + ", " +
                price + ", " + sales + ", " + total);
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    }
  }    
}

```

#### 미확인 예외를 사용하라. 

확인된 예외는 OCP를 위반한다.  
메서드에서 확인된 예외를 던졌는데 catch 블록이 세 단계 위에 있다면 그 사이 메서드 모두가 선언부에 해당 예외를 정의해야 한다.   
즉, 하위 단계에서 코드를 변경하면 상위 단계 메서드 선언부를 전부 고쳐야 한다는 말이다.   
확인된 예외를 위해서 메서드에 선언하는 구체적인 예외는 캡슐화를 깨트린다.  

```java
class Sample {
  public static void main(String[] args) throws Exception {
      try {
          handle();      
      }catch (Exception exception){
          throw new Exception();
      }
  }
  
  private static void handle() throws Exception {
      try {
          doSomething();
      }catch (Exception exception){
          throw new Exception();
      }
  }
  
  private static void doSomething(){
    System.out.println("Print Sample");
  }
}
```
#### 예외에 의미를 제공하라.

예외를 던질때는 전수 상황을 충분히 덧붙인다.   
그러면 오류가 발생한 원인과 위치를 찾기가 쉬워진다.   
자바는 모든 예외에 호출 스택을 제공한다.  
하지만 실패한 코드의 의도를 파악하라면 호출 스택 만으로 부족하다.   
오류 메세지에 정보를 담아 예외와 함께 던진다. 실패한 연산 이름과 실패 유형도 언급한다. 

```java
class Sample{
  public static void main(String[] args) {
    doWithException();
  }
  
  private void doWithException() throws Exception{
      try{
          File file = new File("/Users/dream/download/read.txt");
      }catch (Exception exception){
          throw new CustomException("Exact Error");
      }
  }
}
```

