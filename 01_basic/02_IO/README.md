# I/O란?

I/O는 입력(Input)/출력(Output)의 약자로, 컴퓨터 및 주변장치에 대하여 데이터를 전송하는 프로그램, 운영 혹은 장치를 일컫는 말입니다.
대개의 경우 입력에 함께 출력이 발생하게 됩니다. 단, 키보드와 마우스처럼 입력을 위한 기기, 프린터처럼 출력에만 사용되는 기기도 있습니다.
프로세서와 메모리, 확장 슬롯, 마더보드에서 일어나는 데이터 전송도 I/O라고 일컬어집니다.

## Input/Output

IO 장치들은 여러 문제가 있습니다.
- 다양한 주변 장치의 존재 
  - 서로 다른 데이터를 전송합니다. 
  - 서로 다른 속도로 동작합니다. 
  - 서로 다른 포맷을 가집니다. 
- CPU와 RAM보다 느립니다. 
- 입출력 모듈을 필요로 합니다. 

여기서 입출력 모듈이란 CPU와 메모리의 인터페이스이고, 하나 또는 그 이상의 주변 장치에 대한 인터페이스를 의미합니다. 보편적인 입출력 모듈의 모습은 아래와 같습니다. 

![IO Modules](https://github.com/keepinmindsh/tech-education/blob/main/assets/IO_Modules.png)

**각 LINE의 그룹을 BUS라고 한다.** 

- Address Lines(Bus)
  - CPU가 장치를 인식하기 위해서 필수 적인 것임. 각 장치에 부여하는 주소는 다 다르다. 
  - 장치를 식별하고 메모리를 CPU와 연결한다. 따라서 Address 버스가 더 많을 수록 더 많은 장치 연결이 가능하단 뜻이다.
- Data Lines(Bus)
  - 장치와 CPU가 서로 data를 주고 받기 위한 bus다. 
  - DATA LINE은 정보를 나른다. CPU의 평균 DATA BUS 사이즈는 8~64  정도이다. Data Bus는 양방향으로 주고 받는다. 메모리나 장치로부터 데이터를 받아야 하기 때문이다.
- Control Lines(Bus)
  - 각 디바이스에서 읽거나 쓰라는 신호를 보낸다. 

![IO Process](https://github.com/keepinmindsh/tech-education/blob/main/assets/IO_Process.png)

- CPU가 입출력 모듈 장치의 상태를 확인합니다.
- 입출력 모듈이 상태를 반환합니다.
- 만약 준비가 되었으면 CPU가 데이터를 전송합니다.
- 입출력 모듈은 장치로부터 데이터를 받도록 합니다.
- 입출력 모듈이 CPU로 데이터를 전송 시킵니다. 

### Programmed I/O
입출력 모듈 중에 프로그램 입출력은 IO로부터 제어권을 CPU가 가져와서 작업을 진행하는 것으로 CPU는 입출력 모듈이 명령어의 수행 완료를 기다립니다. 따라서 이 방식은 CPU의 시간을 소모합니다. 이는 위의 일반적인 입출력 모듈에서 추가적인 순서가 더 들어 갑니다.

- CPU가 입출력 명령을 요청합니다. 
- 입출력 모듈이 명령을 수행합니다. 
- 입출력 모듈이 상태 비트를 설정합니다. 
- CPU는 상태 비트를 주기적으로 확인합니다. 
- 입출력 모듈이 CPU에 직접적으로 알려주지 않습니다. 
- 입출력 모듈이 CPU에 인터럽트를 보내지 않습니다. 
- CPU는 기다리거나 나중에 다시 오도록 합니다.

### Memory mapped I/O
장치들과 메모리는 주소 공간을 공유합니다. 입출력은 메모리의 입출력과 비슷하게 동작합니다. 입출력에는 특별한 명령어를 필요로 하지 않습니다.

### Isolated I/O
이는 분리된 주소 공간을 사용합니다. 이들은 입출력 또는 메모리 선택 줄이 필요합니다. 그리고 입출력 명령을 필요로 합니다.

### Interrupt Driven I/O
CPU의 대기를 극복하기 위해 나온 방식으로 장치를 확인하기 위한 CPU의 반복 작업이 필요로 하지 않습니다.

입출력 모듈은 준비가 되면 인터럽트를 보내도록 합니다. 이것은 아래와 같은 알고리즘 하에서 동작을 하게 되며, 인터럽트를 발생시키는 주체는 입출력 모듈이고 처리하는 것은 CPU입니다. 

# 스트림 / 버퍼 / 채널

### 스트림

내 외부 장치와 프록그램 사이의 연결 통로로, 두 대상을 연결하고 데이터를 전송할 때 사용되는 통로이다. 

![Input Stream](https://github.com/keepinmindsh/tech-education/blob/main/assets/Input_Stream.png)

![Output Stream](https://github.com/keepinmindsh/tech-education/blob/main/assets/Output_Stream.png)

##### 스트림의 특징
- 단방향 통신으로 하나의 스트림으로 입출력을 동시에 할 수 없다. 
- FIFO 구조로써, 먼저 보낸 데이터가 먼저 받게 되어 데이터의 순서가 보장된다. 
- 블로킹(Blocking) 상태가 되어 입출력 진행시 다른 작업을 할 수 없도록 한다. 
- 입출력 대상을 변경하기 편하며 동일한 프로그램 구조를 유지할 수 있다. 

### 버퍼 
버퍼는 데이터를 저장할 수 있는 저장소로서 제한된 크기 안에 데이터를 수집하여 순서대로 데이터를 저장한다. 즉, 데이터를 미리 저장하여 
사용자에게 로딩 없이 데이터를 제공하기 위함이다. 하지만,
이외에도 데이터 통신을 할 때 저장된 데이터들을 한번에 이동시키기 위해 사용된다. 

![Output Stream](https://github.com/keepinmindsh/tech-education/blob/main/assets/Buffer.png)

**버퍼는 데이터를 저장하기 위한 것이지만 실제로는 입출력시 효과적인 이득을 가지고자 입출력에서 많이 사용된다.** 


IO/NIO 모두 사용되며 특히, 채널을 이용하는 NIO에서는 필수로 사용된다. 
NIO의 채널에서 소켓, 파일 등의 데이터를 전송할 때나 읽어올 대 버퍼를 사용하게 되면서 가비지량을 최소화 시키며 이는 
가비지 컬렉션의 회수를 줄임으로써 서버의 전체 처리량을 증가 시켜 준다. 

### 채널
스트림과 마찬가지로 채널 또한, 데이터의 입력 및 출력을 위한 연결 통로이다. 단, 스트림과 달리 양방향 통신을 지원하고 있다.
즉, 데이터를 전송할 때 생시는 Blocking 상태가 존재하지 않는다.

대신, 채널 같은 경우에는 반드시 버퍼를 연결해서 사용해야한다. NIO에서는 채널에 직접 쓰고 읽는 것을 허용하지 않느다.

반드시 채널에 버퍼를 연결해서 버퍼를 대상으로 쓰고 읽을 것을 요구한다.  

그렇기 때문에, 파일을 대상으로 채널의 데이터 경로는 아래와 같다.

- 입력 : 데이터 ← 버퍼 ← 채널 ← 파일
- 출력 : 데이터 → 버퍼 → 채널 → 파일

그리고, 채널과 스트림의 가장 큰 차이는 Non-Blocking을 지원한다는 것. 



### Stream vs Channel
기존의 Stream은 읽을 때와 쓸 때 InputStream과 OutputStream으로 구분해서 사용했다.
Stream을 통해 흘러다니는 데이터는 기본적으로는 byte 또는 byte[]이고, 읽고 쓰는 작업을 지시한 후에는 그 작업이 끝나야 return 되는 blocking 방식이다.
Channel은 데이터가 흘러다니는 통로라는 점에서 Stream과 역할은 비슷하지만 동작 방식이 다르다.
단방향인 Stream과는 달리 Channel은 양방향이라서 intput/output을 구분하지 않고 그냥 ByteChannel, FileChannel를 만들어서 읽을 수도 있고, 쓸 수도 있다.
Channel은 언제나 Buffer를 통해서만 데이터를 읽거나 쓸 수 있다.
Channel에서 데이터를 읽으면 Buffer에 담아야만 어떤 처리를 할 수 있고, Channel에 데이터를 쓰려면 먼저 Buffer에 담고, Buffer에 담긴 데이터를 Channel에 써야 한다.
Channel은 Non-blocking 방식도 가능하다.
다시 말하지만, Channel을 사용하는 I/O는 언제나 Non-blocking 방식으로 동작하는 것이 아니라, Non-blocking 방식도 가능하다는 것이다.

# InputStream/OutPutStream

### InputStream

- read - byte[]를 통해서 값을 읽어오며, 반환 값은 현재 값의 위치를 반환한다. 더 이상 읽을 수 있는 위치가 아닐 경우 -1을 반환한다. 
  - abstract int read() - input Stream에서 한 바이트 읽어서 int 값을 반환한다. 
  - int read(byte[] b) - byte[] b 만큼의 데이터를 읽어서 b에 저장하고 읽은 바이트 수를 반환한다. 
  - int read(byte{} b, int off, int len) - len 만큼 읽어서 byte[] b의 off 위치에 저장하고 읽은 바이트 수를 반환한다.

```java
private static void basicReadByte(InputStream inputStream) throws IOException {
    int readInt;
    while ((readInt = inputStream.read(readByte)) != -1) {
        String value = new String(readByte);

        System.out.print(value);
    }
}
```

- mark, reset - 구현체에 따라서 mark와 reset을 지원한다.  markSupported()는 mark 지원 여부를 반환한다. 

```java
private static void basicMarkReset(InputStream inputStream) throws IOException {
    int readInt;
    inputStream.mark(1000);
    while ((readInt = inputStream.read(readByte)) != -1){
        String value = new String(readByte);

        System.out.print(value);
    }
    inputStream.reset();
}
```

- available - 해당 InputStream의 읽을 수 있는 길이를 반환한다. 

```java
 private static void basicAvailable(InputStream inputStream) {
      try {
          int available = inputStream.available();

          System.out.println("available = " + available);
      } catch (Exception exception) {
          exception.printStackTrace();
      }
}
```

- skip - 해당 InputStream의 위치를 건너뛸 수 있다. 

```java
private static void basicSkip(InputStream inputStream) {
    try {
        inputStream.skip(1000);
    } catch (Exception exception) {
        exception.printStackTrace();
    }
}
```

- close - 현재 열려있는 Input Stream을 닫는다.

### OutputStream

OutPutStream은 바이트 기반의 출력 스트림의 최상위 클래스로 추상 클래스다. 
모든 바이트 기반 출력 클래스는 이 클래스를 상속 받아서 만들어진다. 

```java
OutputStream outputStream = null;
try {
      outputStream = new FileOutputStream("D:\\GIT\\templates_for_all\\01_java\\java_stream\\rc4.log");

    String content = "Value";

    outputStream.write(content.getBytes(StandardCharsets.UTF_8));

    outputStream.close();
} catch (Exception exception) {
    exception.printStackTrace();
}finally {
    if (outputStream != null) {
        try {
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

# 바이트/문자 스트림
### 바이트 스트림
- FileInputStream / FileOutputStream
- ByteArrayInputStream / ByteArrayOutputStream
- PipedInputStream / PipedOutputStream
- AudioInputStream / AudioOutputStream

### 바이트 보조 스트림
- FileInputStream / FileOutputStream
- BufferedInputStream / BufferedOutputStream
- DataInputStream / DataOutputStream
- SequenceInputStream
- LineNumberInputStream
- ObjectInputStream / ObjectOutputStream
- PrintStream
- PushbackInputStream

### 문자스트림
- FileReader / FileWriter
- CharArrayReader / CharArrayWriter 
- PipedReader / PipedWriter 
- StringReader / StringWriter

### 문자 보조 스트림
- FilterReader / FilterWriter
- BufferedReader / BufferedWriter
- LineNumberReader
- PrintWriter
- PushBackReader 

# NIO 
JDK4부터 java.io  패키지의 성능을 보강하기 위해 java.nio 패키지가 추가되었다. 그리고 뒤 이어서, JDK7 부터는 NIO.2 API가 java.nio.file 에 묶여서 추가되었다.


| **구분** | **IO** | **NIO** |
| ------------- | ------------- | ------------- |
| 입출력 방식  | 스트림 방식 | 채널 방식  |
| 버퍼 방식  | 넌 버퍼  | 버퍼 |
| 비동기 방식  | 지원 안 함  | 지원 |
| 블로킹 / 넌블로킹 방식  | 블로킹 방식만 지원  | 블로킹 / 넌블로킹 방식 모두 지원  |

### Paths / Files 

```java
package bong.lines;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesBasic {
    public static void main(String[] args) throws Exception {
        Path fp = Paths.get("C:\\Temp\\rc5.log");

        fp = Files.createFile(fp);

        Path dp1 = Paths.get("C:\\Temp\\sample");

        dp1 = Files.createDirectory(dp1);

        Path dp2 = Paths.get("C:\\Temp\\sample2");

        dp2 = Files.createDirectory(dp2);
    }
}
```

### Write String with Files 

```java
private static void writeStringToFileWithFiles() throws IOException {
  Path path = Paths.get("C:\\Temp\\rc5.log");

  String value1 = "Test Code1";
  String value2 = "Test Code2";
  String value3 = "Test Code3";

  List<String> list = Arrays.asList(value1, value2, value3);

  Files.write(path, list);

  List<String> findList = Files.readAllLines(path);

  System.out.println("findList = " + findList);
}
```

### Read All String with Files

```java
private static void readAllStringWithFiles() {
    String path = "C:\\Temp\\rc5.log";

    try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8)) {

        StringBuilder stringBuilder = new StringBuilder();
        String string = null;
        while ((string = bufferedReader.readLine()) != null) {
            stringBuilder.append(string).append("\n");
        }
        System.out.println("stringBuilder = " + stringBuilder);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

### Read All String with Files Lines

```java
private static void readAllStringWithFilesLines() {
  String path = "C:\\Temp\\rc5.log";

  try (Stream<String> lines = Files.lines(Paths.get(path), StandardCharsets.UTF_8) ) {

      StringBuilder stringBuilder = new StringBuilder();
      lines.forEach(s -> stringBuilder.append(s).append("\n"));
      System.out.println("stringBuilder = " + stringBuilder);
  } catch (Exception exception) {
      exception.printStackTrace();
  }
}
```

### Write String with Files 

```java
private static void writeStringToFileWithFilesSecondWay() throws IOException {
    String path = "C:\\Temp\\rc5.log";

    Files.writeString(Paths.get(path), "안녕하세요", StandardCharsets.UTF_8);
}
```

### Search files in Directory

```java
private static void fileSearchInDirectory() {
    String directoryPath = "D:\\GIT\\noticeboard_backend";

    List<Path> list = Collections.emptyList();

    try (Stream<Path> walk = Files.walk(Paths.get(directoryPath))) {

        list = walk.filter(Files::isReadable)
                .collect(Collectors.toList());

    } catch (Exception exception) {
        exception.printStackTrace();
    }

    list.forEach(System.out::println);
}
```

### try-with-resource

- Try-with-resources는 아래의 코드와 같이 try에 자원 객체를 전달하면, try 코드 블록이 끝나면 자동으로 자원을 종료해주는 기능이다.

```java
public static String tryCatchResource(String url) throws IOException {
    URL targetUrl = new URL(url);
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream()))){
        StringBuffer html = new StringBuffer();
        String tmp;

        while ((tmp = reader.readLine()) != null) {
            html.append(tmp);
        }
        return html.toString();
    }
}
```