
# **Báo cáo độ phứt tạp thuật toán Insertion Sort**

## **Mô tả thuật toán**
```java
int []InsertionSort(int []arr)
{
    int countAssign = 0; int countCompare = 0;
    int i, j, key, numLength;
	numLength = arr.length; countAssign++;
    for (j = 1; j < numLength; j = j + 1)
    {
        countAssign++; countCompare++;
        key = arr[j]; countAssign++;
        for (i = j - 1; ((i >= 0) && (arr[i] < key)); i = i - 1)
        {
            countAssign++; countCompare += 2;
            arr[i+ 1] = arr[i]; countAssign++;
        }
        countAssign++; countCompare += 2;
        arr[i + 1] = key; countAssign++;
    }
    countAssign++; countCompare++;
    int []result = {countAssign, countCompare};
    return result;
}
```
## **Phân tích thuật toán**

Nhìn vào thuât toán trên, ta có thể thấy:

*Số phép countAssign* = 1 + 4\*(numLength – 1) + 2 + 1.

*Số phép countCompare* = 3\*(numLength – 1) + 2 + 1.

T(j): là số lần lặp vòng while.

Từ đó, có thể suy ra:

- **Trường hợp tốt nhất:** T(j) = 0. Tức là mảng đã được sắp xếp giảm dần.

	Độ phứt tạp là tuyến tính O(n).

	Khi đó:

	*Số phép countAssign* = 1 + 4\*(numLength – 1) + 1.

	*Số phép countCompare* = 3\*(numLength – 1) + 1.

- **Trường hợp xấu nhất:** T(j) ≈n(n – 1). Tức là mảng được sắp xếp tăng dần.

	Độ phứt tạp là O(n­2).

	Khi đó:

	*Số phép countAssign* ≈ 1 + 4\*(numLength – 1) + n(n – 1) + 1.

	*Số phép countCompare* ≈ 3\*(numLength – 1) + n(n – 1) + 1.

- **Trường hợp trung bình:** tùy vào sự phân bố dữ liệu của mảng.

	Độ phứt tạp cũng là O(n­2).

## **Kết luận và nhận xét**

So với bảng số liệu thống kê của kết quả thực thi thuật toán, có thể thấy kết quả hoàn toàn nằm trong dự kiến với số phép gán và số phép so sánh sát với kết quả tính toán lý thuyết. Chỉ riêng trường hợp trung bình thì phụ thuộc vào sự sắp xếp dữ liệu của mảng.

Về mặt bằng chung thì thuật toán InsertionSort có độ phứt tạp là O(n2).
```
