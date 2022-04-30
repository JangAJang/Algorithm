function sum(num1, num2){ //내부함수
    return num1+num2;
};
const result = sum(10, 20);
console.log(result);

const answer = (num1, num2)=> num1+num2;
const dab = answer(20, 20);
console.log(dab);

const getObj = () =>({name:"철수", age:20});
const obj = getObj();
console.log(obj.name);