# sol4k demo [![Build](https://github.com/sol4k/sol4k-demo/actions/workflows/build.yml/badge.svg)](https://github.com/sol4k/sol4k-demo/actions/workflows/build.yml)

You can find ready-to-use Java examples of sol4k APIs. Each class
in this repository is a complete example that you can load and run
without any additional setup.

## Content

1. [Sending a SOL transfer transaction](src/main/java/org/sol4kdemo/SolTransfer.java).
2. [Sending a SOL transfer transaction (Legacy Transaction)](src/main/java/org/sol4kdemo/SolTransferLegacyTransaction.java).
3. [Sending a transaction with multiple instructions](src/main/java/org/sol4kdemo/TransactionWithMultipleInstructions.java).
4. [Creating an Associated Token Account](src/main/java/org/sol4kdemo/CreateAssociatedTokenAccount.java).
5. [Transferring SPL tokens](src/main/java/org/sol4kdemo/SplTransfer.java).
6. [Getting Wallet Balance](src/main/java/org/sol4kdemo/GetWalletBalance.java).
7. [Getting SPL Token Balance](src/main/java/org/sol4kdemo/GetSplBalance.java).
8. [Request Airdrop](src/main/java/org/sol4kdemo/RequestAirdrop.java).

## How to import sol4k

Check [the main Sol4k repository](https://github.com/sol4k/sol4k#how-to-import)
to find information on how to add Sol4k to your existing codebase.

## Funding Test Accounts

To ensure that the examples are readily usable, they include
the private key of the test account. However, it is important
to note that committing your private keys to version control
is never recommended for real projects, and is only done here
for convenience purposes.

As anyone has access to the private key of the test account,
which is `2mjCPF5ABp6CVAYHd5azz5A8cKQUqqvuiT5NJ4wpAjCc`, it may
run out of funds. If you encounter issues with some of the
examples, please ensure that this account has sufficient funds,
either in SOL or USDC. You can use [this code
snippet](src/main/java/org/sol4kdemo/RequestAirdrop.java)
to send Devnet SOL, while for USDC, you can utilize
[this faucet](https://spl-token-faucet.com/?token-name=USDC).
