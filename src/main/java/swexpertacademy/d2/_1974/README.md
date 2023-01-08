## 주요 조건
- 9 x 9 스토쿠 퍼즐
- 모든 숫자는 1이상 9이하의 정수

## 개념
### 9 x 9 배열을 3 x 3 배열로 쪼개기
```text
   for (int startRow = 0; startRow < 9; startRow += 3) {
       for (int startColumn = 0; startColumn < 9; startColumn+=3) {
           for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                       //...
                }
            }
       }
   }
```