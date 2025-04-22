package blockchain;

import java.util.ArrayList;

public class Blockchain{
    protected static int id;
    private ArrayList<Block> list;

    public Blockchain (){
        id=0;
        list = new ArrayList<>();
    }

    public ArrayList<Block> getList(){
        return this.list;
    }

    
    //The class Blockchain should have at least two methods:
    // the first one generates a new block in the blockchain and
    // the second one validates the blockchain and returns true if the blockchain is valid.

    public void generateBlock(int numOfZeros){
        Block newBlock;
        if(list.size()==0)
            newBlock = new Block("0", numOfZeros);
        else
            newBlock = new Block(list.get(list.size()-1).getHash(), numOfZeros);
        list.add(newBlock);
    }

    public boolean validateBlockchain(){
        for(int i = 1; i < list.size();i++){
            if(!list.get(i).getPrevHash().equals(list.get(i-1).getHash()))
                return false;
        }
        return true;
    }
}