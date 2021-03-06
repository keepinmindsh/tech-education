# Network

컴퓨터 네트워크는 컴퓨터와 컴퓨터가 연결되어 서로 정보를 주고 받을 수 있는 물리적인 인프라를 말합니다.   
이러한 컴퓨터 네트워크는 하드웨어와 운영체제 그리고 응용 소프트웨어의 결합으로 동작하면 표준화된 규격을 통해 정의되어 있습니다.

![Network_Flow](https://github.com/keepinmindsh/tech-education/blob/main/assets/Network_Flow.png)

- 브라우저 
  - HTTP 리퀘스트 메시지를 작성한다. 
  - 웹 서버의 IP 주소를 DNS 서버에 조회한다. 
  - 전 세계의 DNS 서버가 연대한다. 
  - 프로토콜 스택에 메시지 송신을 의뢰한다.

- TCP/IP, LAN 드라이버 
  - 소켓을 작성한다. 
  - 서버에 접속한다. 
  - 데이터를 송,수신 한다. 
  - 서버에서 연결을 끊어 소켓을 말소한다. 
  - IP와 이더넷의 패킷 송,수신 동작 
  - UDP 프로토콜을 이용한 송,수신 동작
  
- 허브, 라우터 
  - 케이블과 리피터, 허브 속을 신호가 흘러간다. 
  - 스위칭 허브의 패킷 중계 동작 
  - 라우터의 패킷 중계 동작 
  - 라우터의 부가기능

- 전화국, 통신사, 대용량 광섬유, 통신사, 전화국, 엑세스 회선 
  - ADSL 기술을 이용한 액세스 회선의 구조와 동작 
  - 광섬유를 이용한 액세스 회신(FTTH)
  - 엑세스 회선으로 이용하는 PPP와 터널링 
  - 프로바이더의 내부 
  - 프로바이더를 경유하여 흐르는 패킷

- 방화벽, 캐시 
  - 웹 서버의 설치 장소 
  - 방화벽의 원리와 동작 
  - 복수 서버에 리퀘스트를 분배한 서버의 부하 분산 
  - 캐시 서버를 이용한 서버의 부하 분산 
  - 콘텐츠 배포 서비스
  
- 웹서버 소프트웨어, TCP/IP, LAN 드라이버 
  - 서버의 개요 
  - 서버의 수신 동작 
  - 웹 서버 소프트웨어가 리퀘스트 메시지의 의미를 해석하여 요구에 응한다. 
  - 웹 브라우저가 응답 메세지를 받아 화면에 표시한다.

# DNS 

도메인 이름 시스템(DNS)은 사람이 읽을 수 있는 
도메인 이름(예: www.amazon.com)을 머신이 읽을 수 있는 IP 주소(예: 192.0.2.44)로 변환합니다.

![DNS Flow](https://github.com/keepinmindsh/tech-education/blob/main/assets/dns_flow.png)

1. 사용자가 웹 브라우저를 열어 주소 표시줄에 www.example.com을 입력하고 Enter 키를 누릅니다.
2. www.example.com에 대한 요청은 일반적으로 케이블 인터넷 공급업체, DSL 광대역 공급업체 또는 기업 네트워크 같은 인터넷 서비스 
제공업체(ISP)가 관리하는 DNS 해석기로 라우팅됩니다.
3. ISP의 DNS 해석기는 www.example.com에 대한 요청을 DNS 루트 이름 서버에 전달합니다.
4. ISP의 DNS 해석기는 www.example.com에 대한 요청을 이번에는 .com 도메인의 TLD 이름 서버 중 하나에 다시 전달합니다.
.com 도메인의 이름 서버는 example.com 도메인과 연관된 4개의 Amazon Route 53 이름 서버의 이름을 사용하여 요청에 응답합니다.
5. ISP의 DNS 해석기는 Amazon Route 53 이름 서버 하나를 선택해 www.example.com에 대한 요청을 해당 이름 서버에 전달합니다.
6. Amazon Route 53 이름 서버는 example.com 호스팅 영역에서 www.example.com 레코드를 찾아 웹 서버의 IP 주소 192.0.2.44 등 
연관된 값을 받고 이 IP 주소를 DNS 해석기로 반환합니다.
7. ISP의 DNS 해석기가 마침내 사용자에게 필요한 IP 주소를 확보하게 됩니다. 해석기는 이 값을 웹 브라우저로 반환합니다.
또한, DNS 해석기는 다음에 누군가가 example.com을 탐색할 때 좀 더 빠르게 응답할 수 있도록 사용자가 지정하는
일정 기간 example.com의 IP 주소를 캐싱(저장)합니다.
8. 웹 브라우저는 DNS 해석기로부터 얻은 IP 주소로 www.example.com에 대한 요청을 전송합니다. 여기가 콘텐츠가 있는 곳으로,
예를 들어 웹 사이트 엔드포인트로 구성된 Amazon S3 버킷 또는 Amazon EC2 인스턴스에서 실행되는 웹 서버입니다.
9. 192.0.2.44에 있는 웹 서버 또는 그 밖의 리소스는 www.example.com의 웹 페이지를 웹 브라우저로 반환하고,
웹 브라우저는 이 페이지를 표시합니다.

# 패킷의 기본

패킷은 ‘헤더’와 ‘데이터’의 두 부분으로 구성됩니다.  
헤더는 수신처를 나타내는 주소 등의 제어 정보가 들어 있는데, 이 부분은 택배의 전표와 같은 것입니다. 그리고 그 뒤에 의뢰처에서 의뢰한 데이터가 이어지는데, 이것이 화물의 내용물에 해당합니다.

![Packet](https://github.com/keepinmindsh/tech-education/blob/main/assets/packets.png)

헤더에 기록된 수신처 정보를 결합하여 패킷의 목적지를 판단하고 여러 곳으로 분배합니다.


# OSI 7 계층

OSI 모형(Open Systems Interconnection Reference Model)은 국제표준화기구(ISO)에서 개발한 모델로,   
컴퓨터 네트워크 프로토콜 디자인과 통신을 계층으로 나누어 설명한 것이다. 일반적으로 OSI 7 계층이라고 한다.

## 목적

이 모델은 프로토콜을 기능별로 나눈 것이다. 각 계층은 하위 계층의 기능만을 이용하고, 상위 계층에게 기능을 제공한다.  
'프로토콜 스택' 혹은 '스택'은 이러한 계층들로 구성되는 프로토콜 시스템이 구현된 시스템을 가리키는데,   
프로토콜 스택은 하드웨어나 소프트웨어 혹은 둘의 혼합으로 구현될 수 있다. 일반적으로 하위 계층들은 하드웨어로,   
상위 계층들은 소프트웨어로 구현된다.

- 통신이 일어나는 과정을 단계별로 파악
- 네트워크 트래핑의 흐름을 파악할 수 있음
- 상호 이질적인 네트워크 간의 연결에 어려움이 많은데 호환성 결여를 막기 위해 OSI 참조 모델이 제시되었다.
- 네트워크 구성 요소를 표준화 함으로써 타업체의 장비 개발과 지원이 가능해 진다.

## UPPER Layer

### Layer 7

- 응용 계층 ( Application Layer )

OSI의 최상위 7계층인 응용 계층은 사용자 또는 어플리케이션이 네트워크에 접근할 수 있도록 해줍니다.

- 데이터 단위 : Data
- 인터넷 프로토콜 슈트
  - HTTP, SMTP, FTP, 텔넷, NFS, NTP

### Layer 6

- 표현 계층 ( Presentation Layer )

표현 계층은 응용 계층으로부터 전달받거나 전송하는 데이터의 인코딩 및 디코딩이 이루어지는 계층입니다. MIME 인코딩이나 암호화 동작이 이루어지죠

- 데이터 단위 : Data
- 인터넷 프로토콜 슈트
  - XDR

### Layer 5

- 세션 계층 ( Session Layer )

세션 계층은 네트워크상 양쪽 연결을 관리하고 연결을 지속시켜주는 계층입니다. 세션을 만들고 유지하며, 세션 종류, 전송 중단시 복구하는 기능이 있습니다.

- 데이터 단위 : Data
- 인터넷 프로토콜 슈트
  - TCP 세션 관리 부분

## Lower Layer

### Layer 4

- 전송 계층 ( Transport Layer )

전송 계층에서는 데이터를 전송하고 전송 속도를 조절하며 오류가 발생된 부분은 다시 맞춰주는 계층입니다.

- 데이터 단위 : Segments
- 인터넷 프로토콜 슈트
  - TCP, UDP, RTP, SCTP

### Layer 3

- 네트워크 계층 ( Network Layer )

네트워크 계층은 전송 데이터를 목적지까지 경로를 찾아가는 계층입니다.

주소(IP)를 정하고, 경로(Route)를 선택하고, 패킷을 전달하는 것이 가능 핵심인 계층입니다.

- 데이터 단위 : Packets
- 인터넷 프로토콜 슈트
  - IP, ICMP, IPsec, ARP, RIP, BGP

### Layer 2

- 데이터 링크 계층 ( Data Link Layer )

데이터 링크 계층은 물리적인 네트워크 사이에 Data 전송을 담당하는 계층입니다.

- 데이터 단위 : Frames

### Layer 1

- 물리 계층 ( Physical Layer )

물리 계층은 통신 케이블을 통해 전기 신호를 사용하여 비트 스트림을 전송하는 계층입니다.

비트는 물리계층에서 사용되는 단위로서, 0과 1로 구분되는, 전기 신호 ON/OFF로 생각할 수 있다.

- 데이터 단위 : Bits


# 핑
핑은 종종 지연 속도와 혼동되곤 합니다. 핑은 네트워크를 통해 한 컴퓨터에서 전달되어 다시 돌아오는 신호를 뜻합니다. 신호가 왕복한 값을 측정하는 것이 바로 지연 속도입니다.

# 지연 속도
렉 또는 딜레이로도 알려진 지연 속도는 사용자 기기에서 게임 서버로 데이터 패킷이 전달되는 시간(밀리초)을 뜻합니다.

# 패킷 손실
패킷 손실은 하나 이상의 데이터 패킷이 네트워크를 통해 전송될 때 목적지에 도달하지 못하면 발생합니다. 전송 패킷 대비 손실 패킷을 백분율로 측정한 값이 패킷 손실이며 측정값이 2.5%를 넘지 않는 것이 바람직합니다.

# 네트워크 통신
### 연결 지향 통신

서버와 클라이언트가 연결되면 한쪽에서 명시적으로 끊을 때까지 계속 지속해서 연결을 유지하는 방식이다.

- TCP 연결 
  - 데이터 유실을 방지하고 완전한 전송을 보장하지만 상대적으로 느린 연결 방식
- UDP 연결 
  - 데이터의 완전한 전송을 보장하지 않지만 상대적으로 빠른 연결 방식

### 비연결 지향 통신

비연결성 프로토콜은 요청이 들어오면 이에 맞는 응답을 보낸 후 바로 연결을 종료한다. 
비연결 방식이라 아예 연결을 하지않는 것이 아니라 단지 연결을 유지하지 않는다는 뜻이다

- SOAP (Simple Object Access Protocol) 방식
  - HTTP / HTTPS / SMTP 등의 프로토콜을 통해 양쪽에서 XML 형태의 메세지를 주고 받도록 구현된 프로토콜
- RESTful (Representational State Transfer) 방식
  - 자원을 정의하고 자원에 대한 주소를 관리하는 방법, REST원리에 따라 구현된 시스템


> 참조 : https://aws.amazon.com/ko/route53/what-is-dns/  
> 참조 : 성공과 실패를 결정하는 1%의 네트워크 원리 