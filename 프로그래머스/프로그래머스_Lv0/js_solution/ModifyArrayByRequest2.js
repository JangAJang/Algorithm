// 조건에 맞게 수열 변환하기 2 

function solution(arr) {
    newArr = modifyArray(arr);
    count = 0;
    while(!isSameArray(arr, newArr)) {
        count++;
        arr = newArr;
        newArr = modifyArray(newArr);
    }

    return count;
}

function modifyArray(arr) {
    var newArr = [];
    for(index = 0; index < arr.length; index++) {
        if( arr[index] >= 50 && arr[index] % 2 ==0 ) {
            newArr[index] = arr[index]/2;
            continue;
        }

        if( arr[index] < 50 && arr[index] % 2 != 0) {
            newArr[index] = arr[index]*2 + 1;
            continue;
        }

        newArr[index] = arr[index];
    }

    return newArr;
}

function isSameArray(arr, newArr) {
    if( arr.length != newArr.length) {
        return false;
    }

    for(index = 0; index < arr.length; index++) {
        if(arr[index] != newArr[index]) {
            return false;
        }
    }

    return true;
}

