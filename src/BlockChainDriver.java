package src;

import java.io.PrintWriter;
import java.util.Scanner;

import BlockChain;

import java.security.NoSuchAlgorithmException;

public class BlockChainDriver {

    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);

        if (args.length != 1) {
            pen.println("ERROR, incorrect number of arguments in command line");
            return;
        }

        int commandnum = Integer.parseInt(args[0]);
        try {
            BlockChain BC = new BlockChain(commandnum); // currently gets stuck in a loop (Can't figure out why)
            printInfo(BC, pen);

            String input = "";
            do {
                pen.print("Command?");
                Scanner myObj = new Scanner(System.in);
                input = myObj.nextLine();
               int res = switchStatement(input, BC, pen, myObj);
               


            } while (!input.equals("quit"));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        pen.println("Ending program");
    }

    public static void printInfo(BlockChain BC, PrintWriter pen) {
        pen.println(BC.initial);
        for (int i = 0; i < BC.getSize(); i++) {
            pen.println(BC.curNode);
        }
    }
    public static int switchStatement(String input, BlockChain BC, PrintWriter pen, Scanner myObj){
                int finalnum = 1;
                switch (input) {
                    case "mine":    //need to get nonce and final print statement and maybe blck
                        pen.println("amount transferred?");
                        int minenum = myObj.nextInt();
                        try {
                            BC.mine(minenum);
                        } catch (NoSuchAlgorithmException e) {
                            System.err.println("mine failed");
                            e.printStackTrace();
                        }
                        break;
                    case "append": //tricky as it needs nonce and amount of money
                        
                        break;
                    case "remove":
                        BC.removeLast();
                        break;
                    case "check": //may not work as it does it on BC, and not the last element of BC
                        BC.isValidBlockChain();
                        break;
                    case "report":
                        BC.printBalances();
                        break;
                    case "help":
                        pen.print("Valid commands: \n \t mine: discovers the nonce for a given transaction\n" + 
                        "\tappend: appends a new block onto the end of the chain \n \t remove: removes the last block from the end of the chain\n" +
                        "\t check: checks that the block chain is valid \n \t report: reports the balances of Alexis and Blake \n" + 
                        "\t help: prints this list of commands \n \t quit: quits the program \n");
                        break;
                    case "quit":
                        break;
                }
                return finalnum;
    }

}
