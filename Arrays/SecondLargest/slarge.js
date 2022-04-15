function print2Largest(arr, n) {
    let s = new Set(arr);
    if (s.size === 1){
        return -1;
    } else {
        let largest = Number.MIN_VALUE;
        let slarge = Number.MIN_VALUE;
        for (let i = 0; i < n; i++) {
            if (arr[i] > largest) {
                slarge = largest;
                largest = arr[i];
            } else if(arr[i]> slarge && arr[i]!== largest){
                slarge = arr[i];
            }
        }
        return slarge;
    }
}


console.log( print2Largest([7, 8, 10, 1, 9, 3], 6));
//console.log( print2Largest([2,2,2,2,2,2], 6));