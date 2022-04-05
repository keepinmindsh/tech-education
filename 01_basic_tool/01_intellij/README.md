# IntelliJ 활용하기 

## Mac 일 경우

| **키** 기호 | **키** 명칭 | 참고 |
| ------------- | ------------- | ------------- |
| ⌘  | Command 키  | 일부 Apple 키보드의 경우 Apple() 로고가 있습니다. |
| ⌃  | Control 키  ||
| ⌥  | Option 키  |일부 Apple 키보드의 경우 'alt'가 표시되어 있습니다.|
| ⇧  | Shift 키  ||

## Setting

- Darcula Setting 

## Plugins

- [Material UI](https://plugins.jetbrains.com/plugin/8006-material-theme-ui)
- [Key Promoter X](https://plugins.jetbrains.com/plugin/9792-key-promoter-x)
- [Grep Console](https://plugins.jetbrains.com/plugin/7125-grep-console/)
- [.ignore](https://plugins.jetbrains.com/plugin/7495--ignore/)
- [Rainbow Brackets](https://plugins.jetbrains.com/plugin/10080-rainbow-brackets)

## Shortcuts  

- **IDE Setting 열기** 

```text
Win/Linux - Ctrl + Alt + S 
MacOS -  ⌃ + ⌥ + S
```

- **무엇이든 수정할 수 있습니다.**
  - 코드에서 오류가 발생한 경우 해당 오류 위에 커서를 놓고 Alt + Enter를 누르면 문제에 대한 수정 제안 목록이 표시됩니다.
    - 경고나 제안에서도 사용이 가능함.
    - 람다식일 경우에 개인의 선호도에 따라 더 길거나 짧은 코드로 변경할 수 있음.
    - static import 등에서 사용 가능

```text
Win/Linux - Alt + Enter
MacOS - ⌥  + Enter
```

- **제안을 탐색할 때 마우스를 사용하는 것은 다소 불편할 수 있습니다.**
  - F2를 활용해 다음 오류, 경로, 제안으로 이동해보세요. 

```text
F2
```

- **도구 창을 열 때도 마우스가 필요하지 않습니다.**
  - 방향키를 사용해 트리를 탐색하고, 타이핑하여 검색할 수 있습니다. 

```text
Win/Linux - Alt + 1
MacOS - ⌘ + 1
```

- **에디터로 다시 초점을 옮길 수 있음**
  - 도구창에서 Esc를 누르면 에디터로 돌아와 다시 코드에 집중할 수 있습니다. 
  - 변경 사항을 적용하지 않고 모든 팝업을 닫는 데 유용합니다. 

```text
Esc
```

- **가장 최근에 열었던 파일을 확인하기**
  - 최근 파일 대화 상자가 열려 방향키로 파일을 탐색할 수 있습니다. 
  - 대화 상자 내에서 화살표키를 이용해 다른 항목을 선택이 가능합니다.
  - 키보드의 키를 입력하면 대화상자 내의 범위에서 항목 조회도 가능합니다.

```text
Win/Linux - Ctrl + E
MacOS - ⌘ + E
```

- **심볼의 선언으로 이동하기**
  - 코드에서 코드 내로 이동하는 것이 가능합니다. 
  - 해당 단축키를 사용하면 커서가 필드의 선언으로 이동합니다. 

```text
Win/Linux - Ctrl + B
MacOS - ⌘ + B
```

- **구현을 탐색하기**
  - 추상 계층이 아닌 구현부를 찾기 때문에 항목이 2개 이상인 경우, 목록으로 표시됩니다. 

```text
Win/Linux - Ctrl + Alt + B
MacOS - ⌘ + ⌥  + B
```

- **선언을 검색하는 것이 아닌 사용 위치를 검색하는 경우가 있습니다.**
  - 이는 커서의 항목이 사용되는 모든 사용 위치가 표시됩니다. 
  - 선언 또는 인터페이스를 구현한 클래스를 비롯하여 해당 인터페이스가 사용된 모든 위치가 검색창에 표시됩니다.

```text
Win/Linux - Alt + F7
MacOS - ⌥ + F7 
```

- **터미널 바로 열기**

```text
Win/Linux - Alt + F12
MacOS - ⌥ + F12
```

- **디버깅 걸고, 해제하기**

```text
Win/Linux - Ctrl + F8
MacOS - ⌘ + F8
```

- **어떤 위치에 있든 혹은 어떤 파일이 열려 있든, Run Anything 창이 열립니다.**
  - 최근에 실행한 실행 구성 목록이 표시됩니다. 
  - open 은 프로젝트를 열 수 있는 하나의 예제입니다.  

```text
Ctrl + Ctrl 
```  

- **코드의 섹션에 대해서 확장하거나 축소할 수 있습니다.**
  - 포커스된 커서에서 확장 및 축소를 단축키 사용에 의해서 단계적으로 확장된 섹션의 유효한 표현식을 자동으로 선택합니다.

```text
Win/Linux - Ctrl + W, Ctrl + Shift + W
MacOS - ⌥ + 위아래 방향키 
```

- **간편하게 주석을 추가할 수 있습니다.**
  - 코드가 줄 주석으로 변합니다. 
  - 주석이 작성된 곳에서 다시 단축키를 누르면 주석이 해제됩니다.  

```text
Win/Linux - Ctrl + / 
MacOS - ⌘ + /  
```

- **선택된 블록에 대해서 주석을 추가할 수 있습니다.**
  - 코드가 선택된 줄 범위 전체가 주석으로 변합니다. 
  - 주석이 작성된 곳에서 다시 단축키를 누르면 주석이 해제됩니다.

```text
Win/Linux - Shift + Alt + / 
MacOS - ⌥ + ⌘ + / 
```

- **기본 자동 완성 기능입니다.**

```text
Win/Linux - Ctrl + Space
MacOS - ^ + Space
```

- **현재 구문을 완성하는 기능입니다.**
  - 코드를 작성 할 때 자동으로 문장을 완성합니다,
  - 예를 들어 루프를 작성할 경우 단축키를 누르면 IDEA가 중괄호를 추가하고 커서를 적절한 위치에 배치합니다.

```text
Win/Linux - Shift + Ctrl + Enter
MacOS - ⇧ + ⌘ + Enter
```

- **현재 파일의 서식을 프로젝트 표준에 맞춰줍니다.**

```text
Win/Linux - Ctrl + Alt + L 
MacOS - ⌥ + ⌘ + L
```

- **모든 리팩토링 항목을 표시합니다.**

```text
Win/Linux - Shift + Ctrl + Alt + T
MacOS - ⌃ + T
```

- **액션을 검색합니다.**
  - IntelliJ의 모든 액션을 검색할 수 있습니다. 
  - 해당 메뉴에서는 액션 뿐만 아니라 단축키도 표시되므로 단축키를 익히고 연습할 수도 있습니다. 

```text
Win/Linux - Shift + Ctrl + A 
MacOS - ⇧ + ⌘ + A
```

- **무엇이든 검색 가능한 검색 창이 표시됩니다.**
  - 검색 창에서 기본적으로 최근 파일이 표시되므로 ( Ctrl + E / ⌘ + E ) 대신 이 창을 활용할 수도 있습니다. 
  - 검색 창은 명령어도 지원합니다. 
  - Appearance(모양) 설정을 검색할 수 있습니다. 

```text
Shift + Shift 
```

- **해당 파일의 File Structure를 표시합니다.**
  - Win/Linux - Alt + 7
  - MacOS - ⌥ + 7

```text
Win/Linux - Ctrl + F12
MacOS - ⌘ + F12
```

- **해당 파일을 복사합니다.**

```text
F5
```

- **해당 파일을 이동시킵니다.**

```text
F6
```

- **변수를 추출합니다.**
  - 커서의 위치에 추출할 수 있는 변수이 존재할 경우, 값을 추출합니다. 

```text
Win/Linux - Ctrl + Alt + V
MacOS - ⌥ + ⌘ + V
```

- **필드를 추출합니다.**
  - 변수가 정의된 Scope의 범위에 따라 변수를 Class 멤버 변수로 추출 할 수 있습니다. 

```text
Win/Linux - Ctrl + Alt + F
MacOS - ⌥ + ⌘ + F
```

- **상수를 추출합니다.**
  - 변수/상수가 정의된 Scope의 범위에 따라 변수/상수를 Class의 상수로 추출할 수 있습니다.  

```text
Win/Linux - Ctrl + Alt + C
MacOS - ⌥ + ⌘ + C
```

- **메소드를 추출합니다.**
  - 지정된 블록에 대해서 메소드를 추출합니다.  

```text
Win/Linux - Ctrl + Alt + M
MacOS - ⌥ + ⌘ + M
```

- **메소드의 파라미터로 추출합니다.**
  - 메소드 내에 정의된 변수를 메소드의 파라미터로 추출할 수 있습니다. 

```text
Win/Linux - Ctrl + Alt + P
MacOS - ⌥ + ⌘ + P
``` 

- **실행 구성에 대한 실행**
  - Shift + F10 / ⌃ + R - 마지막으로 실행했던 실행 구성 실행 
  - Ctrl + Shift + F10 / ⌃ + ⇧ + R - 현재 커서가 있는 파일에 대한 실행 구성 실행 

```text
Win/Linux - Ctrl + Shift + F10/Shift + F10
MacOS - ⌃ + ⇧ + R/⌃ + R
```

- **탭에 대한 왼쪽/오른쪽 이동**

```text
Win/Linux - Alt + ← / Alt + → 
MacOS - ⌘ + ⇧ + [  /  ⌘ + ⇧ + ]
```

- **라인 단위 옮기기**

```text
Win/Linux: Alt + Shift + ↑↓
MacOS: ⌥ + ⇧ + ↑↓
```

- **구문 안에서만 라인 이동 ( 메서드를 벗어날 수 없음 )**

```text
Win/Linux: Ctrl + Shift + ↑↓
MacOS: ⌘ + ⇧ + ↑↓
```

- **메소드의 파라미터 인자 값 즉시 보기**

```text
Win/Linux: Ctrl + P
MacOS: ⌘ + P
```

- **코드 구현부 즉시 보기**

```text
Win/Linux: Ctrl + Shift+ i
MacOS: ⌥ + i
```

> [IntelliJ Shortcuts 링크](https://www.jetbrains.com/help/idea/2022.1/discover-intellij-idea.html)
