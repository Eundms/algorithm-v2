## 주요 조건

- 9 ≤ N ≤ 199
- N은 홀수
- 중간값 구하기

> N이 홀수이므로, 중간값은 무조건 1개이다.

## 개념

### [1] 배열 정렬

### 1) 기본 정렬 : 숫자, 문자(알파벳)

#### (1) 내림차순 정렬

- `Arrays.sort(배열,Collections.reverseOrder())`== `Arrays.sort(배열,(a,b)->b-a)`

#### (2) 부분 정렬

- `Arrays.sort(배열,시작 인덱스, 마지막 인덱스)` : 시작 인덱스와 마지막 인덱스를 포함하는 배열만 정렬

### 2) `Comparator` 구현한 정렬

#### 예) 문자열 길이 순서로 정렬

```java
    String[]배열={"Apple","Kiwi","Orange","Banana","Watermelon","Cherry"};
        Arrays.sort(배열,new Comparator<String>(){
    @Override
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    }
    });
```

### 3) 객체 정렬

```java
public class Army implements Comparable<Army> {
    private String name;
    private int rank; // rank 1이 제일 높음
    private int power; // power 숫자가 크면 큼

    @Override
    public String toString() {
        return "{name: " + name + ", rank: " + rank + ", power:" + power + "}";
    }

    @Override
    public int compareTo(@NotNull Army army) {
        if (this.rank == army.rank) {
            return army.power - this.power; // 내림차순
        }
        return this.rank - army.rank; //오름차순
    }
}
```
### [2] List 정렬
#### `Comparator.comparingInt()`
```java
public class ListSort{
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.sort(Comparator.comparingInt(Integer::intValue));
    }
}
```
### [3] 중간값

- 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값