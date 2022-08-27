
const callFunc = () => {
    console.log("Hello!")
}

callFunc();

const restFunc = (x, ...y) => {
    // y is an Array
    return x * y.length;
}

console.log(restFunc(3, "hello", true) == 6);

const spreadFunc = (x, y, z) => {
    return x + y + z;
}
// Pass each elem of array as argument
console.log(spreadFunc(...[1,2,3]) == 6);

if(true){
    let value = 100;
}

const constValue = 100;

function func(){

    if(true){
        let value = 100;
    }

    console.log(value);
}


func();