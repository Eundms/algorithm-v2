## 주요 조건
1. 0<= N <= 10000
2. 소수점 첫째 자리에서 반올림
## 개념
## [1] 반올림 방법
### 1. `Math.round(a)`
- 소수점 아래 `n+1자리`에서 반올림
- `(double) Math.round(a * 10의 n제곱 / 10의 n제곱)`

### 2. `String.format("%.2f",a)`

## [2] Java 나눗셈에 대한 이해
### 경우1. 모두 int 
> `/` : 몫 (==파이썬에서의 `//`)  
> `%` : 나머지 (==파이썬에서의 `%`)

### 경우2. 둘 중 하나라도 float, double
> 모두 실수형으로 표시됨

### 따라서, BigDecimal 클래스를 이용해서 정확한 연산을 진행한다.