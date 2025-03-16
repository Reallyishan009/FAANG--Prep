/* ARTHEMATIC SUM BETWEEN GIVEN NUMBERS:
n = number of terms = ∣b−a∣+1;
first = min(a, b)
last = max(a, b)
S=n/2*(fisrt+last);
*/

function getSum(a, b) {
    return ((Math.max(a, b) - Math.min(a, b) + 1) * (a + b)) / 2;
}
  