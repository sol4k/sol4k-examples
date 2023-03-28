package org.sol4kdemo;

import org.sol4k.Connection;
import org.sol4k.PublicKey;
import org.sol4k.RpcUrl;

public class GetSplBalance {
    public static void main(String[] args) {
        var connection = new Connection(RpcUrl.DEVNET);
        var receiverAssociatedAccount = new PublicKey("73d3sqQPLsiwKvdJt2XnnLEzNiEjfn2nreqLujM7zXiT");
        var balance = connection.getTokenAccountBalance(receiverAssociatedAccount);
        System.out.printf(
                "SPL balance. Formatted: %s, amount: %d, decimals: %d, ",
                balance.getUiAmount(),
                balance.getAmount(),
                balance.getDecimals()
        );
    }
}
