# 总结

## 1. 数组

### 二分查找

模板:(我就固定使用如下边界条件了)

```java
// right在右边界永远无法取到,因此区间为**左闭右开**区间,这将导致以下后果
// 1. while里面的判断条件是小于号
// 2. 如果target <  nums[mid], 说明目标数在左侧,需要缩小右边界,此时缩小后的右边界依旧无法取到,因此right = // mid
// 3. 无论怎么变,left的变化都是mid + 1
int left = 0, right = nums.length;
while(left < right){}
```

注意:求mid的时候,如果用位运算,其优先级低于加减乘除

$mid = left + (right - left >> 2)$

二分查找有时候会去查目的元素在最左侧的位置和最右侧的位置,如下:

诀窍在于判断的条件,假设要找最左侧,当target == num[mid]的时候,依然要向左找,因为左边可能还有,找最右侧的时候同理,但是这可能会引发两个最远端的时候的情况:

1. 当找最左侧位置时,活动的index指标为right: 如果这个right处于极限右侧的初始状态(right == nums.length),则说明数组内无该元素   如果处于极限左侧,数组内可能有,可能没有,需要判断nums[right] == taget.
2. 当找最右侧位置时,活动的index指标为left - 1:  如果left在极限左侧的初始状态(left == 0),则数组内无该元素  如果在极限右侧,需要判断nums[left - 1] == target

> 最左侧位置:
>
> ```java
> public int binaryLeft(int[] nums, int target){
>   int left = 0;
>   int right = nums.length;
>   while (left < right){
>     int mid = left + (right - left >> 1);
>     if (target <= nums[mid]){
>       right = mid;
>     } else {
>       left  = mid + 1;
>     }
>   }
>   // 得到左侧逼近的极限index后，如果这个index在极限左侧，这个index可能不是nums里面的数字，需要判断这个index的值和target是否相等
>   // 如果这个index在极限右侧，需要判断index是否超出数组
>   if (right == nums.length){
>     return -1;
>   }
>   return  nums[right] == target ? right : -1;
> }
> ```
>
> 最右侧位置:
>
> ```java
> public int binaryRight(int[] nums, int target){
>   int left = 0;
>   int right = nums.length;
>   while (left < right){
>     int mid = left + (right - left >> 1);
>     if (target >= nums[mid]){
>       left = mid + 1;
>     } else {
>       right = mid;
>     }
>   }
>   //如果极限右侧超出数组范围，需要判断left - 1是否等于最右边的那个值
>   //如果极限右侧在最左边，left == 0，说明
>   // if (target >= nums[mid]){
>   //                left = mid + 1;
>   //            }
>   //就没进去过，否则left至少要加个1，left == 0足以证明target不在数组中，在数组左侧，直接返回-1
>   if (left == 0){
>     return -1;
>   }
>   return nums[left - 1] == target ? left - 1 : -1;
> }
> ```



### 牛顿法开根号

根据一阶泰勒展开公示: f(x) = f(x0) + (x - x0) * f(x0)'

求根.即x ^ 2 = a

即f(x) = x ^ 2 - a  -> 令f(x) = 0  -> 即  x ^ 2 - a = 0

代入一阶泰勒,得出x1 = (x0 + a / x0) / 2

注意: 一开始的时候需要初始化一个x0,随便写一个数,比如1.0

```java
public int mySqrt(int x) {
  //Newton methos
  double startX = 1.0;
  while (Math.abs(startX * startX - x) > 0.1){
    startX = (startX + x / startX) / 2;
  }
  return (int) startX;
}
```

此外,开根号还可以用二分法来做

```java
public int mySqrt(int x){
  // 二分法
  if (x == 1) {
    return 1;
  }
  double left = 0;
  double right = x;
  double mid = left + (right - left) / 2;
  while (Math.abs(mid * mid - x) > 0.01){
    if (mid * mid < x){
      left = mid;
    } else if (mid * mid > x){
      right = mid;
    } else {
      return (int)mid;
    }
    mid = left + (right - left) / 2;
  }
  return (int)mid;
}
```











