
/*
 * @author: Luke Walters, Joshua De La Rosa, Sam Bigham
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

public class BlockChainDriver {

    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        Block temp = null;

        if (args.length != 1) {
            pen.println("ERROR, incorrect number of arguments in command line");
            return;
        }

        int commandnum = Integer.parseInt(args[0]);

        System.out.println("Initializing BlockChain");
        BlockChain BC = new BlockChain(commandnum);

        String input = ""; // default
        do {
            System.out.println(BC.toString());
            System.out.println();
            pen.print("Command? ");
            pen.flush();
            Scanner myObj = new Scanner(System.in);
            input = myObj.nextLine();
            temp = switchStatement(input, BC, pen, myObj, temp);
        } while (!input.equals("quit"));

        pen.println("Ending program");
    } // main(String[] args)

    /*
     * the swtich statement used for the menu in main
     */
    public static Block switchStatement(String input, BlockChain BC, PrintWriter pen, Scanner myObj,
            Block temp) {
        switch (input) {
            case "mine": // need to get nonce and final print statement and maybe blck
                pen.print("amount transferred? ");
                pen.flush();
                int minenum = myObj.nextInt();
                try {
                    temp = BC.mine(minenum);
                } catch (NoSuchAlgorithmException e) {
                    System.err.println("mine failed");
                    e.printStackTrace();
                }

                pen.println("amount = " + temp.getAmount() + " nonce = " + temp.getNonce());
                break;
            case "append": // tricky as it needs nonce and amount of money
                pen.println("Amount transfered? " + temp.getAmount());
                pen.println("Nonce " + temp.getNonce());
                BC.append(temp);
                break;
            case "remove":
                System.out.println(BC.removeLast());
                break;
            case "check": // may not work as it does it on BC, and not the last element of BC
                if ((BC.isValidBlockChain())) {
                    System.out.println("Chain is Valid!");
                } else {
                    System.out.println("Chain is Invalid!");
                }
                break;
            case "report":
                BC.printBalances();
                break;
            case "help":
                pen.print(
                        "Valid commands: \n \t mine: discovers the nonce for a given transaction\n"
                                + "\t append: appends a new block onto the end of the chain \n \t remove: removes the last block from the end of the chain\n"
                                + "\t check: checks that the block chain is valid \n \t report: reports the balances of Alexis and Blake \n"
                                + "\t help: prints this list of commands \n \t quit: quits the program \n");
                break;
            case "quit":
                break;
        }

        return temp;
    } // switchStatement(String input, BlockChain BC, PrintWriter pen, Scanner myObj, Block temp)

} // class BlockChainDriver
