var a = new Promise((resolve, reject) => {
    if(1) resolve(1);
    else resolve(-1);
});

var x = a;
console.log(x);