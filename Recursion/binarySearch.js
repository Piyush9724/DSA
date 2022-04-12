let z =0;
function getMoreAndLess() {
  //code here
  arr = [1, 2, 8, 10, 11, 12, 19];
  //arr = [3,3,3];
  let index = binarySearch(arr, 0, arr.length - 1, 23);
  console.log(index);
  console.log(z);
  return [];
}

function binarySearch(arr, l, r, x) {
  if (r < l) {
      z = l;
      return false;
  }
  let mid  = Math.floor((l+r)/2);
  if (arr[mid] == x) return mid;
  if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
  return binarySearch(arr, mid + 1, r, x);
}
getMoreAndLess();
