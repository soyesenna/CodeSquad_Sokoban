# CodeSquad_Sokoban

## V1전략
1. 입력으로 주어진 문자열을 전부 받는다
2. 받은 문자열을 파싱할 수 있는 클래스를 만든다
3. 문자열을 위의 클래스로 넘겨서 파싱한다
4. 파싱하여 얻은 정보(각 오브젝트의 개수)를 HashMap에 저장한다
   1. ex ) "#" : 11
5. 파싱한 맵 정보를 List\<List\<Integer>>에 저장한다
6. 파싱 정보를 HashMap에 저장한다
   1. ex ) 4 : "#"
7. 파싱된 정보가 저장되어 있는 리스트와 맵을 활용하여 화면에 출력해준다

## 사용할 클래스
## SokobanMap
### variables
- parsedMap
  - type : List\<List\<Integer>>
  - 입력으로 주어진 소코반 맵 문자열을 파싱하여 정수형태로 저장
- sokobanMapCount
  - type : Map\<Character, Integer>
  - 파싱 과정에서 얻은 각각의 오브젝트 개수를 저장한다
  - "#" : 11
    - #이 11개 있다는 뜻
- originMap
  - type : List\<String>
  - 원래 맵 정보를 저장한다
- playerIdx
  - type : int[]
  - 플레이어의 위치를 저장

### methods
- constructor()
  - member variable들의 초기화를 수행한다
  - 나머지는 객체만 할당해준다
- printOriginMap()
  - parameter : none
  - return : void
  - originMap에 저장되어 있는 List\<String>을 화면에 출력한다
- printMapInfo()
  - parameter : none
  - return : void
  - SokobanMap의 정보를 출력해준다
    - 플레이어의 index, 오브젝트의 수
- findColSize()
  - parameter : none
  - return : int
  - access modifier : private
  - 



## ParsingTool

### methods
- parse(SokobanMap, Map\<Character, Integer>)
  - parameter : SokobanMap, Map\<Character, Integer>
  - return : void
  - access modifier : public
  - 파싱을 수행하는 메서드
  - 오브젝트의 수와 플레이어의 인덱스도 여기서 확인한다
- findPlayer(SokobanMap)
  - parameter : SokobanMap
  - return : void
  - access modifier : private
  - 플레이어의 index를 찾는 메서드



## SokobanManager
### variables
- parsedMapWithRound
  - type : Map\<Integer, SokobanMap>
  - 라운드에따라 SokobanMap객체를 저장한다
- br
  - type : BufferedReader
  - 입력을 받기위한 스트림변수
- parsingInfo
  - type : final Map\<Character, Integer>
  - 파싱 정보를 저장한다

### methods
- input()
  - parameter : none
  - return : List\<String>
  - access modifier : private
  - throw : IOException
  - 맵의 입력을 받는 메서드
- startMapping()
  - parameter : none
  - return : void
  - access modifier : public
  - throw : IOException
  - 사용자의 입력과 파싱을 시작하는 메서드
- printMapAndInfo()
  - parameter : none
  - return : void
  - access modifier : public
  - 소코반 맵을 스테이지별로 출력해준다
- makeSokobanMapWithRound(List\<String>)
  - parameter : List\<String>
  - return : void
  - access modifier : private
  - input으로 받은 문자열 리스트를 통해 스테이지를 구별하고 스테이지별 SokobanMap객체를 만든다
  - 또한, 해당 SokobanMap객체에 originMap을 저장한다

--- 
## V2 전략
- Sokoban 맵을 입력받는건 기존 클래스에서 수행
- GameManager 클래스를 만들어서 SokobanManager를 맴버 변수로 포함

## GameManager
### variables
- br
  - type : BufferedReader
  - 입력을 받기위한 스트림변수
- sokobanManager
  - type : SokobanManager
  - SokobanMap의 입력과 출력을 총괄하는 변수

### methods
- inputCommand()
  - parameter : none
  - return : String
  - access modifier : private
  - 사용자의 입력을 받는 메서드

## SokobanManager
## 추가된 methods
- getSokobanMapWithRount(int)
  - parameter : int
  - return : SokobanMap
  - access modifier : public
  - 라운드를 parameter로 받아서 해당 라운드의 SokobanMap을 반환해주는 메서드
  

## SokobanMap
## 추가된 메서드
- printParsedMap()
  - parameter : none
  - return : void
  - access modifier : public
  - parsedMap을 char로 변환해서 출력해주는 메서드
- change(int[], int[])
  - parameter : int[], int[]
  - return : void
  - access modifier : public
  - parameter로 받은 두 인덱스의 오브젝트를 교환하는 메서드
  - 