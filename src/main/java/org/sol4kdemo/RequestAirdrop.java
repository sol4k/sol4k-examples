package org.sol4kdemo;

import org.sol4k.Connection;
import org.sol4k.PublicKey;
import org.sol4k.RpcUrl;

public class RequestAirdrop {
    public static void main(String[] args) {
        var connection = new Connection(RpcUrl.DEVNET);
        var wallet = new PublicKey("2mjCPF5ABp6CVAYHd5azz5A8cKQUqqvuiT5NJ4wpAjCc");
        // note: this call can be rate-limited by the RPC node and fail from time to time
        var signature = connection.requestAirdrop(wallet, 1_000_000_000);
        System.out.println("Transaction Signature: " + signature);
    }
}
