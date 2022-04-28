const combinations = (elements) => {
    if( elements.length === 0  ) return [ [] ];
    const firstEl = elements[0];
    const combsWithoutFirst = combinations(elements.slice(1));
    const combsWithFirst = [];

    combsWithoutFirst.forEach((comb) => {
        let combWithFirst = [...comb, firstEl];
        combsWithFirst.push(combWithFirst);
    });

    return [...combsWithoutFirst,...combsWithFirst]

}

const obj = ['c','b','a'];
const result = combinations(obj);
console.log(result);