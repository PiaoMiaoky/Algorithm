package com.hellojava.produerConsumer_pattern;

public class SteamBread {
    public int id;
    @Override
    public String toString() {
        return "SteamBread{" +
                "id=" + id +
                '}';
    }
    public SteamBread(int id){
        this.id = id;
    }

}
