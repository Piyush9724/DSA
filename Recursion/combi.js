const combinations = (elements) => {
    if( elements.length === 0 )
        return ( [ [] ] );
    const firstEl = elements[0];
    const rest = elements.slice(1);
    let combsWithoutFirst = combinations(rest);
    let combsWithFirst = [];

    combsWithoutFirst.forEach( comb => {
        let combWithFirst = [...comb, firstEl];
        combsWithFirst.push(combWithFirst);
    });

    return [...combsWithoutFirst, ...combsWithFirst];
}

const obj = ['c','b','a'];
const result = combinations(obj);
console.log(result);