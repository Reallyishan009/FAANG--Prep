const rps = (p1,p2)=>{
    if(p1===p2){
        return "Draw";
    }

    var rules ={rock:"scissors",scissors:"paper",paper:"rock"};
    if(p2=== rules[p1]){
        return "Player 1 won!";
    }
    else return "Player 2 won!";
}