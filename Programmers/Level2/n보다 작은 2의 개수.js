function solution(n) {
   const oneCount = (n) => {
       let count = 0;
       while (n != 0) {
           n % 2 == 1 ? count++ : count;
           n = parseInt(n / 2);
       }
       return count;
   }

   const oneCountWithCount = (n, cnt) => {
       let count = 0;
       while (n != 0) {
           n % 2 == 1 ? count++ : count;
           n = parseInt(n / 2);

           if (count > cnt) {
               return 0;
           }
       }
       return count;
   }

   const getFactorialNum = (n) => {
       if (n < 1) {
           return 0;
       }

       let result = 1;
       for (let i = 1; i <= n; i++) {
           result *= i;
       }
       return result;
   }

   const getCombinationNum = (n, r) => {
       if (n < r) {
           return 0;
       }
       if (r === 0 || n === r) {
           return 1;
       }

       return getFactorialNum(n) / (getFactorialNum(r) * getFactorialNum(n - r));
   }

   const getExtraCount = (n, length, count) => {
       let result = 0;
       for (let i = Math.pow(2, decimalLength - 1) + 1; i < n; i++) {
           if (oneCountWithCount(i, count) === count) {
               result++;
           }
       }
       return result;
   }

   let decimalLength = n.toString(2).length;
   let count = oneCount(n);
   let answer = getCombinationNum(decimalLength - 1, count);
   answer += getExtraCount(n, decimalLength, count);

   return answer;
}
