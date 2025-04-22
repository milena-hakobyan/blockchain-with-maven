package blockchain;

import java.util.Date;

public class Block {
    private int id;
    private String hash; //the hash of a block is a hash of all fields of a block
    private String prevHash;
    private long timeStamp;//every block should contain a timestamp representing the time the block was created
    int magic;

    public Block(String prevBlockHash){
        this.id = ++Blockchain.id;
        this.prevHash = prevBlockHash;
        this.hash = StringUtil.applySha256(prevHash+this.id+this.timeStamp);
        this.timeStamp = new Date().getTime();
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) { this.hash = hash;}

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getPrevHash() { return prevHash;}

    public void setPrevHash(String prevHash) { this.prevHash = prevHash;}

    public long getTimeStamp() { return timeStamp;}

    public void setTimeStamp(long timeStamp) { this.timeStamp = timeStamp;}


    //printing a block with the given format
    public void printBlock() {
        System.out.println("Block:");
        System.out.println("Id: " + getId());
        System.out.println("Timestamp: " + getTimeStamp());
        System.out.println("Hash of the previous block:\n" + getPrevHash());
        System.out.println("Hash of the block:\n" + getHash());
        System.out.println();
    }
}
