//원시형 변수
let number = 1; //int
let str = "abc"; //string
let bool = true; //boolean
let undi = undefined; //undifined, 아무것도 부여하지 않으면 undifined로 선언됨.
let nul = null; //null, 사용자가 명시적으로 비어졌다고 선언할 때 쓰임.
let symbol = Symbol(); //symbol

//참조형 변수
let array=[]; //배열
let obj = {}; //객체
let obje = {
    korean:90, english:80, math:70, science:60
};//객체에서 키에 따른 값들을 입력한다. 
let func = function(){}; //함수

console.log(typeof(func));
console.log(obje.korean); //객체.키 를 이용해 값을 출력 할 수 있다. 
console.log(obje["english"]); //객체["키"]를 이용해도 된다. 이 때에는 키의 이름은 문자열로 작성한다. 