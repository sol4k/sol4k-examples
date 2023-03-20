package org.sol4kdemo;

import org.sol4k.Connection;
import org.sol4k.PublicKey;

public class GetWalletBalance {
    public static void main(String[] args) {
        var connection = new Connection("https://api.devnet.solana.com");
        var wallet = new PublicKey("DxPv2QMA5cWR5Xfg7tXr5YtJ1EEStg5Kiag9HhkY1mSx");
        var balance = connection.getBalance(wallet);
        System.out.println("Balance in Lamports: " + balance);
    }
}
