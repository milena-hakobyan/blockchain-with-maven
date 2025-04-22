package blockchain;

import java.util.Date;

public class Block {
    private int id;
    private String hash; //the hash of a block is a hash of all fields of a block
    private String prevHash;
    private long timeStamp;//every block should contain a timestamp representing the time the block was created
    private int magic;
    private double generationTime;
    private final int numOfZeros;

    public Block(String prevBlockHash, int numOfZeros){
        this.numOfZeros = numOfZeros;
        this.id = ++Blockchain.id;
        this.prevHash = prevBlockHash;
        this.hash = generateHashCode();
        this.timeStamp = new Date().getTime();
        this.magic = 0;
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

    public String generateHashCode() {
        String target = "0".repeat(numOfZeros); // e.g. "0000"
        String temp = "";

        long startTime = System.currentTimeMillis(); // Start timing

        while (!temp.startsWith(target)) {
            temp = StringUtil.applySha256(prevHash + this.id + this.timeStamp + magic);
            magic++;
        }

        long endTime = System.currentTimeMillis(); // End timing
        generationTime = (endTime - startTime) / 1000.0;

        return temp;
    }



    //printing a block with the given format
    public void printBlock() {
        System.out.println("Block:");
        System.out.println("Id: " + getId());
        System.out.println("Timestamp: " + getTimeStamp());
        System.out.println("Hash of the previous block:\n" + getPrevHash());
        System.out.println("Hash of the block:\n" + getHash());
        System.out.println("Block was generating in " + generationTime + " seconds");
        System.out.println();
    }
}